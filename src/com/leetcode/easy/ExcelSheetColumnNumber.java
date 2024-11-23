package com.leetcode.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {

	public static void main1(String[] args) {
		String columnTitle = "CBA";
		int ascii = 64;
		int output = 0;

		int digits = 1;
		for (int i = columnTitle.length() - 1; i >= 0; i--) {
			char c = columnTitle.charAt(i);
			int multiplyer = (i == columnTitle.length() - 1) ? 1 : ((digits++) * 26 * (i + 1));
			output = output + Math.abs(ascii - c) * multiplyer;
		}
		System.out.println(output);
	}

	public static void main2(String[] args) {
		String columnTitle = "CBA";
		int ascii = 64;
		int output = 0;
		int digits = columnTitle.length() - 1;
		for (int i = 0; i < columnTitle.length(); i++) {
			char c = columnTitle.charAt(i);
			output = output + (Math.abs(ascii - c) * (int) Math.pow(26, digits--));
		}
		System.out.println(output);
	}

	public static void main(String[] args) {
		String columnTitle = "CBA";
		int ascii = 64;
		int sum = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			char c = columnTitle.charAt(i);
			sum = sum * 26 + (c - ascii);
		}
		System.out.println(sum);
	}

}
