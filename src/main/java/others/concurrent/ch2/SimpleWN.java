package others.concurrent.ch2;

import java.util.Objects;

public class SimpleWN {

    final static Object obj = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "T1");
            try {
                System.out.println(System.currentTimeMillis() + "T1 waits for obj");
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "T1 end");

        }
    }

    public static class T2 extends Thread {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + "T2");
                obj.notify();
                System.out.println(System.currentTimeMillis() + "T2 end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 错误代码示例，t1会无法结束？
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }



}
