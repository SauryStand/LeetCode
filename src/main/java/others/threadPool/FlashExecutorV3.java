package others.threadPool;


import sun.tools.jconsole.Worker;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class FlashExecutorV3 implements Executor {

    private final BlockingQueue<Runnable> queues;

    public FlashExecutorV3(BlockingQueue<Runnable> queues, int workQueueSize) {
        this.queues = queues;
        // 直接创建 corePoolSize 个线程并启动
        for (int i = 0; i < workQueueSize; i++) {
            new Thread(new Worker()).start();
        }

    }


    @Override
    public void execute(Runnable command) {
        if (!queues.offer(command)) {
            // 如果队列满了，直接抛弃
            System.out.println("队列满了，直接抛弃");
        }
    }


    private final class Worker implements Runnable {

        @Override
        public void run() {
            Runnable task;
            while (true) {
                if ((task = getTask()) != null) {
                    task.run();
                }
            }
        }

        private Runnable getTask() {
            try {
                return (Runnable) queues.take();
            } catch (InterruptedException e) {
                return null;
            }
        }


    }


}
