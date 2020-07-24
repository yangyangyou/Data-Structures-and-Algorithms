package Day09;

import javax.xml.soap.Node;

public class No18First_deleteNode {
	/*
	 * 面试题18：删除链表的节点
	 * 题目一：在O(1)时间内删除链表节点
	 *给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。链表节点与函数的定义如下：
	 *struct ListNode{
	 *	int m_nValue;
	 *	ListNode* m_pNext;
	 *};
	 *
	 *void DeleteNode(ListNode** pListHead,ListNode* pToBeDeleted); 
	 *
	 *思路:删除链表节点有三种情况：
	 *1、只有一个节点，删除头节点即是尾节点，直接head.next = null即可
	 *2、删除的节点不是尾节点，找到要删除的下一个节点将其数据赋值给要删除的节点，并且将下一个节点的next赋值给要删除的节点的next即可
	 *3、删除的节点是尾节点，但是前面有很多个节点，则需要从头节点遍历到要删除的前一个节点，然后将这个节点的next置空null即可。
*/

	//定义listNode节点 静态的
	static class ListNode{
		int value;
		ListNode next;
		ListNode(int value){
			this.value=value;
		}
	}
	public static void main(String []args){
		No18First_deleteNode list=new No18First_deleteNode();
//		ListNode one=new ListNode(2);错了  别忘了head****
		ListNode head=new ListNode(2);

		ListNode two=new ListNode(3);

		ListNode three=new ListNode(4);
		ListNode four=new ListNode(5);
		ListNode five=new ListNode(6);
		ListNode six=new ListNode(7);
		ListNode seven=new ListNode(9);

		head.next=two;
		two.next=three;
		three.next=four;
		four.next=five;
		five.next=six;
		six.next=seven;
		
		seven.next=null;//******
		
		
		System.out.println("输出链表：");
		ListNode node=head;
		for (int i = 0; i < 7; i++) {
			System.out.println(node.value);
			node=node.next;
		}
		
//		list.DeleteNode(head, deleteNode);//这里deletenode要明确要删除的目标节点
		list.DeleteNode(head,seven);
	}
	private void DeleteNode(ListNode head,ListNode deleteNode ){
		
		if(head==null||deleteNode==null){
			return;
		}
		//删除的不是尾结点
		if(deleteNode.next!=null){
			ListNode temp=deleteNode.next;
			deleteNode.value=temp.value;
			deleteNode.next=temp.next;
			
		}
//		删除的是尾结点，1 如果只有一个节点，头结点那即是尾结点也是	
		else if(head==deleteNode){
			
			deleteNode.next=null;
		}
//		删除的是尾结点，2 多个节点有
		else{
			ListNode temp=head;
			while(temp.next!=deleteNode){
				temp=temp.next;
			}
			temp.next=null;
		}
		System.out.println("删除后的节点数据：");
		ListNode node=head;
		for (int i = 0; i < 6; i++) {
			
			System.out.println(node.value);
			node=node.next;
		}
	}
	
}
