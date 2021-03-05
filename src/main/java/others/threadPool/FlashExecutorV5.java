package others.threadPool;


import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 第五版
 * 1. 开始的时候和上一版一样，当 workCount < corePoolSize 时，通过创建新的 Worker 来执行任务。
 * 2. 当 workCount >= corePoolSize 就停止创建新线程，把任务直接丢到队列里。
 * 3. 但当队列已满且仍然 workCount < maximumPoolSize 时，不再直接走拒绝策略，而是创建非核心线程，直到 workCount = maximumPoolSize，再走拒绝策略。
 *
 *
 * https://www.cnblogs.com/flashsun/p/14368520.html
 * 关于线程池的案例https://github.com/aofeng/threadpool4j
 *
 */
public class FlashExecutorV5 extends ThreadPoolExecutor implements Executor {

    private AtomicInteger workCount = new AtomicInteger(0);

    private final HashSet<Worker> workers = new HashSet<>();

    private volatile int corePoolSize;

    private volatile int maximumPoolSize;

    private volatile long keepAliveTime;

    private TimeUnit timeUnit;
    // 由调用者提供的阻塞队列，核心线程数满了之后往这里放
    private final BlockingQueue<Runnable> workQueue;

    private volatile RejectedExecutionHandler handler;

    private volatile ThreadFactory threadFactory;

    public FlashExecutorV5(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.workQueue = workQueue;
        this.handler = handler;
        this.threadFactory = threadFactory;
    }

    @Override
    public void execute(Runnable command) {
        if (workCount.get() < corePoolSize) {
            addWorker(command);
            return;
        }
        if (!workQueue.offer(command)) {
            if (workCount.get() < maximumPoolSize) {
                addWorker(command);
                return;
            }
            handler.rejectedExecution(command, this);
        }
    }

    private void addWorker(Runnable command) {
        Worker worker = new Worker(command);
        workCount.incrementAndGet();
        workers.add(worker);
        worker.thread.start();
    }

    private final class Worker implements Runnable {

        final Thread thread;
        private Runnable task;

        private Worker(Runnable thread) {
            this.thread = threadFactory.newThread(thread);
        }


        @Override
        public void run() {

            while (task != null || (task = getTask()) != null ) {
                task.run();
                task = null;
            }
            workCount.getAndDecrement();
        }

        private Runnable getTask() {
            boolean timed = workCount.get() > corePoolSize;
            try {
                return timed ? workQueue.poll(keepAliveTime, timeUnit) : workQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

    }



}
