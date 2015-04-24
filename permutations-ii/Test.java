//@https://leetcode.com/problems/permutations-ii/
import java.util.*;
import java.io.*;

class Solution {
    public  List<Integer> tmp = new LinkedList<Integer>();
    public  List<List<Integer>> res = new LinkedList<List<Integer>>();
    
    private static boolean canInsert(int number,int index,List<Integer> l)
    {

        if(index == 0){
        	return true;
        }

        for(int i=0;i<=index-1;i++){
        	if(l.get(i) == number){
        		return false;
        	}
        }

        return true;
    }
    
    /*
    public void add()
    {
    	List<Integer> t = new LinkedList<Integer>();
    	for(int x : tmp){
    		t.add(x);
    	}
    	res.add(t);
    }
    */
    private  void formatList(int[] num,int size,int index)
    {
    	if(index == size){		
    		//add();
    		List<Integer> t = new LinkedList<Integer>();
    		t.addAll(tmp);
    		res.add(t);
    	}else{
    		for(int i=0;i <= tmp.size();i++){
    			if(canInsert(num[index],i,tmp)){
    				tmp.add(i,num[index]);
    				formatList(num,size,index+1);
    				tmp.remove(i);
    			}
    		}
    	}
    }

    public List<List<Integer>> permuteUnique(int[] num) {
    
        int size = num.length;
        formatList(num,size,0);
        return res;
    }
}

public class Test{
	
	static void check(List<List<Integer>> nn)
	{
		for(int i=0;i<nn.size();i++){
			for(int j=0;j<nn.size();j++){
				if(i!=j && nn.get(i).equals(nn.get(j))){
					println("=========");
					println(nn.get(i));
				}
			}
		}
	}

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

	public static void main(String[] args){
		int num[] = {1,1};
		Solution s = new Solution();
		List<List<Integer>> nn = s.permuteUnique(num);
		
		println(nn);
		check(nn);
	}
}