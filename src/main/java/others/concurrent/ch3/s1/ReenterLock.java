package others.concurrent.ch3.s1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable{

    //可重入锁ReentrantLock也是独占锁
    public static ReentrantLock lock = new ReentrantLock();
    public static int i=0;
    public static ReentrantLock innerlock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            lock.lock();
//            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
//                lock.unlock();
            }
        }
    }

    public static class ReenterLockCondition implements Runnable {

        @Override
        public void run() {
            try{
                innerlock.lock();
                condition.await();
                System.out.println("Thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                innerlock.unlock();
            }
        }

        public void testCondition() throws InterruptedException {
            //构造信号量准入，就是能同时申请多少个许可。每个线程每次只能申请一个许可时，就相当于指定了同时有多少个线程可以访问一个资源。
            ReenterLockCondition r1 = new ReenterLockCondition();
            Thread t1= new Thread(r1);
            t1.start();
            Thread.sleep(2000);
            lock.lock();
            condition.signal();
            lock.unlock();
        }


    }



    public static void main(String[] args) throws InterruptedException {
        ReenterLock r1 = new ReenterLock();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

        //测试重入锁，获得信号量
        ReenterLockCondition test = new ReenterLockCondition();
        test.testCondition();

    }




}
