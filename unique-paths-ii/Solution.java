/*
Unique Paths II Total Accepted: 33745 Total Submissions: 120619 My Submissions Question Solution 
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

@https://leetcode.com/problems/unique-paths-ii/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] steps = new int[m][n];
        if(obstacleGrid[0][0] == 1) return 0;
        steps[0][0] = 1;
        int i;
        for(i = 1; i < n; i++) {
        	if(obstacleGrid[0][i] == 1) break;
        	steps[0][i] = 1;
        }
        for( ; i<n; i++){
        	steps[0][i] = 0;
        }

        for(i = 1; i < m; i++) {
        	if(obstacleGrid[i][0] == 1) break;
        	steps[i][0] = 1;
        }
        for( ; i < m; i++){
        	steps[i][0] = 0;
        }

        for(int k = 1; k < m; k++){
        	for(int p = 1; p < n; p++){
        		if(obstacleGrid[k][p] == 1){
        			steps[k][p] = 0;
        		}else{
        			steps[k][p] = steps[k-1][p] + steps[k][p-1];
        		}
        	}
        }

        /*
        for(int[] x : steps){
        	for(int y : x){
        		System.out.print(y + " ");
        	}
        	println("\n");
        }*/

        return steps[m-1][n-1];
    }

	public static void println(Object obj)
	{
		System.out.println(obj);
	}

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[][] a = {{0,0,0},{0,1,0},{0,0,0}};
    	println(s.uniquePathsWithObstacles(a));    
    }
}