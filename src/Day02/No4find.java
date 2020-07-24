package Day02;

import java.util.Scanner;

public class No4find {
/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 */
	public static void main(String[] args) {
		No4find f= new No4find();
		
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.print("请输入数组的行和列");
		int n=in.nextInt();
		int m=in.nextInt();
		int [][]arr=new int[n][m];
		
		System.out.println("请输入数组各个元素");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				arr[i][j]=in.nextInt();
			}
		}
		
		System.out.println("输出数组各个元素");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	
		System.out.println("请输入你要查询的数字：");
		int target=in.nextInt();
		
		boolean b=f.find(arr, target);
		if (b==true) {
			System.out.println("这个数组有"+target+"这个整数");
			
			
		}else {
			System.out.println("这个数组没有"+target+"这个整数");

		}
         
	}
	
	public Boolean find(int arr[][],int target){
		if (arr==null) {
			return false;
			
		}
		int row=0;
		int column= arr[0].length-1;  //定位第一行最后一列；也就是右上角。其实左下角也可以
		while (row<arr.length&&column>=0) {
			if (arr[row][column]==target) {
				return true;
				
			}
			if (arr[row][column]>target) {
				column--;
			
			}else {
				row++;
			}
			
		}
		return false;
	}

}
