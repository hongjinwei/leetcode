/*
Balanced Binary Tree Total Accepted: 54698 Total Submissions: 170428 My Submissions Question Solution 
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

@https://leetcode.com/problems/balanced-binary-tree/
*/
import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    
    boolean flag = true;

    public int getHeight(TreeNode p)
    {
    	if(p == null) return 0;
    	if(!flag) return -1;
    	int l = getHeight(p.left);
    	int r = getHeight(p.right);

    	if( (l - r)<-1 || (l-r)>1 ){ 
    		flag = false;
    	}
    	return Math.max( l, r)+1;
    }

    public boolean isBalanced(TreeNode root) 
    {
    	getHeight(root);
    	return flag;    
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	TreeNode root = new TreeNode(1);
    	TreeNode a = new TreeNode(2);
    	TreeNode b = new TreeNode(3);
    	TreeNode c = new TreeNode(4);
    	TreeNode d = new TreeNode(5);
    	//c.right = d;
    	b.right = c;
    	root.left = a;
    	root.right = b;

    	println(s.isBalanced(root));    
    }
}