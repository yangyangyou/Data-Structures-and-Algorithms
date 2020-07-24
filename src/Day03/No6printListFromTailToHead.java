package Day03;

import java.util.ArrayList;
import java.util.Stack;

/*
 *  题目6：从尾到头打印链表:输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
         *           链表节点定义：
         *  struct ListNode{
         *      int m_nKey;
         *      ListNode * m_pNext;
         *  }
         *  思路：借助栈实现，或使用递归的方式
 */
public class No6printListFromTailToHead {
		
    public static void main(String[] args){
    	ListNode listNode =new ListNode(1);
    	listNode.next=new ListNode(3);
    	listNode.next.next=new ListNode(4);
    	listNode.next.next.next=new ListNode(0);
    	
//    	No6printListFromTailToHead plr=new No6printListFromTailToHead();
    	System.out.println("------方法一：借助栈实现的反向打印链表："+No6printListFromTailToHead_Iteratively(listNode));

		System.out.println("-----方法二 使用递归的方式反向打印链表：");	
		printListReversingly_Recursively(listNode);
    }
	
	//方法一：通过栈来实现，第一个遍历的节点最后一个输出，最后一个节点第一个输出。
	//      先把链表中的数据都放到栈中，然后按顺序将栈中的数据pop出就好了
	//      典型的栈的结构   后进先出
	
	public static ArrayList<Integer> No6printListFromTailToHead_Iteratively(ListNode listNode){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if (listNode==null) {
			return list;
		}
		//定义栈   数据为整型
		Stack<Integer> stack=new Stack<Integer>();		
		while (listNode!=null) {
			stack.push(listNode.val);
			listNode=listNode.next;
		}
		while (!stack.isEmpty()){
			list.add(stack.pop());
		}		
		return list;
	}
	//方法二：使用递归的方式来实现，每访问一个节点的时候，
	//      先递归输出它后面的节点，再输出该节点自身，这样就会反向输出了
		private static void printListReversingly_Recursively(ListNode listNode) {
			// TODO Auto-generated method stub
			if(listNode == null) System.out.println("");
			if(listNode!=null) {
				if(listNode.next!=null) {
					printListReversingly_Recursively(listNode.next);
				}
			} 
			System.out.print(listNode.val+" ");			
		}
	}
class ListNode{
	int val;
	ListNode next=null;
	ListNode(int val){
		this.val=val;
	}
}
