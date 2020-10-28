package algorithm.thread;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName MyThreadPool
 * @Description Todo
 * @Date 2020/10/28 16:27
 * @Author voyager2511
 * @Email
 */
public class MyThreadPool {
    private static final int WORK_NUM = 5;
    private static final int TASK_NUM = 100;
    private int workNum;
    private int taskNum;
    private final Set<WorkThread> workThreads;
    private final BlockingQueue<Runnable> taskQueue;


    private class WorkThread extends Thread{
        public WorkThread(String name){
            super();
            setName(name);
        }
        @Override
        public void run(){
            while (!interrupted()){
                Runnable runnable = null;
                try {
                    runnable = taskQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (runnable != null){
                    System.out.println(getName() + " prepare to execute" + runnable.toString());
                    runnable.run();
                }
                runnable = null;//help gc?
            }
        }
        public void stopWork(){
            interrupt();
        }
    }

    /**
     * run a task by adding element into BlockingQueue
     * @param task
     */
    public void execute(Runnable task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyThreadPool(int workNum, int taskNum){
        if (workNum <= 0){
            workNum = WORK_NUM;
        }
        if (taskNum <= 0){
            taskNum = TASK_NUM;
        }
        this.workNum = workNum;
        this.taskNum = taskNum;
        taskQueue = new ArrayBlockingQueue<Runnable>(taskNum);
        workThreads = new HashSet<WorkThread>();
        for (int i = 0; i < workNum; i++){
            WorkThread workThread = new WorkThread("thread_" + i);
            workThread.start();
            workThreads.add(workThread);
        }
    }

    static class MyTask implements Runnable{
        private String name;
        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task:" + name + "end.");
        }
        @Override
        public String toString(){
            return "name = "+name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args){
        MyThreadPool myThreadPool = new MyThreadPool(3, 50);
        for (int i=0; i < TASK_NUM; i++){
            myThreadPool.execute(new MyTask("task" + i));
        }
    }


}
