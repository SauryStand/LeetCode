package others.concurrent.ch3.s1;


import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();


    public void run(){
        try {
            Thread.sleep(new Random().nextInt() * 1000);
            System.out.println("check complete!");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
