/**
 * ZigZag Conversion My Submissions Question Total Accepted: 67056 Total
 * Submissions: 299317 Difficulty: Easy The string "PAYPALISHIRING" is written
 * in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a
 * string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR". Subscribe to see which companies asked this question
 * 
 * @author BAO
 * 
 */
public class Solution {

	public String convert(String s, int numRows) {
		if (numRows == 1 || s.length() < numRows) {
			return s;
		}

		int gapSum = numRows * 2 - 2;
		int lGap = gapSum;
		int rGap = 0;
		StringBuffer sb = new StringBuffer();
		boolean b;
		for (int rowCount = 0; rowCount < numRows; rowCount++) {
			b = true;
			int i = rowCount;
			while (i < s.length()) {
				int gap = (rowCount == 0 || rowCount == (numRows - 1)) ? gapSum : (b) ? lGap : rGap;
				sb.append(s.charAt(i));
				i += gap;
				b = !b;
			}
			lGap -= 2;
			rGap += 2;

		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		// System.out.println(s.convert("PAYPALISHIRING", 3));
		System.out.println(s.convert("PAYPALISHIRING", 4));
	}
}
