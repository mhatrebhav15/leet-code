/**
 * 
 */
package easy.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/valid-parentheses/description/
 * 
 * @author bhavesh
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
//		String s = "()"; // false
		String s = "([)]"; // false
//		String s = "(]"; 	// false
//		String s = "([])"; 	// true

		Solution solution = new ValidParentheses().new Solution3();
		boolean valid = solution.isValid(s);
		System.out.println(valid);
	}

	interface Solution {
		boolean isValid(String s);
	}

	class Solution1 implements Solution {

		public boolean isValid(String s) {
			Stack<Character> leftSymbols = new Stack<>();

			for (char c : s.toCharArray()) {
				if (c == '(' || c == '{' || c == '[') {
					leftSymbols.push(c);
				} else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
					leftSymbols.pop();
				} else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
					leftSymbols.pop();
				} else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
					leftSymbols.pop();
				} else {
					return false;
				}
			}
			return leftSymbols.isEmpty();
		}

	}

	class Solution2 implements Solution {

		@Override
		public boolean isValid(String s) {
			Map<Character, Boolean> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				switch (ch) {
				case '(':
				case '[':
				case '{':
					map.put(ch, false);
					break;
				case ')':
					map.put('(', true);
					break;
				case ']':
					map.put('[', true);
					break;
				case '}':
					map.put('{', true);
					break;
				default:
					break;
				}
			}
			return map.values().stream().anyMatch(n -> n);
		}

	}

	class Solution3 implements Solution {
		public boolean isValid(String s) {
			char[] chars = s.toCharArray();
			List<Character> list = new ArrayList<>();

			for (char c : chars) {
				switch (c) {
				case '{':
					list.add(c);
					break;
				case '[':
					list.add(c);
					break;
				case '(':
					list.add(c);
					break;
				case '}':
					if (list.isEmpty() || list.remove(list.size() - 1) != '{') {
						return false;
					}
					break;
				case ']':
					if (list.isEmpty() || list.remove(list.size() - 1) != '[') {
						return false;
					}
					break;
				case ')':
					if (list.isEmpty() || list.remove(list.size() - 1) != '(') {
						return false;
					}
					break;
				default:
					break;
				}
			}
			return list.isEmpty();
		}
	}

}
