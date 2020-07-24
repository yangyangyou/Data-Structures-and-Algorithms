package 数据结构与算法;

import java.util.Stack;

public class ChuZhan {

	public static void main(String[] args) {
		int[] pushA={1,2,3,4,5,6};
	    int[] popA={6,5,4,3,2,1};//{1,4,3,2,6,5}
	    if(ChuZhan.IsPopOrder(pushA,popA)){
	        System.out.print("正确弹出");
	    }else{
	        System.out.print("错误弹出");
	    }

	}
//秒啊
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
	    int n=pushA.length;
	    Stack<Integer> stack=new Stack();
	    int j=0;
	    for(int i=0;i<n;i++){
	        stack.push(pushA[i]);
	        //peek和pop都取栈顶的值，但不清除它
	        while(!stack.empty()&&stack.peek()==popA[j]){
	            stack.pop();
	            j++;
	        }
	    }
	    if(stack.empty()){
	        return true;
	    }
	   return false;
	}
}