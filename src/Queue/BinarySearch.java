package Queue;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int binarySearch(Integer[] array, int des) {
	    //定义初始最小、最大索引
	    int low = 0;
	    int high = array.length - 1;
	    //确保不会出现重复查找，越界
	    while (low <= high) {
	        //计算出中间索引值
	        int middle = (high + low)>>>1 ;//防止溢出
	        if (des == array[middle]) {
	            return middle;
	        //判断下限
	        } else if (des < array[middle]) {
	            high = middle - 1;
	        //判断上限
	        } else {
	            low = middle + 1;
	        }
	    }
	    //若没有，则返回-1
	    return -1;
	}
}
