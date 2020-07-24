package Sort;

public class XiEr {
/*
 * 优化插入算法：
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 
 * 最佳情况：T(n) = O(nlog2 n)
最坏情况：T(n) = O(nlog2 n)
平均情况：T(n) =O(nlog2n)
 */
	
	
	public static void main(String[] args) {
		int array[]={1,5,3,6,7};
		array=XiErSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		

	}
	
	public static int[] XiErSort(int array[]){
		if (array.length==0) {
			return array;
		}
		int len=array.length;
		int gap=len/2;
		while (gap>0) {
			
			for (int i = gap; i < len; i++) {
			int temp=array[i];
			int preIndex=i-gap;
			while (preIndex>=0&&array[preIndex]>temp) {
				array[preIndex+gap]=array[preIndex];
				preIndex-=gap;
			}
			array[preIndex+gap]=temp;
		}
			gap/=2;
		}
		
		
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
}
