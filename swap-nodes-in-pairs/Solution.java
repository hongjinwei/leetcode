/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

@https://leetcode.com/problems/swap-nodes-in-pairs/
*/
import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    
	public ListNode swapPairs(ListNode head)
	{
        if(head == null){
            return null;
        }
        ListNode tmp = head;
        ListNode rear,newhead;
        boolean flag = true;
        newhead=head;
        while(tmp != null && tmp.next != null ){
            if(flag){
                newhead = tmp.next;
                flag = false;
            }else{
                head.next = tmp.next;
            }
            head = tmp;
            rear = tmp.next.next;
            tmp.next.next = tmp;
            tmp.next = rear;
            
            tmp = rear;   
        }

        if(tmp != null && !flag){
            head.next = tmp;
        }
        return newhead;
    }

    public static ListNode makeCase()
    {
    	int[] nodes = {1};
    	ListNode head = new ListNode(nodes[0]);
    	ListNode curr=head;
    	ListNode tmp;
    	for(int i=1;i<nodes.length;i++){
    		tmp = new ListNode(nodes[i]);
    		curr.next = tmp;
    		curr = tmp;
    	}
    	return head;
    }

    public static void printList(ListNode head)
    {
    	while(head != null){
    		System.out.print(head.val + "->");
            head = head.next;
    	}
    	println("null");
    }
	
	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	ListNode t = makeCase();
        printList(t);
    	printList(s.swapPairs(t));    
    }
}