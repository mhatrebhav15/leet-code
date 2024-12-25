package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * https://leetcode.com/problems/majority-element
 * 
 * @author bhavesh
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };
		int majorityElement = majorityElement(nums);
		System.out.println(majorityElement);
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > nums.length / 2) {
				return entry.getKey();
			}
		}
		return 0;
	}

}
