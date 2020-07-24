package Day04;

import java.util.Stack;

/*
 * 面试题9：用两个栈实现队列
 *    题目：用两个栈实现一个队列。队列的声明如下，
 *    	  template <typename T> class CQueue{
 *    	  	  public :
 *    				CQueue(void);
 *    				~CQueue(void);
 *    		  
 *    			 	void append(const T& node);
 *    				T deleteHead();
 *    		  private:
 *    				stack<T> stack1;
 *   				stack<T> stack2;
 *    	  } 
 *    	      请实现它的两个函数appendTail和deleteHead，
 *    	      分别完成在队列尾部插入节点和在队列的首部删除节点的操作
 *    	
 *  	思路：一个栈压入元素，而另一个栈作为缓冲，将栈1的元素出栈后压入栈2中。
 *          也可以将栈1中的最后一个元素直接出栈，而不用压入栈2中再出栈。
 * */

public class No9twoStacksQueue {

	
	static Stack<Integer> stack1=new Stack<>();
	static Stack<Integer> stack2=new Stack<>();
	public static void main(String[] args){
		No9twoStacksQueue tsq=new No9twoStacksQueue();
		tsq.push(5);
		tsq.push(6);
		tsq.push(7);
		System.out.println("输出stack1的内容:"+stack1);
		System.out.println("输出stack2的内容:"+stack2);
	
	try {
		System.out.println(tsq.pop());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	tsq.push(10);
	System.out.println("输出stack1的内容："+stack1);
	System.out.println("输出stack2的内容："+stack2);


	try {
		System.out.println(tsq.pop());
		System.out.println(tsq.pop());
		System.out.println(tsq.pop());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	//进栈   完成队列尾部插入元素
	public void push(int i){
		stack1.push(i);
	}
	//出栈   完成队列首部删除元素  
	public int pop() throws Exception{
		if(stack1.isEmpty()&&stack2.isEmpty()){
			throw new Exception("栈为空！");
		}
		/*
		 * 若栈2为空，则将栈1的元素出栈并压进栈2中
		 * 弹出栈2的栈顶元素即可
		 * */
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			
		}
		return stack2.pop();
	}
	
	
	
}
