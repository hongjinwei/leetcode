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

/*
class Node {

    Interval val;
    Node lchild,rchild;
   
    Node(Interval t) {this.val = t;}
}
*/

public class Solution {
    
	public boolean biggerThan(Interval a, Interval b)
	{
	   return a.start > b.end;	
	}

    public boolean smallerThan(Interval a, Interval b)
    {
        return a.end < b.start;
    }

    public boolean canMerge(Interval a, Interval b)
    {
        return !(biggerThan(a,b) || smallerThan(a,b));
    }

    public Interval mergeInterval(Interval a, Interval b)
    {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end ));
    }

    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new LinkedList<Interval>();
    	if(intervals.size() <= 1 ){
     		return intervals;
     	}	

        result.add(intervals.get(0));

        for(int i=1;i<intervals.size(); i++){
            Interval t = intervals.get(i);
            
            for(int j=0; j<result.size(); j++){
                Interval tmp = result.get(j);
                if( canMerge(t, tmp) ){
                    t = mergeInterval(t, tmp);
                    result.set(j, t);
                    
                    for(int k=j+1; k<result.size(); k++){
                        Interval tmp2 = result.get(k);
                        if( canMerge(t, tmp2) ){
                            t = mergeInterval(t, tmp2);
                            result.set(j, t);
                            result.remove(k);
                            k--;
                            continue;
                        }else{
                            break;
                        }
                    }
                    break;
                }else if(smallerThan(t, tmp)){                  
                    result.add(j, t);
                    break;
                }else if( j == (result.size()-1) && biggerThan(t, tmp)){    
                    result.add(j+1, t);
                    break;
                }
            }
        }
  	  
     	return result;
    }

    public void p(List<Interval> l)
    {
        for(Interval x:l){
            System.out.print(x.start + " " + x.end + "; ");
        }
        println("\n");
    }


	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	List<Interval> cases = new LinkedList<Interval>();	
    	cases.add(new Interval(2,3));
    	cases.add(new Interval(4,5));
    	cases.add(new Interval(6,7));
    	cases.add(new Interval(0,11));
        cases.add(new Interval(8,9));
    	cases.add(new Interval(1,10));
        List<Interval> l = s.merge(cases);
    	println(l.size());
        s.p(l);
    }
}