package Day06;

import java.util.Scanner;

public class No14CutThread {
	/*
	 * 面试题14：剪绳子
	 * 题目：给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1且n>1）
	 * 		每根绳子的长度记为k[0]，k[1],...,k[m].
	 * 		请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
	 * 		例如，当绳子的长度为8时，我们把它分别剪成2、3、3的三段，此时得到的最乘积是18.
	 * 		
	 * 
	 * 
	 * 
	 * 思路：因此，此问题求解的是长度为n的绳子，被分为m段时得到最大乘积，不考虑m值，只求乘积为多少。
	 * 
	 * 思路：第一种方法（动态规划）
	 * 		进行循环，f(i)=max{f(j)*f(i-j)}  j=1,...,i/2,一般即可，另一半是对称的，不必计算
	 * 		取最大值，从i=1，2，3，。。。逐个增加进行计算将最大值存入一个数组中，方便计算
	 * 	       
	 *  第二种方法（贪心算法）
	 * 		尽可能多的剪出长度为3的绳子，剩下的绳子为4时，则将其分为2+2形式
	 * 		先求出有多少个长度为3的，再看剩下的，剩下为1，则和前一个3，变为4，分解为2+2
	 * 								    剩下为0，则直接求多少个3相乘
	 * 								    剩下为2，则3乘完之后再*2
	 * 
	 * ）
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		No14CutThread mmc = new No14CutThread();
		Scanner in = new Scanner(System.in);
		
		System.out.println("输入绳子的长度(n):");
		int n = in.nextInt();
		System.out.println("输入将绳子剪成多少段（m值）：");
		
		//动态规划 dynamic programming
		System.out.println("输出通过动态规划方法算出的最大乘积："+mmc.dynamic(n));
		//贪心算法 greedy Algorithm
		System.out.println("输出通过贪心算法算出的最大乘积："+mmc.greedy(n));
		
		
	}


	
//	动态规划  时间复杂度O(n2) 空间复杂度O(n)
	
	private int dynamic(int n){
		if (n<2)return 0;
		if(n==2)return 1;
		if(n==3)return 2;
		//将绳子分为i段乘积最大值放入数组中
		int []result=new int[n+1];
		
		result[0]=0;
		result[1]=1;
		result[2]=2;	
		result[3]=3;
		//循环  f(n) = max{f(i),f(n-i)}
		for (int i = 4; i < n; i++) {
			int max=0;
			
			//先循环求出当为i长度时，最大乘积，
			//f(i)=f(j)*f(i-j)，其中i表示长度 ，j表示第一部分被分了多长 ,i-j表示剩余部分长度
			//j取值1,2,...,i/2（j的取值）另一部分对称 不必计算 
			//由小到大进行计算，计算出大的值赋给result[i]
			//再将i++
			//不断计算，知道计算完所有的i值
			for (int j = 1; j < i/2; j++) {
				int temp=result[j]*result[i-j];
				if (temp>max) {
					max=temp;
					
				}
			}
			result[i]=max;
			
		}
		return result[n];
		
		
		
		
		
		
		
	}
	
	//贪心算法  时间复杂度O(1) 空间复杂度O(1)
		private int greedy(int n) {
			// TODO Auto-generated method stub
			//贪心算法  当n>=5时2(n-2)>n,3(n-2)>n,3(n-2)>=2(n-2)
			if(n<2) return 0;
			if(n==2) return 1;
			if(n==3) return 2;
			int timesOf3 = n/3;
			//尽可能多的剪去长度为3的绳子
			n -= timesOf3 *3;
			
			//如果绳子最后剩下长度为4，应该剪成2+2，而不是3+1
			if(n == 1) {//加上前一段3，就是4，要被分割为2*2
				timesOf3 -= 3;
				return (int)Math.pow(3,timesOf3)*2*2;
			}
			else if(n == 0) {
				return (int)Math.pow(3, timesOf3);
				//Math.pow()表示  timesOf3个3相乘
			}
			//n == 2
			else {
				return (int)Math.pow(3, timesOf3)*2;
			}
					
			
	 
		}

	
	
	
}
