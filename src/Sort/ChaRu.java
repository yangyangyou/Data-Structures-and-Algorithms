package Sort;

public class ChaRu {
/*
 * 最佳情况：T(n) = O(n)
最坏情况：T(n) = O(n2)
平均情况：T(n) = O(n2)
思想：将数据在已排序的序列中从后往前扫描，找到相应位置就插入。从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
 */
	public static void main(String[] args) {
		ChaRu c=new ChaRu();
		int array[]={1,5,3,6,7};
		array=c.ChaRuSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		

	}

	public int[] ChaRuSort(int array[]){
		if (array.length==0) {
			return array;
		}
		for (int i = 0; i < array.length-1; i++) {//注意这里是i < array.length-1；因为array[i+1]
			int preIndex=i;
			int current=array[i+1];
			while (preIndex>=0&&current<array[preIndex]) {
				array[preIndex+1]=array[preIndex];
				preIndex--;
			}
			array[preIndex+1]=current;//这里preIndex+1，是因为上面preIndex--了
				
			}
		return array;
		}
	
	}

