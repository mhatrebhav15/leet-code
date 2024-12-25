/**
 * 
 */
package easy;

/**
 * Given a string s consisting of some words separated by some number of spaces,
 * return the length of the last word in the string.
 * 
 * @link https://leetcode.com/problems/length-of-last-word/
 * 
 * @author bhavesh
 *
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = "luffy is still joyboy";

		Solution solution = new LengthOfLastWord().new Solution1();
		int lengthOfLastWord = solution.lengthOfLastWord(s);
		System.out.println(lengthOfLastWord);
	}

	interface Solution {
		int lengthOfLastWord(String s);
	}

	class Solution1 implements Solution {

		@Override
		public int lengthOfLastWord(String s) {
			String trimmedString = s.trim();
			String lastWord = trimmedString.substring(trimmedString.lastIndexOf(" ") + 1);
			return lastWord.length();
		}

	}

	class Solution2 implements Solution {

		@Override
		public int lengthOfLastWord(String s) {
			String trimmedString = s.trim();
			int z = 0;
			for (int i = trimmedString.length() - 1; i >= 0; i--) {
				char ch = trimmedString.charAt(i);
				if (ch == ' ') {
					break;
				}
				z++;
			}
			return z;
		}

	}

}
