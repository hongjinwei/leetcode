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

public class Solution {
    
	public void check(List<Interval> l, int index)
	{
		int flag = false;
		
	}

    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new LinkedList<Interval>();
    	if(intervals.size() <= 1 ){
     		return intervals;
     	}	

     	result.add(intervals.get(0));
     	for(int i=1; i < intervals.size(); i++){
			Interval t = intervals.get(i);

     	}

     	int min,p;
     	while(intervals.size() >= 2 ){
     		min = intervals.get(0).start;
     		p = 0;
     		int i = 1;

     		for(; i<intervals.size(); i++){
     			if(intervals.get(i).start < min){
     				min = intervals.get(i).start;
     				p = i;
     			}
     		}
     		l.add(intervals.get(p));
     		intervals.remove(p);
     	}
     	l.add(intervals.get(0));
		
		Interval tmp = l.get(0);
     	for(int j=1; j < l.size() ;j++){
	     	
	     	
	     	if(!(t.start > tmp.end || t.end < tmp.start)){
	     			
	     		tmp.start = Math.min(t.start, tmp.start);
	     		tmp.end = Math.max(t.end, tmp.end);
	     	}else{
	     		result.add(tmp);
	     		tmp = t;
	     	}
	    }

		result.add(tmp);    	  
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