import java.util.Scanner;

public class shuixianhua{
    public static void main(String[] args){
	    int x=100,i,a,b,c;
	    for(;x<=999;x++){
	        a=x%10;
	        b=((x-a)%100)/10;
	        c=(x-b*10-a)/100;    
	        if(x==(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)))
	        	System.out.print(x+"\t");
	        }
	   
	    }
}