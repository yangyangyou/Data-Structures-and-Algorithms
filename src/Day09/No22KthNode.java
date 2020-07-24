package Day09;

import java.awt.List;
import java.util.Scanner;

import javax.xml.ws.handler.MessageContext.Scope;



public class No22KthNode {
	/*
	 * 面试题22：链表中倒数第k个节点
	 * 题目:输入一个单向链表，输出该链表中倒数第k个节点。
	 * 为了符合大多数人的习惯，本体从1开始计数，即链表的尾节点是倒数第一个节点
	 * 例如：一个链表有6个节点，从头节点开始，他们的值依次是1、2、3、4、5、6.
	 * 这个链表的倒数第3个节点是值为4的节点。
	 * 链表定义：
	 * struct ListNode{
	 * 	int m_nValue;
	 *  LinkNode m_pnext;
	 * }
	 * 
	 * 思路：
	 * 方法一：遍历两边链表  ：第一遍统计链表的个数n，第二遍根据n值和k值，得到要从头节点向后走到第n-k+1个节点。但是此方法要遍历两边链表。
	 * 方法二：遍历一遍链表：设置两个指针，都设置在头节点，第一个指针先走k-1步，第二个指针不动；
	 * 从第k步开始，第二个指针向后移动，第一个指针也向后移动，直到第一个指针走到链表的尾部。
	 * 因为 开始第一个指针走了k-1步 到达 第k个节点  然后还剩余n-k个节点，然后两个指针一起走，直到第一个指针到达尾部，那就走n-k+1步，
	 * 完成这长度为n【k-1步+n-k+1步 == n步】的链表的依次遍历
	 * 
	 * */

	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data=data;
		}
	}
	public static void  main(String []args) {
		No22KthNode kth=new No22KthNode();
		
		ListNode head=new ListNode(2);
		ListNode two =new ListNode(3);
		ListNode three=new ListNode(4);
		ListNode four=new ListNode(5);
		ListNode five=new ListNode(6);
		
		head.next=two;
		two.next=three;
		three.next=four;
		four.next=five;
		five.next=null;
		
		System.out.println("输出链表：");
		ListNode list=head;
		for (int i = 0; i < 5; i++) {
			System.out.println(list.data);
			list=list.next;
			
		}
		
		
		Scanner s=new Scanner(System.in);
		System.out.println("请输入k的值：");
		int k=s.nextInt();
		
		System.out.println("输出倒数第k个的值为：");
//		kth.kthNode(head, k);
		kth.kthNode2(head,k);
	}
//	方法一，复杂，遍历两遍
	public void kthNode(ListNode head,int k) {
		ListNode targetNode=head;
		if (head==null||k==0) {
			return;
		}
		int n=1;
		while (head.next!=null) {
			n++;
		}
		
		for (int i = 0; i < n-k+1; i++) {
			targetNode=targetNode.next;
		}
		System.out.println(targetNode.data);
		
	}
//	***方法二：两个指针，遍历一遍链表，查找倒数第k个节点的值
	
	public void kthNode2(ListNode head,int k){
		ListNode first=head;
		ListNode second=head;
		//增加鲁棒性   1>输入的head为空指针，k为0，都会导致程序崩溃，
				//所以要预防性编程，考虑输入是否符合规范，不符合的处理
		if (head==null||k==0) {
			return;
		}
		//**********************
		//增加鲁棒性  2>输入为head的头节点的连边界点总数少于k ，会导致空指针，造成程序崩溃...意思是k要保证小于n
		for (int i = 0; i < k-1; i++) {
			if (first.next!=null) {
				//*************************************
				//在这里已经便利了k-1个了
				first =first.next;
			}
			else {
				return;
			}
			
		}

		//刚好first走到了链表尾部 second走到了倒数第k个字符
		while (first.next!=null) {//还剩n-k+1次
			first=first.next;
			second=second.next;
		}
		System.out.println(second.data);
		
		
		
	}
	
	
	
	
	
	
}