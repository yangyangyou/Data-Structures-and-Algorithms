package Day04;

import java.util.LinkedList;

public class No9ExtendsTwoStackQueue {
	/*
	 * 面试题9扩展（extend）：用两个队列实现栈
	 *    题目：用两个队列实现一个栈。
	 *    	      请实现它的两个函数push和pop，（都是对栈尾进行操作）
	 *    	      分别完成在栈尾部插入节点和删除节点的操作
	 *    
	 *  	思路：#所有元素{a,b,c}进入q1，
	 *           因为目的是实现栈，也就是最先进c，而队列是从对头开始出，
	 *          #所以先把ab出q1并进q2，此时目标c到了q1对头，
	 *          #出q1即可。
	 *           此时q1已经为空，下一个要出的是b，
	 *          #把a从q2出队并进q1，
	 *           此时目标b在q2队头
	 *          #出q2......
	 *         
	 *          也就是--->把非空队列中的n-1个元素压入空队列，剩下的第n个元素出队列，
	 *          这样保证了两个队列中总有一个是空队列
	 *          
	 *  	 * */

	static LinkedList<Integer> queue1=new LinkedList<>();
	static LinkedList<Integer> queue2=new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		No9ExtendsTwoStackQueue tqs=new No9ExtendsTwoStackQueue();
		tqs.push(1);
		tqs.push(2);
		tqs.push(3);
		System.out.println("queue1:"+queue1);
		System.out.println("queue2:"+queue2);
		
		
		System.out.println(tqs.pop());
		System.out.println(tqs.pop());
		System.out.println("queue1:"+queue1);
		System.out.println("queue1:"+queue2);
		
		tqs.push(4);
		tqs.push(5);
		System.out.println(tqs.pop());
		System.out.println(tqs.pop());
		
	}
	public void push(int i){
		queue1.addLast(i);
	}
	public int pop() throws Exception{
		if (queue1.isEmpty()&& queue2.isEmpty()){
			throw new Exception("队列为空！");
		}
		if(!queue1.isEmpty()){
			while(queue1.size()>1){
				queue2.addLast(queue1.removeFirst());
				//将队列中第一个删除  并压入队列2
			}
			return queue1.removeFirst();	//并将队列1中的唯一的元素弹出
		}
//		队列1为空了，队列2不为空
		else if(!queue2.isEmpty()) {
			while(queue2.size()>1){
				queue1.addLast(queue2.removeFirst());
				//将队列中第一个删除  并压入队列2
			}
			return queue2.removeFirst();//并将队列1中的唯一的元素弹出
		}
		return 0;		
	}
		

}
