package leetcode.other;
import java.util.Scanner;
/**
String �����Դ��ķ���ȥ�����ַ���
**/
public class StringTools{
	public static void main(String[] args){
		String a  = new String();
		String b  = new String();
		String c  = new String();
		Scanner scaner = new Scanner(System.in);
		a = scaner.nextLine();//��ȡ������ַ���
		b = a.trim();//ȥ��a�еĿո񣬸�ֵ��b��
		if(b.equals("hello")){
			c = b.substring(0,5);//�ָ����
		}else{
			c = "";
		}
		
		
	}
}