package others.concurrent.ch2;


public class BadSuspend {
    public static Object user = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("T1");
    static ChangeObjectThread t2 = new ChangeObjectThread("T2");


    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (user) {
                System.out.println("in:" + getName());
                Thread.currentThread().suspend();//挂起
            }
        }

    }


    // 导致resume不生效的执行顺序可能是这样的：
    // 打印t1 => t1在suspend => t2等待u释放 => t1被resume => t2被resume => u释放打印t2 => t2被suspend => 永远无法结束
    public static void main(String []args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }


}
