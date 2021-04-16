package others.concurrent.ch3.s1;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LockSupportDemo
 * @Description Todo
 * @Date 15/04/2021 16:45
 * @Author voyager2511
 * @Email zhoujianfeng@codemao.cn
 */
public class LockSupportDemo {
    //重入锁
    /**
     根据系统调度，一个线程会倾向于再次获取已经持有的锁，这种分配方式高效，但无公平性可言。


     */

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        //阻塞原语
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }


}
