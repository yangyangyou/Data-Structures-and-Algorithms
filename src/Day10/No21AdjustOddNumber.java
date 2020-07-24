package Day10;


import java.util.LinkedList;
import java.util.Scanner;



public class No21AdjustOddNumber {

	/*
	 * 面试题21：调整数组顺序使奇数位于偶数前面
	 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
	 * 
	 * 思路：
	 * 方法一：设置两个指针  一个指向第一个元素，一饿指向最后一个元素
	 * 第一个元素找偶数，第二个元素找奇数，然后二者进行交换即可。不能保证奇数之间的相对位置+偶数之间的相对位置
	 * 
	 * 方法二：设置一个LinkedList集合，将偶数存入其中，遍历完整个数组之后再将集合中的数据存入数组即可。
	 * 
	 */


	public static void main(String[] args) {
		
//		这个过程很重要******
		No21AdjustOddNumber a=new No21AdjustOddNumber();
	
		Scanner s=new Scanner(System.in);
		//当输入的数组大小冬天变化时******
		System.out.println("输入要创建的数组的大小：");
		int n=s.nextInt();
		
		System.out.println("输入一个有"+n+"个数据的整数数组");
		int array[]=new int[n];
		for (int i = 0; i < n; i++) {
			array[i]=s.nextInt();
		}
		
		//方法一
		a.adjustOddNumber(array);
		//方法二****
		a.adjustOddNumber2(array);
	}


	//方法一：调整数组，使得奇数在前，偶数在后
		//运用两个指针进行头尾遍历，第一个指针指向头，第二个指针指向尾部
		//第一个指针向后寻找偶数，第二个指针向前寻找奇数，然后进行交换即可，但是相对位置没有保障。
	public void adjustOddNumber(int array[]){
		if (array==null||array.length==0) {//array.length==0放在后面判断为了防止空指针异常
			return;
		}
		int begin =0;
		int end= array.length-1;
		
		while (begin<end) {
			//从头开始找出第一个偶数
			while (begin<end&&array[begin]%2!=0) {
				begin++;
				}
//			从尾部找出第一个奇数
			while (begin<end&&array[end]%2==0) {
				end--;
			}	
//				交换奇数偶数的值
		
			if(begin<end) {
				int temp=array[begin];
				array[begin]=array[end];
				array[end]=temp;
			
			}
			begin++;
		}	
		//输出结果
		System.out.println("调整后的数组：");
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i]+"	");
	}
	}


	//方法二：空间复杂度O(n)  时间复杂度O(n)   
		//使用额外的空间将  偶数存入 ，并在遍历完数组后，将数据在存回数组即可
		//相对位置有保障****
	public void adjustOddNumber2(int array[]) {
		if (array==null||array.length==0) {
			return;
		}
		LinkedList<Integer> list=new LinkedList<>();
		int index=0;//**
		for (int i=0;i<array.length;i++) {
//			奇数存在array数组中
			if (array[i]%2==1) {
				array[index++]=array[i];
				
			}
			else {
				list.add(array[i]);
			}
		}
		
		//*****若index未达到数组尾部，则证明还有偶数没有存入，则将数据存入数组array即可
		while (index!=array.length) {
			array[index++]=list.removeFirst();
			
		}
		System.out.println("输出：");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]+"");
		}
	}

	
	
}
