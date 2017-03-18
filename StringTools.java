package com.testing;
import java.util.Scanner;
/**
String 类中自带的方法去操作字符串
**/
public class StringTools{
	public static void main(String[] args){
		String a  = new String();
		String b  = new String();
		String c  = new String();
		Scanner scaner = new Scanner(System.in);
		a = caner.nextLine();//获取输入的字符串
		b = a.trim();//去除a中的空格，赋值到b中
		if(b.equals("hello")){
			c = b.substring(0,5);//分割出来
		}else{
			c = "";
		}
		
		
	}
}