/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

@https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/
import java.io.*;
import java.util.*;

class TreeLinkNode {
	int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    
    public void connect(TreeLinkNode root) {
    	
    	if(root == null){
    		return ;
    	}else if(root.left == null){
    		return ;
    	}

    	TreeLinkNode parent,curr,head;
    	parent = root;
    	head = null;
    	curr = null;

    	while(parent != null && parent.left!=null)
    	{
    		if(head == null ){
    			head = parent.left;
    			head.next = parent.right;  			
    		}else{
    			curr.next = parent.left;
    			parent.left.next = parent.right;
    		}
    		curr = parent.right;

    		parent = parent.next;
    		if(parent == null){
    			parent = head;
    			head = null;
    			curr = null;
    		}
    	}
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