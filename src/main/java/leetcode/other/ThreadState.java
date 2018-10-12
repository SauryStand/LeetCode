package leetcode.other;
//��򵥵��߳�ʾ��

public class ThreadState implements Runnable{
	
	public synchronized void waitForMoment() throws InterruptedException{
		//ʹ��wait����ʹ�õ�ǰ�̵߳ȴ�500ms
		//����ʹ�������̵߳���notify��������notifyAll��������������
		wait(500);
		
	}
	
	public synchronized void waitFoever() throws InterruptedException{
		
		//������ʱ���Ĭ�ϵ�ǰ�̴߳������õȴ�
		//ֻ��ȴ������̵߳���notify��������notifyAll�����������ܻ���
		wait();
		
	}
	public synchronized void notifyNow() throws InterruptedException{
		
		//ʹ��notify����������������Щ��Ϊ����wait����������ȴ�״̬���߳�
		notify();
	}
	
	pbulic void run(){
		//����ʹ���쳣������Ϊ�� ��ֹ���ܳ��ֵ��ж��쳣
		//����κ��߳��ж��˵�ǰ���̣߳��������쳣
		try{
			waitForMoment();
			waitFoever();//����������������
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}