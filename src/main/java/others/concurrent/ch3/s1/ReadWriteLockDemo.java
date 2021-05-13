package others.concurrent.ch3.s1;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockDemo {


    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;


    //读写加锁的方式
    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read success");
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
            System.out.println("write success");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable read = new Runnable() {
            @Override
            public void run() {
                try{
                    demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable write = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(lock, new Random().nextInt());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(write).start();
        }


    }



}
