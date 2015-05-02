/*


@
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    public String sortStr(String s)
    {
    	char[] array = s.toCharArray();
    	Arrays.sort(array);
    	return String.valueOf(array);
    } 

    public List<String> anagrams(String[] strs) {
   		List<String> res = new LinkedList<String>();
   		String[] sortedStr = new String[strs.length];
		boolean flag;
   		for(int i=0;i<strs.length;i++){
   			sortedStr[i] = sortStr(strs[i]); 
   		}

   		String tmp = "";
   		for(int i=0;i<strs.length;i++){
   			tmp = sortedStr[i];
   			if(tmp == null){ 
   				continue;
   			}

   			flag = false;
   			for(int j=i+1;j<strs.length;j++){
   				
   				if(sortedStr[j] != null && tmp.equals(sortedStr[j])){
   					res.add(strs[j]);
   					sortedStr[j] = null;
   					flag = true;
   				}
   			}
   			sortedStr[i] = null;
   			if(flag){
   				res.add(strs[i]);
   			}
   		}

   		return res;
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] str = {"",""};
    	println(s.anagrams(str));    
    }
}