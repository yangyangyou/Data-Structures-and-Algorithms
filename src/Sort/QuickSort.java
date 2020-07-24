package Sort;

public class QuickSort {
/*
 * 快速排序（冒泡排序升级版）：通过1趟排序将待排记录分割成独立的两部分，
 * 其中一部分记录的关键字均比另 部分记录的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序的目的
 * 
 *最差的情况就是每一次取到的元素就是数组中最小/最大的
 最优的情况下空间复杂度为：O(nlogn);每一次都平分数组的情况
 最差的情况下空间复杂度为：O( n2 )；退化为冒泡排序的情况

 1、先从数列中取出一个数作为基准数 
2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
3、再对左右区间重复第二步，直到各区间只有一个数

*/



 
	public static void main(String[] args) {
		int[] array={6,4,3,2,7,9,1,8,5};
		quickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	private static void quickSort(int[] array,int start,int end){
		if (array==null ||start>=end||array.length<=1)
			return;
		int mid =getMiddle(array,start,end);//得到中轴位置5
		quickSort(array, start, mid);
		quickSort(array, mid+1, end);
	}
	public static int getMiddle(int[] array,int start,int end){
		int temp=array[start];//数组的第一个作为中轴
		while(start<end){
			while(start<end&&array[end]>temp){
				end--;
			}
			array[start]=array[end];//比中轴小的记录移到低端
			
			while (start<end&&array[start]<temp) {
				start++;
			}
			array[end]=array[start];//比中轴大的记录移到高端
		}
		array[start]=temp;//中轴记录到尾 
		return start; // 返回中轴的位置
		
	}

}
