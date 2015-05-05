/*


@
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
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
    	Interval x;
    	List<Interval> result = new LinkedList<Interval>();
        if(newInterval == null){
            return intervals;
        }else if(intervals.size() == 0){
            result.add(newInterval);
            return result;
        }

    	while(intervals.size() > 0){
         	x = intervals.get(0);
    	 	intervals.remove(0); 	
    	 	if( (newInterval.end >= x.start && newInterval.start <= x.end) 
    	 		|| (newInterval.start <= x.end && newInterval.start >= x.start) ){
				
    	 		newInterval.start = Math.min(x.start, newInterval.start);
    	 		newInterval.end = Math.max(x.end,newInterval.end);
    	 	}else{
    	 		result.add(x);
    	 	}
    	}

        if(result.size() == 0){
            result.add(newInterval);
            return result;
        }
        Interval tmp;
        for(int i=0; i<result.size(); i++){
            tmp = result.get(i);
            if(tmp.start > newInterval.end){
                result.add(i, newInterval);
                break;
            }else if(i == (result.size() -1) ){
                result.add(i+1, newInterval);
                break;
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
    	List<Interval> l = new LinkedList<Interval>();
    	l.add(new Interval(1,5));
    	//l.add(new Interval(2,3));
    	for(Interval x: l){
    		System.out.print(x.start + " ," + x.end + " ;");   
        }  
    	println("\n======");
    	List<Interval> k = s.insert(l, new Interval(2,3));
    	println("\n======");
        for(Interval x: k){
    		System.out.print(x.start + " ," + x.end + " ; ");
    	}    
    }
}