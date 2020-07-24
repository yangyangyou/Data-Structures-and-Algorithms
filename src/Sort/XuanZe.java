package Sort;

public class XuanZe {
/*
 * 最佳情况：T(n) = O(n2)
最差情况：T(n) = O(n2)
平均情况：T(n) = O(n2)
解决冒泡排序的频繁交换:思想就是选第一个数与后面所有的比较，最小的跟第一个数据交换
 */
	
	public static void main(String[] args) {
		int array[]={1,5,3,6,7};
		array=XuanZeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		

	}

	public static int[] XuanZeSort(int array[]){
		if (array.length==0) {
			return array;	
		}
		for (int i = 0; i < array.length; i++) {
			int minIndex=i;
			for (int j = i; j < array.length; j++) {
				if (array[j]<array[minIndex]) {
					minIndex=j;
					
				}
				
			}
			int temp=array[minIndex];
			array[minIndex]=array[i];
			array[i]=temp;
			
		}
		return array;
		
	}
}
