package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * @link https://leetcode.com/problems/plus-one/
 * 
 * @author bhavesh
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		Solution solution = new PlusOne().new Solution2();

		int[] digits = new int[] { 9 };
		int[] plusOne = solution.plusOne(digits);
		System.out.println(Arrays.toString(plusOne));
	}

	interface Solution {
		int[] plusOne(int[] digits);
	}

	class Solution1 implements Solution {

		@Override
		public int[] plusOne(int[] digits) {
			int lastIndex = digits.length - 1;

			int carry = 0;
			boolean reverse = true;
			List<Integer> integers = new LinkedList<>();

			for (int i = lastIndex; i >= 0; i--) {
				int current = digits[i];
				if (lastIndex == i || carry == 1) {
					current = current + 1;
				}
				carry = current / 10;
				integers.add(carry == 1 ? 0 : current);
			}

			if (carry == 1) {
				integers.add(0, carry);
				reverse = false;
			}

			if (reverse) {
				Collections.reverse(integers);
			}

			int[] array = new int[integers.size()];
			for (int i = 0; i < array.length; i++) {
				array[i] = integers.get(i).intValue();
			}
			return array;
		}

	}

	class Solution2 implements Solution {

		@Override
		public int[] plusOne(int[] digits) {
			String number = "";
			for (int i = 0; i < digits.length; i++) {
				number = number + digits[i];
			}
			Long num = Long.parseLong(number) + 1;
			System.out.println(num);

			number = num.toString();
			int[] array = new int[number.length()];
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
			}
			return array;
		}

	}

}
