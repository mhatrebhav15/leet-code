package com.bhav.leetcode.easy;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t +
 * ... + t + t (i.e., t is concatenated with itself one or more times).
 * 
 * Given two strings str1 and str2, return the largest string x such that x
 * divides both str1 and str2.
 * 
 * 
 * Example 1:
 * 
 * Input: str1 = "ABCABC", str2 = "ABC" Output: "ABC" Example 2:
 * 
 * Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB" Example 3:
 * 
 * Input: str1 = "LEET", str2 = "CODE" Output: ""
 * 
 * Input: str1 = "ABABABAB", str2 = "ABAB" Output: "ABAB"
 * 
 * @link https://leetcode.com/problems/greatest-common-divisor-of-strings
 * 
 * @author bhavesh
 *
 */
public class GreatestCommonDivisorOfStrings {

	public static void main(String[] args) {
//		String str1 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
//		String str2 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String str1 = "ABCABC";
		String str2 = "ABC";
//		String str1 = "ABCAAA";
//		String str2 = "ABC";
		System.out.println("Output: " + gcdOfStrings4(str1, str2));
	}

	public static String gcdOfStrings4(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		if (n1 < n2)
			return gcdOfStrings4(str2, str1);
		if (str1.equals(str2))
			return str1;
		if (str1.startsWith(str2))
			return gcdOfStrings4(str1.substring(n2), str2);
		return "";
	}

	public static String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1))
			return "";
		int gcd = gcd(str1.length(), str2.length());
		return str1.substring(0, gcd);
	}

	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static String gcdOfStrings3(String str1, String str2) {
		if (str1.equals(str2)) {
			return str1;
		}
		String min = str1.length() < str2.length() ? str1 : str2;
		String max = str1.length() > str2.length() ? str1 : str2;

		if (min.length() == 0 || !max.startsWith(min)) {
			return "";
		}

		String gcd = "";
		String concat = "";
		for (int i = 0; i < min.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				concat += min.charAt(i);
				if (str1.replace(concat, "").equals(str2.replace(concat, ""))) {
					int length = concat.length();
					if (str1.length() % length == 0 && str2.length() % length == 0) {
						gcd = concat;
					}
				}
			} else {
				return "";
			}
		}

		if (!"".equals(str1.replace(gcd, "")) || !"".equals(str2.replace(gcd, ""))) {
			return "";
		}

		if ("".equals(gcd)) {
			return "";
		}
		int maxLength = max.length();
		int minLength = min.length();

		if (maxLength % minLength == 0) {
			String n = gcd;
			for (int i = 1; i < minLength / gcd.length(); i++) {
				n += gcd;
			}
			return n;
		} else {
			String tmp = gcd;
			for (int i = 1; i < minLength; i++) {
				tmp += gcd;
				if ("".equals(min.replace(tmp, ""))) {

				}
			}
		}
		return gcd;
	}

	public static String gcdOfStrings2(String str1, String str2) {
		String min = str1.length() < str2.length() ? str1 : str2;
		String max = str1.length() > str2.length() ? str1 : str2;
		if (min.length() == 0) {
			return "";
		}
		String gcd = "";
		String concat = "";
		for (int i = 0; i < min.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				concat += min.charAt(i);
				if (str1.replace(concat, "").equals(str2.replace(concat, ""))) {
					int length = concat.length();
					if (str1.length() % length == 0 && str2.length() % length == 0) {
						gcd = concat;
					}
				}
			} else {
				return "";
			}
		}
		int i = 0;
		while (i < max.length()) {
			if (!max.substring(i, gcd.length() + i).equals(gcd)) {
				return "";
			}
			i += gcd.length();
		}
		return gcd;
	}

	public static String gcdOfStrings1(String str1, String str2) {
		String min = str1.length() < str2.length() ? str1 : str2;
		if (min.length() == 0) {
			return "";
		}
		char ch = min.charAt(0);
		String gcd = "";
		for (int i = 0; i < min.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				if (i != 0 && ch == min.charAt(i)) {
					return gcd;
				} else {
					gcd += min.charAt(i);
				}
			}
		}
		return str1.replace(gcd, "").equals(str2.replace(gcd, "")) ? gcd : "";
	}

}
