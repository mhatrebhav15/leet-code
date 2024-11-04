package com.bhav.leetcode.easy;

import java.util.StringJoiner;

public class ReverseWordsInAString {
	
	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
	
    public static String reverseWords(String s) {
    	String[] split = s.trim().split("\\s");
    	StringJoiner joiner = new StringJoiner(" ");
    	for (int i = split.length - 1; i >= 0; i--) {
			if (!"".equals(split[i])) {
				joiner.add(split[i]);
			}
		}
		return joiner.toString();
    }

}
