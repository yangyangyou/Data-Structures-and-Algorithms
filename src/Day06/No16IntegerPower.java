package Day06;

import java.util.Scanner;

public class No16IntegerPower {
	/*
	 * 面试题16：数值的整数次方
	 * 题目：实现函数double Power（double base,int exponent），求base的exponent次方。
	 * 		不得使用库函数，同时不需要考虑大数问题。
	 * 
	 * 思路：因该多考虑输入的情况，避免遗漏
	 * 		先判断基数base的取值：
	 * 			base == 0   等于0时，无意义，错误处理方法使用返回值方法，直接返回0
	 * 			base ！= 0 不等于0时，考虑指数exponent的取值情况即可
	 * 		再判断指数exponent的取值：
	 * 			exponent == 0 等于0时，任何输的0次方都为1 ，返回1.0即可
	 * 			exponent > 0  大于0时，直接做power运算--次方运算即可
	 * 			exponent < 0 小于0时，先将base取倒，再将exponent取负，在进行power运算--次方运算即可
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		No16IntegerPower result=new No16IntegerPower();
		Scanner s= new Scanner(System.in);
		System.out.println("请输入base值:");
		double base=s.nextDouble();
		
		Scanner s1= new Scanner(System.in);
		System.out.println("请输入exponent值:");
		int exponet =s1.nextInt();
		
		System.out.println("结果是"+result.power(base, exponet));
	}
	
	//计算base的exponent次方的值

	private static double power(double base,int exponet){
		double result =0;
		if(equal(base,0)){
			return 0;
			
		}
		if(exponet==0){
			return 1.0;
		}
		if(exponet>0){
			result=multiply(base,exponet);
		}
		else{
			//只剩下 指数小于0，也就是负数的情况，则求1/base的-exponent次方
			//因为exponent为负值-3， base为2 
				//例如也就是2的-3次方，应该将2（base）取倒，也就是将-3次方的负值抹去变为3了，
				//接下来就将-3变为-（-3）=3，取负
				//在进行power（）运算即可

			result=multiply(1/base, -exponet);//这里要改为-exponet
		}
		return result;
		
		
		
	}
	private static double multiply(double base,int exponent){
		double sum=1;
		for (int i = 0; i < exponent; i++) {
			sum*=base;
		}
		return sum;
	}
	
//	equal方法判断double类型的值是否相等。
	private static boolean equal(double a,double b){
		if(a-b<0.000001&&a-b>-0.000001){
			return true;
			
		}
		return false;
	}
	
}
