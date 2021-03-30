package others.concurrent.ch2;

/**
 * @ClassName AccountingVol
 * @Description Todo
 * @Date 30/03/2021 15:47
 * @Author voyager2511
 * @Email zhoujianfeng@codemao.cn
 */
public class AccountingVol implements Runnable{

    static AccountingVol instance = new AccountingVol();
    static volatile int i = 0;

    public synchronized static void increase() {
        //not accurate if there is no synchronized
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            synchronized (instance){
                i++;
            }
        }
    }


//    public static void increase() {
//        i++;
//    }
//
//
//    public void run() {
//        for (int j = 0; j < 10000000; j++) {
//            increase();
//        }
//    }

//
//    public void run() {
//        for (int j = 0; j < 10000000; j++) {
//            synchronized (instance){
//                i++;
//            }
//        }
//    }

    // synchronized锁的是对象，不是函数
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }


}
