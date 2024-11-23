package com.leetcode.easy;

public class ReverseVowelsOfAString {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		StringBuilder builder = new StringBuilder(s);
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			while (i < j && !isVowel(s.charAt(i))) {
				i++;
			}
			
			while (i < j && !isVowel(s.charAt(j))) {
				j--;
			}

			builder.setCharAt(i, s.charAt(j));
			builder.setCharAt(j, s.charAt(i));
			i++;
			j--;
		}
		return builder.toString();
	}

	public static boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
