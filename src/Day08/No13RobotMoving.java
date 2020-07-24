package Day08;

import java.util.Scanner;

import org.w3c.dom.css.Counter;

public class No13RobotMoving {

	/*
	 * 面试题13：机器人的运动范围
	 * 题目：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，
	 *     它每次可以向上、下、左、右移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子
	 *     例如：当k为18时，机器人能够进入方格为（35，37），因为3+5+3+7=18.
	 *         但它不能进（35，38），因为3+5+3+8=19.
	 *         请问该机器人能够到达多少个格子
	 *         
	 *思路：用一个flag标志位标记是否已经进入过该格子
	 *	 声明一个全局变量可以统计能进的坐标的数量
	 *	  然后从（0，0）开始计算，先标记这个格子，在进行查看周围的格子
	 *	 并计算是否位数和大于k，若大于则可能进入，否则可以进入 
	 *   对此位置的上下左右递归进行查询，直到所有的统计完
	 * */

	static int  counter =0;
	public static void main(String[] args) {
	No13RobotMoving robot=new No13RobotMoving();
	Scanner in =new Scanner(System.in);
	System.out.println("输入行坐标和列坐标的位数之和不能超过的k值大小：");

	int k=in.nextInt();
	System.out.println("依次输入行、列的大小：");
	int rows=in.nextInt();
	int cols=in.nextInt();
	robot.movingcount(rows, cols, k);
	System.out.println("机器人现在行数是："+rows+"列数是"+cols+"移动了"+counter+"个格子");
	}

	
	private void  movingcount(int rows,int cols,int k) {
		if(k<0){
			return;
			
		}
		int[] flag=new int [rows*cols];
		moving(rows, cols,0,0, k,flag);
	}
	private void moving(int rows,int cols,int i,int j,int k,int[] flag){
		//计算出该字符在一维数组中的位置index
		int index=i*cols+j;
		if(i<0||j<0||i>=rows||j>=cols||flag[index]==1){
			return;
		}

		//计算行坐标和列坐标的位数之和		
		int sumOfi=sumOfNumber(i);
		int sumOfj=sumOfNumber(j);
		//标记index位置的flag，表示进入过该位置了
		flag[index]=1;
		if (sumOfi+sumOfj<=k){
			counter++;
		}
		else {
			return;
		}

		//对该位置的上下左右进行判断
		moving(rows, cols, i-1, j, k, flag);
		moving(rows, cols, i, j-1, k, flag);
		moving(rows, cols, i+1, j, k, flag);
		moving(rows, cols, i, j+1, k, flag);

		
	}
	//计算位数之和
	
	private int sumOfNumber(int i){
		return (i%10)+(i/10);
	}
	
}
