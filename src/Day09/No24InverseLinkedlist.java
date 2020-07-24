package Day09;

import java.awt.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class No24InverseLinkedlist {

	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data=data;
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 面试题24：反转链表
		 * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
		 * 链表节点定义：
		 * struct ListNode{
		 * 	int m_nKey;
		 * 	ListNode* m_pNext;
		 * }
		 * 
		 * 思路：从原链表头部开始转换链表的指向，需要使用三个指针。
		 * 分别记录：第二个节点指向第一个节点，那么第二个在原链表时指向的那个将会丢失，所以用地三个指针记录此节点。
		 * 并且要保证鲁棒性，完整性  考虑输入数据可能对程序的影响，避免系统崩溃
		 * */
	No24InverseLinkedlist inverse=new No24InverseLinkedlist();
	ListNode  pHead =new ListNode(2);
	ListNode  second =new ListNode(3);
	ListNode  three =new ListNode(4);
	ListNode  four =new ListNode(5);
	//************千万不能写反，空指针异常second=pHead.next;
	pHead.next=second;
	second.next=three;
	three.next=four;
	four.next=null;
	
//	System.out.println(inverse.reverseList1(pHead).data);
	System.out.println(inverse.reverseList2(pHead).data);
	}
		 //方法 1：三个指针实现单链表的反转
	public ListNode reverseList1(ListNode pHead){
	        if (pHead==null || pHead.next==null){
	            return pHead;
	        }
	        //之前 pPrev->pNode->pNext
	        //之后 pNext->pNode->pPrev
	        //之后 pPrev<-pNode<-pNext
	        ListNode pReverseHead=null;//反转之后的头节点，也就是返回节点
	        ListNode pNode=pHead;//当前节点
	        ListNode pPrev=null;//定义存储的前一个节点
	        while(pNode!=null){
	            ListNode pNext=pNode.next;
	            if (pNext!=null){
	                pReverseHead=pNode;
	            }
	            pNode.next=pPrev;
	            pPrev=pNode;
	            pNode=pNext;
	        }
	        return pReverseHead;
	    }
	
	
	
	/*public ListNode reverseList1(ListNode head) {
		// TODO Auto-generated method stub
		ListNode second = null;
		if(head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		second = head.next;
		ListNode third = null;
		
		
		
		
		if(head.next.next != null) {
			third = head.next.next;
		}
		
		while(second != first) {
			
			second.next = first;
			//若为原链表的表头  则将其next设置为null
			if(first == head)
				first.next = null; 
			first = second;
			//若第三个部位空，则将其赋值给second
			if(third != null) {
				second = third;
			}
			else 
				continue;
			
			
			if(third.next != null) {
				third = third.next;
			}
			else 
				continue;
			
		}
		
		
//		System.out.println("输出反转后的链表数据");
//		for(int i=0;i<5;i++) {
//			System.out.println(second.data);
//			second = second.next;
//		}
		return second;
		
		
		
	}*/


	//*********第二种方法：递归翻转，利用递归特性，后进先出的原则进行
	public ListNode reverseList2(ListNode pHead){
		if (pHead==null||pHead.next==null) {
			return pHead;
		}
		ListNode pNext=pHead.next;
		ListNode reverseHead=reverseList2(pNext);
		/*pHead.next=null;
		pNext.next=pHead;*/
		System.out.println(pNext.data);
		return reverseHead;
		
		
	}

}
