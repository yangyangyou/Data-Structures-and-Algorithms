package Day07;

import java.util.Scanner;
 
public class No11_quickSort {
 
	/*
	 * 快速排序：
	 * 算法思想：基于分治的思想，是冒泡排序的改进型。
	 * 首先在数组中找到一个基准点（基准点的选择可能会影响快速排序的效率，在补充处）
	 * 然后分别从数组的两端扫描数组，设两个指标（lo指向起始位置，hi指向末尾），
	 * 首先从后半部分开始，若果发现有比基准点小的，就交换lo和hi的值，
	 * 然后再从前半段开始扫描，发现有比基准点大的，就交换lo和hi的值，
	 * 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置
	 * 一次排序就完成了
	 * 接下来采用递归的方式分别对前半部分和后半部分排序，当前半部分有序、后半段有序，整个数组就自然有序列
	 * 快速排序的时间复杂度是O(NlogN)
	 * 
	 * 【补充】：基准点的选取
	 * https://www.cnblogs.com/y3w3l/p/6444837.html
	 * https://blog.csdn.net/liuyi1207164339/article/details/50827608
	 * 
	 * 
	 * */
	static int[] array = new int[8];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		Scanner in = new Scanner(System.in);
		System.out.println("请向数组输入8个整数：");
		for(int i=0;i<8;i++) {
			array[i] = in.nextInt();
		}
		
		System.out.println("输出快速排序的结果：");
		sort(array,0,7);
		for(int i=0;i<8;i++) {
			System.out.println(array[i]+" ");
			
			
		}
		
		
	}
	
	public static int partition(int[] array,int lo,int hi) {
		
		if(lo>=hi) {
			return -1;
		}
		//基准数选取为lo位置，固定的切分方式
		int key = array[lo];
		
		while(lo<hi) {
			while(array[hi]>=key&&lo<hi) {
				hi--;
			}
			//将hi的值付给了lo  造成了hi为空（并非真的没有值，而是没有再进行赋值的意思）
			array[lo]=array[hi];  
			while(array[lo]<=key&&lo<hi) {
				lo++;
			}
			//将lo的值赋给hi  造成了lo为空
			array[hi]=array[lo];
			
		}
		array[hi] = key;  //此时hi = lo，所以赋给hi或者lo都可以
		return hi;        
		
		
	}
	
	public static void sort(int[] array,int lo,int hi) {
		if(lo>=hi) {
			return;
		}
		int index = partition(array,lo,hi);
		sort(array,lo,index-1);
		sort(array,index+1,hi);
		
	}
	
	
	
 
}
