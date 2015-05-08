/*
Merge Intervals Total Accepted: 33806 Total Submissions: 151752 My Submissions Question Solution 
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
@https://leetcode.com/problems/merge-intervals/
*/
import java.io.*;
import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Node {

    Interval val;
    Node lchild,rchild;
   
    Node(Interval t) {this.val = t;}
}

public class Solution {
    
	public boolean biggerThan(Interval a, Interval b)
	{
	   return a.start > b.end;	
	}

    public boolean smallerThan(Interval a, Interval b)
    {
        return a.end < b.start;
    }

    public void visit(Node p,List<Interval> l)
    {
        if(p != null){
            visit(p.lchild);
            if(l.size() > 0){
                Interval last = l.get(l.size() - 1);
                if( !(last.start > p.val.end || last.end < p.val.start) ){
                    last.start = Math.min(t.start, p.val.start);
                    last.end =  Math.max(t.end, p.val.end);
                }
            }
        }
    }

    public void mergeTrees(Node p, Interval t)
    {
        if(p == null) return ;
        mergeTrees(p.lchild);
        mergeTrees(p.rchild);
        if(  p.lchild != null && !biggerThan(p.lchild.val, p.val) && !smallerThan(p.lchild.val, p.val) ){
            
        }else if( p.rchild != null && !biggerThan(p.rchild.val, p.val) && !smallerThan(p.rchild.val, p.val)){

        }
    }

    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new LinkedList<Interval>();
    	if(intervals.size() <= 1 ){
     		return intervals;
     	}	

        Node root = new Node(intervals.get(0));
        Node p = root;

        for(int i=1;i<intervals.size(;i++)){
            Interval t = intervals.get(i);
            
            for(;;){
                if( biggerThan(t, p.val) ){
                    if(p.rchild == null){
                        p.rchild = new Node(t);
                        break;
                    }else{
                        p = p.rchild;
                    }
                }else if(smallerThan(t, p.val)){
                    if(p.lchild == null){
                        p.lchild = new Node(t);
                        break;
                    }else{
                        p = p.lchild;
                    }
                }else{
                    p.val.start = Math.min(t.start, p.val.start);
                    p.val.end = Math.max(t.end, p.val.end);
                    break;
                }
            }
        }
  	  
     	return result;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	List<Interval> cases = new LinkedList<Interval>();	
    	cases.add(new Interval(2,3));
    	cases.add(new Interval(0,5));
    	//cases.add(new Interval(6,7));
    	///cases.add(new Interval(8,9));
    	//ses.add(new Interval(1,10));

    	for(Interval x : s.merge(cases)){
    		println(x.start + " " + x.end + "; ");
    	}    
    }
}