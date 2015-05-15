/*
Unique Paths Total Accepted: 43890 Total Submissions: 133888 My Submissions Question Solution 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.

@https://leetcode.com/problems/unique-paths/
*/
import java.io.*;
import java.util.*;


public class Solution {


	/*this method cause time  exceed limitation,should use Dynamic Programming  
	int count = 0;
    
	void process(int m, int n,int i, int j){
		if(i == m && j == n){
			count++;
			return ;
		}else{
			if(i <= m -1){
				process(m,n,i+1,j);
			}
			if(j <= n-1){
				process(m,n,i,j+1);
			}
		}
	}

    public int uniquePaths(int m, int n) {
   		this.count = 0;
   		process(m,n,1,1);
   		return count;
    }
    */

    public int uniquePaths(int m, int n) {
   		int[][] steps = new int[m][n];
   		for(int i = 0; i < m; i++){
   			steps[i][0] = 1;
   		}

   		for(int i = 0; i < n; i++){
   			steps[0][i] = 1;
   		}

   		for(int i = 1; i < m; i++){
   			for(int j = 1; j < n; j++){
   				steps[i][j] = steps[i-1][j] + steps[i][j-1];
   			}
   		}
   		return steps[m-1][n-1];
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	
    	println(s.uniquePaths(3,3));    
    }
}