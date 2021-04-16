package others.concurrent.ch3.s1;


import java.util.concurrent.locks.ReentrantLock;



public class IntLock implements Runnable{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        /**
         死锁情况，锁中断解决问题
         线程t1和t2启动后，t1先占用lock1，再占用lock2；t2先占用lock2，再请求lock1
         这里很容易形成t1与t2之间的互相等待。在这里，对锁的请求，统一用lockInterruptibly()
         这个方法可以对中断进行相应的锁申请动作。在等待锁的过程中，可以相应中断。
         */
        /**
         * 代码47行Thread.sleep(1000);， 主线程处于休眠状态，此时，两个线程处于死锁状态，
         * 代码t2.interrupt();，由于t2线程被中断，所以t2线程会放弃对lock1的申请，同时释放已经获得的lock2.
         * 这个操作就是的t1线程可以顺利得到lock2并且继续执行下去。中断后，两个线程就都可以退出了.
         * 但是，真正完成工作的只有t1，t2是放弃锁申请的
         */

        /**
         * 还有一个timeLock，表示线程在这个锁请求中最多只等待若干秒，超过时间就没得到锁，就会返回false
         * 还有tryLock，这种情况下，当前线程会尝试获得锁，如果锁没有被其他线程占用，就会申请锁成功，成功就返回true
         * tryLock使得线程不会傻傻等待，
         */

        /**
         * 公平锁
         */


        try {
            if (this.lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(this.lock + "线程退出");
        }


    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }



}
