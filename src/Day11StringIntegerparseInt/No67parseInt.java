package Day11StringIntegerparseInt;

import java.util.Scanner;

public class No67parseInt {

	/*
	 * 面试题67：把数字字符串转换成整数
	 * 题目：将一个字符串转换成一个整数，要求不能使用字符串转换为整数的库函数
	 * 数字为0或者字符串不是一个合法的数值，则返回0
	 * 
	 * 思路：
	 * 需要考虑非法输入和边界值条件
	 * 合法输入：
	 * 1> 数字       
	 * 2>+/-数字
	 * 
	 * 非法输入：
	 * 1>null      
	 * 2>字符串为空
	 * 3>字符串只有一个符号+/-
	 * 4>字符串中有非数字字符
	 * 5>字符串超过int所能表示的范围  溢出
	 * 
	 * */
	

	public static void main(String[] args) {
		No67parseInt pInt=new No67parseInt();
		
		Scanner s=new Scanner(System.in);
		String a=s.nextLine();
		System.out.println(a);
		System.out.println("字符串转整数："+pInt.parseInt(a));

	}
	
	public int parseInt(String str){
		
		if (str==null||str.length()==0) {
			return 0;
		}
		int index=0;   //下标
		long  result=0;
		boolean isPositive=true;//记录正负号标志位
		
		//若有符号
		if (str.charAt(0)=='+'||str.charAt(0)=='-') {
			++index;

			//若只有正负号  则返回0
			if (index==str.length()) {
				return 0;
			}
			if(str.charAt(0) == '-'){
				
				
					isPositive = false;
			}
			
	
	
		  }
		
		for (int i = index; i < str.length(); i++) {
			if (str.charAt(i)<'0'||str.charAt(i)>'9') {
				return 0;
				
			}
			result *=10;
			result +=(str.charAt(i)-'0')*(isPositive?1:-1);
			if (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) {
				return 0;
			}
			
			
		}
		return (int)result;
		
	}

	}

