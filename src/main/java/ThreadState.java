
//最简单的线程示例

public class ThreadState implements Runnable{
	
	public synchronized void waitForMoment() throws InterruptedException{
		//使用wait方法使得当前线程等待500ms
		//或者使得其他线程调用notify（）或者notifyAll（）方法来唤醒
		wait(500);
		
	}
	
	public synchronized void waitFoever() throws InterruptedException{
		
		//不输入时间就默认当前线程处于永久等待
		//只会等待其他线程调用notify（）或者notifyAll（）方法才能唤醒
		wait();
		
	}
	public synchronized void notifyNow() throws InterruptedException{
		
		//使用notify（）方法来唤醒那些因为调用wait方法而进入等待状态的线程
		notify();
	}
	
	pbulic void run(){
		//这里使用异常处理是为了 防止可能出现的中断异常
		//如果任何线程中断了当前的线程，则会出现异常
		try{
			waitForMoment();
			waitFoever();//运行两个方法玩玩
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}