package Day05;

import java.util.Scanner;

public class No10First_Fibonacci {
	/*     题目1：求斐波那契数列的第n项。

	     *                   写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
	     *          斐波那契数列的定义：
	     *                 f(n) = 0              n=0
	     *                        1              n=1
	     *                        f(n-1)+f(n-2)  n>1
	     * 
	     * 
	     *             使用迭代的方式计算会慢，是因为重复的计算太多了，所以这里应该使用循环的方式进行计算，
	                                                                才能避免重复的计算 提高时间复杂度
	     *     思路：递归的效率低，是用循环实现，时间复杂度O(n)
	     *     根据f(0)、f(1)计算出f(2),根据f(1)、f(2)计算出f(3),
	     *     ......
	     *     根据f(n-2)、f(n-1)计算出f(n)
	     *     因此，可以得出循环中的核心：
	     *             第一个值 + 第二个值 = 结果
	     *             第二个值 +  结果    = 结果1
	     *             ......
	     *         ==> 将第二个值赋给第一个值，并将结果赋给第二个值即可
*/

	public static void main(String[] args) {
		No10First_Fibonacci fbnc=new No10First_Fibonacci();
		Scanner n=new Scanner(System.in);
		System.out.println("请输入要查询的斐波那契数列中的项数");
		int i=n.nextInt();

		System.out.print(fbnc.fibonacci(i));;
		/*Scanner n=new Scanner(System.in);
		int s=n.nextInt();   输入必备*/
	}
	public long fibonacci(int n){
		long result =0;
		long preTwo=1;
		long preOne=0;
		if(n==0){
			return preOne;
		}
		if(n==1){
			return preTwo;
		
		}
		
		//其实就是f(n)=f(n-1)+f(n-2)前两个得和，想办法得到前两个的值
		for (int i = 2; i < n; i++) {
			result =preOne+preTwo;
			preOne=preTwo;
			preTwo=result;
			
		}
		return result;
			
		}
		
	}
	
	


