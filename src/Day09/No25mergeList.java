package Day09;

import Day09.No24InverseLinkedlist.ListNode;

public class No25mergeList {
/*
		 * 面试题25：合并两个排序的链表
		 * 题目：输入两个递增序列的链表，合并这两个链表并是新链表中的节点仍然是递增排序的。
		 * 例如： 输入链表1:1->3->5->7和链表2:2->4->6->8,
		 * 将二者合并之后的升序链表为：1->2->3->4->5->6->7->8
		 * 
		 * 
		 * 思路：取两个链表的头节点，比较大小，小的作为新的合并的链表的头节点；
		 *            然后将剩余的两个链表的头节点在进行比较，小的再作为新的合并的链表的下一个节点，
		 *            。。。。。。直到两个链表都到末尾为止。若是一个先到达末尾，则另一个直接将剩余数据连接到新的链表之后即可。
		 *           还要注意空指针问题：若是开始一个链表为空，则合并的新链表就是另一个有数据的链表。
		 *           	       若是两个都为空链表，则新链表为空链表。 
		 *           
		 *   这是一个递归的过程
		 *   递归就是不断直接或间接调用自己的函数；
		 *   迭代是不断执行函数中一部分代码的过程。
		 * */
	
	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data=data;
		}
	}
	public static void main(String[] args) {
		No25mergeList mList= new No25mergeList();
		ListNode  head1 =new ListNode(2);
		ListNode  second1 =new ListNode(3);
		ListNode  three1 =new ListNode(4);
		ListNode  four1 =new ListNode(5);
		//************千万不能写反，空指针异常second=pHead.next;
		head1.next=second1;
		second1.next=three1;
		three1.next=four1;
		four1.next=null;
	
		ListNode  head2 =new ListNode(1);
		ListNode  second2 =new ListNode(5);
		ListNode  three2 =new ListNode(6);
		ListNode  four2 =new ListNode(7);
		//************千万不能写反，空指针异常second=pHead.next;
		head2.next=second2;
		second2.next=three2;
		three2.next=four2;
		four2.next=null;
		
		ListNode node1=head1;
	    System.out.println("输出链表1的数据：");
		for (int i = 0; i < 4; i++) {
			System.out.println(node1.data );
			node1=node1.next;
		}
		
		ListNode node2=head2;
	    System.out.println("输出链表2的数据：");
		for (int i = 0; i < 4; i++) {
			System.out.println(node2.data );
			node2=node2.next;
		}
		
		
		System.out.println("输出合并后的链表：");
		ListNode newList=mList.mergeList(head1, head2);
		
		for (int i = 0; i < 8; i++) {
			System.out.println(newList.data+"	");
			newList=newList.next;
		}
		System.out.println();
		System.out.println("****************************"+"完成合并"+"****************************");
		
		
	}
	
	
	
	
	
	
	public ListNode mergeList(ListNode head1,ListNode head2){
		ListNode newList=null;
//		这样会出现空指针，因为当head1和head2并不一定同时结束
		/*if (head1==null) {
			return head1;
		}*/
		if (head1==null) {
			return head2;
		}
		if (head2==null) {
			return head1;
		}
		
		
		if (head1.data<head2.data ) {
			newList=head1;
			newList.next=mergeList(head1.next, head2);
		}
		else {
			newList=head2;
			newList.next=mergeList(head1, head2.next);
		}
		return newList;
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
