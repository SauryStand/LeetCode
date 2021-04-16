package others.concurrent.ch3.s1;


import java.util.concurrent.locks.ReentrantLock;

public class FairLock {

    public static ReentrantLock fairLock = new ReentrantLock(true);
//    public static ReentrantLock fairLock = new ReentrantLock();

    //公平锁，实现成本高，效率低下，没有特殊需求，一般不用公平锁
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName());
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String [] args){
        FairLock r1 = new FairLock();
        Thread t1 = new Thread((Runnable) r1,"Thread_t1");
        Thread t2 = new Thread((Runnable) r1,"Thread_t2");
        t1.start();
        t2.start();
    }


}
