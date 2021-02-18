package others.threadPool;



import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FlashExecutorV4 extends ThreadPoolExecutor implements Executor {

    private final HashSet<Worker> workers = new HashSet<>();

    private final BlockingQueue<Runnable> queue;

    private volatile ThreadFactory threadFactory;

    private int corePollSize;

    private volatile RejectedExecutionHandler handler;

    private AtomicInteger workCount = new AtomicInteger(0);

//    public FlashExecutorV4(BlockingQueue<Runnable> queue, ThreadFactory threadFactory, int corePollSize, RejectedExecutionHandler handler) {
//        this.corePollSize = corePollSize;
//        this.queue = queue;
//        this.handler = handler;
//        this.threadFactory = threadFactory;
//    }

    public FlashExecutorV4(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, BlockingQueue<Runnable> queue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.corePollSize = corePollSize;
        this.queue = queue;
        this.handler = handler;
        this.threadFactory = threadFactory;
    }


    @Override
    public void execute(Runnable command) {
        if (workCount.get() < corePollSize) {
            Worker worker = new Worker(command);
            workCount.incrementAndGet();
            workers.add(worker);
            worker.thread.start();
        } else {
            if (!queue.offer(command)) {
                // 放入队列失败，走拒绝策略
                handler.rejectedExecution(command, this);
            }
        }


    }


    private final class Worker implements Runnable {
        final Thread thread;
        private Runnable task;
        Worker (Runnable firstTask) {
            this.task = firstTask;
            this.thread = threadFactory.newThread(this);
        }


        // 死循环从队列里读任务，然后运行任务
        @Override
        public void run() {
            while (task != null || (task = getTask()) != null) {
                task.run();
                task = null;
            }
        }

        private Runnable getTask() {
            try {
                return queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

    }


}
