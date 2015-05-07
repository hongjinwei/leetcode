/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
@
*/
import java.io.*;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {

    	ListNode p = head;
    	ListNode pre = head;
    	ListNode l = head;
    	while(p != null && n > 1){
    		p = p.next;
    		n--;
    	}    
    	
    	if(p == null || n <= 0){
    		return head;
    	}else if(p.next == null){
    		return head.next;
    	}

    	l = l.next;
    	p = p.next;
    	
    	while(p.next != null){
    		pre = pre.next;
    		l = l.next;
    		p = p.next;
    	}

    	pre.next = l.next;
    	return head;
    }

	public static void println(ListNode head)
	{
		while(head != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("null\n");
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	ListNode head = new ListNode(1);
    	ListNode l = head;
    	for(int i=2;i<6;i++){
    		l.next = new ListNode(i);
    		l = l.next;
    	}
		println(head); 
    	println(s.removeNthFromEnd(head, 6));
    	   
    }
}