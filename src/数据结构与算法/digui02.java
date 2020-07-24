package 数据结构与算法;
/*
 * 递归 连乘
 */

public class digui02 {
    public static void main(String []args){
    	int n=5;
    	int retValue= method(n);
    	System.out.println(retValue);
    }
    public static int  method(int n) {
		if(n==1){
			return 1;
			
		}
		return n*method(n-1);
	}

}

    