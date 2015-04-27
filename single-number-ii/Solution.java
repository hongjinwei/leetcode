/*
@https://leetcode.com/problems/single-number-ii/
Given an array of integers, 
every element appears three times except for one. 

Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

*/

public class Solution{

	private int sameOr(int a,int b)
	{
		//return a&b;
		//return (a&b) | ( (a|b)^(-1) );
		
		int c=0;
		while(a>0 || b>0){
			
			if(a%2 == b%2){
				c = (c << 1) + 1;
			}else{
				c = c << 1;
			}

			a = a>>1
			b = b>>1;

		}
		
		return c;
		
	}

	public int singleNumber(int[] nums) {
        for(int i=1; i<nums.length; i++){
        	//nums[0] = nums[0] ^ nums[i]  nums[i];
        }

        return nums[0];
    }
	
	public static void main(String[] args){
		int[] nums = {1,1,1,2,2,2,3};
		Solution s = new Solution();
		//System.out.println(s.singleNumber(nums));
		System.out.println( (s.sameOr(1,3^2)));
		//System.out.println(~(2&0xffffffff));
	}
}