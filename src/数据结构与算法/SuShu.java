package 数据结构与算法;

public class SuShu {
/*
 * 一百以内的素数
 */
	public static void main(String[] args) {
		int i,j,k;
		int count=0;
		for (i = 2; i <100; i++) {
			//*************************************思路很好*************************
			//如果它不是质数，那么它一定可以表示成两个数（除了1和它本身）相乘，
			//这两个数必然有一个小于等于它的平方根。只要找到小于或等于的那个就行了
			k=(int)Math.sqrt(i);
			for (j = 2; j <= k; j++) {
				if (i%j==0) {
					break;
				}
			}
			
			if (j>k) {
				System.out.print(i+" ");
				count++;
				if (count%8==0) {
					System.out.println();
				}
			}
			
		}

	}

}
