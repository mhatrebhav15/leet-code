package easy.math;

/**
 * Given an integer x, return true if x is palindrome integer.
 * 
 * An integer is a palindrome when it reads the same backward as forward.
 * 
 * @link https://leetcode.com/problems/palindrome-number/
 * 
 * @author bhavesh
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		int x = -3553;

		Solution solution = new PalindromeNumber().new Solution1();
		boolean palindrome = solution.isPalindrome(x);
		System.out.println(palindrome);
	}

	interface Solution {
		boolean isPalindrome(int x);
	}

	/*
	 * Easy to read
	 */
	class Solution1 implements Solution {

		@Override
		public boolean isPalindrome(int x) {
			if (x == 0) {
				return true;
			} else if (x < 0 || x % 10 == 0) {
				return false;
			}

			int originalNumber = x;
			int reversedNum = 0;
			int remainder;

			while (x != 0) {
				remainder = x % 10;
				reversedNum = reversedNum * 10 + remainder;
				x = x / 10;
			}

			return originalNumber == reversedNum;
		}

	}

	/*
	 * Complex to read
	 */
	class Solution2 implements Solution {

		@Override
		public boolean isPalindrome(int x) {
			if (x < 0 || (x != 0 && x % 10 == 0)) {
				return false;
			}

			int reversedNum = 0;

			while (x > reversedNum) {
				reversedNum = reversedNum * 10 + x % 10;
				x /= 10;
			}

			return (x == reversedNum || x == reversedNum / 10);
		}

	}

}
