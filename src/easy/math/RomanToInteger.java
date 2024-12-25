/**
 * 
 */
package easy.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * For example, 2 is written as II in Roman numeral, just two one's added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * @link https://leetcode.com/problems/roman-to-integer/
 * 
 * @note sometimes we might think using map is faster but in this case switch
 *       statement is faster
 * 
 * @author bhavesh
 * 
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		String roman = "MCMXCIV";

		Solution solution = new RomanToInteger().new Solution1();
		int romanToInt = solution.romanToInt(roman);
		System.out.println(romanToInt);
	}

	interface Solution {
		int romanToInt(String roman);
	}

	/*
	 * Using Map
	 * 
	 * Moderate
	 */
	class Solution1 implements Solution {

		@Override
		public int romanToInt(String roman) {
			int result = 0;
			int previousInteger = 0;
			Map<Character, Integer> map = getRomanAndIntegerMap();

			char[] charArray = roman.toCharArray();
			final int length = charArray.length;
			for (int i = 0; i < length; i++) {
				Integer currentInteger = map.get(charArray[i]);
				if (i > 0 && currentInteger > previousInteger) {
					result += currentInteger - 2 * previousInteger;
				} else {
					result += currentInteger;
				}
				previousInteger = currentInteger;
			}
			return result;
		}

		private Map<Character, Integer> getRomanAndIntegerMap() {
			Map<Character, Integer> map = new HashMap<>();
			map.put('I', 1);
			map.put('V', 5);
			map.put('X', 10);
			map.put('L', 50);
			map.put('C', 100);
			map.put('D', 500);
			map.put('M', 1000);
			return map;
		}

	}

	/*
	 * Using Switch Statement
	 * 
	 * Faster
	 */
	class Solution2 implements Solution {

		@Override
		public int romanToInt(String roman) {
			
			int result = 0;
			int previousInteger = 0;

			char[] charArray = roman.toCharArray();
			final int length = charArray.length;
			for (int i = 0; i < length; i++) {
				Integer currentInteger = getNumberFromRoman(charArray[i]);
				if (i > 0 && currentInteger > previousInteger) {
					result += currentInteger - 2 * previousInteger;
				} else {
					result += currentInteger;
				}
				previousInteger = currentInteger;
			}
			return result;
		}

		private int getNumberFromRoman(char roman) {
			int number = 0;
			switch (roman) {
			case 'I':
				number = 1;
				break;
			case 'V':
				number = 5;
				break;
			case 'X':
				number = 10;
				break;
			case 'L':
				number = 50;
				break;
			case 'C':
				number = 100;
				break;
			case 'D':
				number = 500;
				break;
			case 'M':
				number = 1000;
				break;
			default:
				break;
			}
			return number;
		}

	}

}
