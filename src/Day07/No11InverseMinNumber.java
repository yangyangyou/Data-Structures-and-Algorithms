package Day07;

import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 面试题11：旋转数组中的最小数字
 *  把一个数组最开始的若干个元素搬到数组的尾部，我们称之为一个数组的旋转。
 *  输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 *  例如数组{3, 4, 5, 1,2}为数组{1 ,2 ,3, 4, 5}的一个旋转，该数组的最小元素为 1
 */

public class No11InverseMinNumber {
/*
 * 思路：利用二分法，设置两个指针，第一个变量指向第一个元素，第二个变量指向最后一个元素
	 * 		找到中间的数，首先和第一个变量进行对比，若是比第一个变量大，则中间元素属于前半部分数组，将第一个元素的指向移到中间位置
	 * 				    然后和第二个变量进行对比，若是比第二个变量小，则中间元素属于后半部分数组，将第二个元素的指向移到中间位置
	 * 		查找范围缩小一半，再进行新一轮的查找。。。
	 * 		直到第一个指向前半部分数组的最后一个，第二个指向后半数组的第一个，也就是两者相邻
	 * 		第二个指向的就是最小的元素
	 * 
	 * 		其中根据旋转数组的定义还有一个特例，也就是将排序数组的前面0个元素搬到最后去，
	 * 		也就是排序数组本身，这仍然是数组的一个旋转，也就是第一个数字大于最后一个数字时，直接返回第一个数字就可
	 * 		若是左中右三值相等时，又该如何呢，前面的思路不能支持这种情况，
	 * 		所以原来的方法不可行，
	 * 		例如：1，0，1，1，1与1，1，1，0，1情况
	 * 		这里我们采用顺序查找的方式进行
 */
		
	public static void main(String[]args){
		//静态方法就不用新建对象了
		int [] array=new int[5];
		Scanner s=new Scanner(System.in);
		System.out.println("请输入长度为5的数组：");
		for (int i = 0; i < 5; i++) {
			array[i]=s.nextInt();
		}
		System.out.println("利用旋转数组的特性，输出数组中最小的元素："+No11InverseMinNumber.min(array));
	}
	
	private static int min(int[] array){
		if(array==null|array.length==0){
			return 0;
		}
		int left =0;
		int right=array.length-1;

		//若是旋转0位，则将array[0]的值返回即可
		int min =array[left];
		while (array[left]>=array[right]) {
			if(right-left<=1){
				min=array[right];
				break;
			}
			int mid=(left+right)/2;
			
			if(array[mid]==array[left]&&array[mid]==array[right]){
				min = minInOrder(array,left,right);
				break;
				
			}
			else if (array[mid]>=array[left]) {
				left=mid;
			}
			else if(array[mid]<=array[right]){
				right=mid;
				
			}
			
			
		}
		return min;
		
		
		
	}
	
	private static int minInOrder(int[] array,int left,int right){
		int result=array[left];
		for (int i = left+1; i < right; i++) {
			if (result>array[i]) {
				result=array[i];
			
			}
		}
		return result;
		
	}
	
	
	
	
	
	
	
}
