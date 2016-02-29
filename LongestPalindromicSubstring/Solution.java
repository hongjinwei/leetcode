package leetcode.LongestPalindromicSubstring;

/**
 * 5. Longest Palindromic Substring My Submissions Question Total Accepted:
 * 95233 Total Submissions: 423250 Difficulty: Medium Given a string S, find the
 * longest palindromic substring in S. You may assume that the maximum length of
 * S is 1000, and there exists one unique longest palindromic substring.
 * 
 * Subscribe to see which companies asked this question
 * 
 * @author BAO
 * 
 */
public class Solution {

	// flags[i][j] = true means i-j substring is palindromic
	boolean[][] flags = new boolean[1000][1000];

	public String longestPalindrome(String s) {
		int n = s.length();

		// init this matrix
		for (int i = 0; i < n; i++) {
			this.flags[i][i] = true;
		}

		int maxLen = 1;
		int begin = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				flags[i][i + 1] = true;
				maxLen = 2;
				begin = i;
			} else {
				flags[i][i + 1] = false;
			}
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n; i++) {
				int j = i + len - 1;
				if (j >= n) {
					break;
				}
				if (s.charAt(j) == s.charAt(i) && flags[i + 1][j - 1]) {
					flags[i][j] = true;
					maxLen = len;
					begin = i;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = begin; i < begin + maxLen; i++) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String k = "abb";
		System.out.println(s.longestPalindrome(k));
	}
}
