package Sort;
/*
 * 冒泡排序算法的原理如下：
1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
2.对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
3.针对所有的元素重复以上的步骤，除了最后一个。
4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
最佳情况：T(n) = O(n)
最差情况：T(n) = O(n2)
平均情况：T(n) = O(n2)
 */
public class MaoPao {

	public static void main(String [] args){
		int array[]={1,2,2,3,6,5};
		array=maopaoSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public static int[] maopaoSort(int array[]){
		if (array.length==0) {
			return null;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-i-1; j++) {
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
				
			}
			
		}
		return array;
	}
}
