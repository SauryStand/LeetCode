package com.shiyanlou.course;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile{
	
	public static void main(String[] args){
		try{
			String path = "/home/shiyanlou/Desktop/newfile.txt";
			String content = "testing string";
			//声明文件输出流
			FileOutputStream file = new FileOutputStream(path);
			file.write(content.getBytes());
			file.close();
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	
}