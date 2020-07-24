package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GuiBing {
/*
 *   和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
 *   
 *   先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *  最佳情况：T(n) = O(n)
最差情况：T(n) = O(nlogn)
平均情况：T(n) = O(nlogn) 
 *   
 */
	public static void main(String[] args) {
		int array[]={1,5,3,7,6};
		array=mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		

	}
	
	
	public static int[] mergeSort(int array[]){
		if (array.length<2) {
			return array;
			
		}
		int mid=array.length/2;
		int []left=Arrays.copyOfRange(array, 0, mid);
		int []right=Arrays.copyOfRange(array, mid,array.length );
		//**********递归使用。先把左右分开，再分成两两排序，再四个一起排序，再八个一起排。直至两边所有的都排好了。再把左右两部分合并排序*********
		return merge(mergeSort(left),mergeSort(right));
				
		
	}
	 /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
	public static int[] merge(int[] left,int[] right){
		int [] result=new int[left.length+right.length] ;
	    for (int i = 0,j=0,index=0; index < result.length; index++) {
	    	
	    	
	    	//两两排序之后，再四个一起。这是前提*****************
			if (i>=left.length) {
				result[index]=right[j++];
				
			}
			else if (j>=right.length) {
				result[index]=left[i++];
			}
			else if (left[i]>right[j]) {
				result[index]=right[j++];
			}
			else {
				result[index]=left[i++];
			}
		}
	    return result;
	
	}
	
	
	
}
