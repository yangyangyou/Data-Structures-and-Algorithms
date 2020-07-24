package Day05;

import java.util.Scanner;

/*
 *  题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
     *         例如，把9表示成二进制是1001，右2位1.
     *             因此，若是输入9，则函数输出2

//面试官满意的解法
     * 思路：把一个整数减去1，在和原整数做与运算，会把该整数最右边的1变为0
     * 那么一个整数的二进制表示中有多少个1，就要进行多少次这种操作
     * 例如：原数为1100，减去1后变为1011，再与原数1100相与，得到1000，最后一位1变为0
     *         原数为1101，减去1后变为1100，再与原数1101相与，得到1100，最后一位1变为0
     * ...以此类推，每次都将最右边的1变为0，则要进行多少次转换就有多少个1
 */
public class No15number1ofbinary {
	public static void main(String[] args) {
		No15number1ofbinary n1=new No15number1ofbinary();
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个整数n：");
		int n=in.nextInt();
		System.out.println("输出整数"+n+"转换为二进制后所含的1的个数为："+n1.numberOf1(n));
		in.close();//流用过之后要关闭
	}
	private int numberOf1(int n){
		int count=0;
		while(n!=0){
			n=n&(n-1);
			count++;
		}
		return count;
	}
}
