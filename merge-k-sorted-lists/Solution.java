/*Merge k Sorted Lists Total Accepted: 41185 Total Submissions: 194929 My Submissions Question Solution 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

@https://leetcode.com/problems/merge-k-sorted-lists/
*/
import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
    	LinkedList<Integer> l = new LinkedList<Integer>();
    	ListNode head,p,q;

    	for(ListNode x :lists){
    		while(x!=null){
    			l.add(x.val);
    			x = x.next;
    		}
    	}	    

    	if(l.size() == 0){
    		return null;
    	}else{
    		int[] tmp = new int[l.size()];
			int k = 0;
			for(int x:l){
				tmp[k++] = x;
			}
    		Arrays.sort(tmp);
    		head = new ListNode(tmp[0]);
    		p = head;
    		
    		for(int i=1;i<tmp.length;i++){
    			q = new ListNode(tmp[i]);
    			p.next = q;
    			p = q;			
    		}

    	}
    	return head;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	

    	//println();    
    }
}