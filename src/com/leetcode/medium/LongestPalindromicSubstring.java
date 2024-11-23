package com.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/longest-palindromic-substring
 * 
 * @author bhavesh
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "babad";
		String longestPalindrome = longestPalindrome(s);
		System.out.println(longestPalindrome);
	}

	public static String longestPalindrome(String s) {
		String reverseString = reverseString(s);
		dp(s, 2);
		return reverseString;
	}

	private static void dp(String s, int group) {
		for (int i = 0; i < s.length(); i++) {
			int max = (i + group) > (s.length() - 1) ? s.length() : (i + group);
			String substring = s.substring(i, max);
			System.out.println(substring);
			System.out.println(reverseString(substring));
		}
	}

	private static String reverseString(String s) {
		String rev = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			rev += s.charAt(i);
		}
		return rev;
	}

}
