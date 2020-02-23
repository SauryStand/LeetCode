package algorithm.jianzhioffer;

/**
 * @program: leetcode
 * @description: add lock singleton
 * @author: voyager2511
 * @create: 2020-02-23 00:16
 **/
public class Singleton {

    private Singleton(){}
    //首先，我们需要知道Volatile可以保证可见性和原子性，同时保证JVM对指令不会进行重排序。
    /**
     *   指令1：获取singleton对象的内存地址
     *   指令2：初始化singleton对象
     *   指令3：将这块内存地址，指向引用变量singleton。
     */
    private volatile static Singleton singleton;

    public static Singleton getSingleton(){
        /**
        第一次判断是在Synchronized同步代码块外进行判断，由于单例模式只会创建一个实例，
        并通过getInstance方法返回singleton对象，
        所以，第一次判断，是为了在singleton对象已经创建的情况下，避免进入同步代码块，提升效率
         */
        if (singleton == null){
            synchronized (Singleton.class){
                /**
                    第二次判断是为了避免以下情况的发生。
                  (1)假设：线程A已经经过第一次判断，判断singleton=null，准备进入同步代码块.
                  (2)此时线程B获得时间片，犹豫线程A并没有创建实例，所以，判断singleton仍然=null，所以线程B创建了实例singleton。
                  (3)此时，线程A再次获得时间片，犹豫刚刚经过第一次判断singleton=null(不会重复判断)，进入同步代码块，这个时候，我们如果不加入第二次判断的话，那么线程A又会创造一个实例singleton，就不满足我们的单例模式的要求，所以第二次判断是很有必要的
                ————————————————
                版权声明：本文为CSDN博主「从_你的全世界路过」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
                原文链接：https://blog.csdn.net/May_3/article/details/82180961
                 */
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
