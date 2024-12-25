package easy.string;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "axc", t = "ahbgdc" Output: false
 * 
 * Example 3:
 * 
 * Input: s = "", t = "ahbgdc" Output: false
 * 
 * 
 * @Topics Two Pointers, String, Dynamic Programming
 * 
 * https://leetcode.com/problems/is-subsequence/
 * 
 * @author bhavesh
 *
 */
public class IsSubsequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		Solution solution = new IsSubsequence().new Solution1();

		boolean isSubsequence = solution.isSubsequence(s, t);
		System.out.println("Output: " + isSubsequence);
	}

	interface Solution {
		public boolean isSubsequence(String s, String t);
	}

	class Solution1 implements Solution {

		@Override
		public boolean isSubsequence(String s, String t) {
			int i = 0;
			int j = 0;
			while (i < s.length() && j < t.length()) {
				if (s.charAt(i) == t.charAt(j)) {
					i++;
				}
				j++;
			}
			return i == s.length();
		}
	}

}
