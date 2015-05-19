/*
Rotate Image Total Accepted: 35736 Total Submissions: 111952 My Submissions Question Solution 
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

@https://leetcode.com/problems/rotate-image/
*/
import java.io.*;
import java.util.*;

public class Solution {
    
	public void rotateElement(int[][] matrix, int i, int j, int len) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[len-1-j][i];
		matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
		matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
		matrix[j][len-1-i] = tmp;
	}

	public void rotate(int[][] matrix) {
		if(matrix.length == 0) return;
		int len = matrix[0].length;
        if( len <= 1 ) return;

        int boundary = len/2;
        for(int i = 0; i < boundary; i++ ) {
        	for(int j = 0; j < boundary; j++ ){
        		rotateElement(matrix, i, j, len);
        	}
        }

        
        if(len%2 == 1) {
        	int k = len/2;
        	for(int i = 0; i < k; i++){
        		rotateElement(matrix, i, k, len);
        	}
        }
    }

	public static void showImage(int[][] p) {
		for(int x[] : p) {
			for(int y : x) {
				//System.out.print(y + "  ");
				System.out.format("%4d", y);
			}
			println("\n");
		}
		println();
	}

	public static void println() {
		System.out.println();
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	public static int[][] create(int n) {
		int[][] a = new int[n][n];
		int count = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0 ;j < n; j++){
				a[i][j] = count++; 
			}
		}
		return a;
	}

    public static void main(String[] args) {
    	Solution solu = new Solution();
  
  	/*
    	int[][] image = {
    		{1,2,3},
    		{4,5,6},
    		{7,8,9}
    	};
	*/
    	int[][] image = create(5);
    	showImage(image);
    	solu.rotate(image);
    	showImage(image);
    	println();    
    }
}