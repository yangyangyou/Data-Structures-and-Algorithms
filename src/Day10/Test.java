package Day10;

import java.util.Scanner;

public class Test {

	public static void main(String[] args){
//		int a=(int)(Math.random()*(2));//0~1随机值改成0，1分布的值
//		System.out.println(a);
		
		
		Scanner s=new Scanner(System.in);
		String a=s.nextLine();//next接收到空格就结束，nextLine不会
	    String []array =a.split(" ");
	    
	    int a1= Integer.parseInt(array[0]);
	    int a2= Integer.parseInt(array[1]);//parseInt是Integer的方法
		System.out.println(a1);
	    System.out.println(a2);
	}
	
	
	
}
