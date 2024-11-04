package com.bhav.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * @link https://leetcode.com/problems/two-sum/
 * 
 * @author bhavesh
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// Example 1
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;

		Solution solution = new TwoSum().new Solution3();
		int[] twoSum = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}

	interface Solution {
		int[] twoSum(int[] nums, int target);
	}

	/*
	 * Less than average
	 */
	static class Solution1 implements Solution {

		@Override
		public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (i != j) {
						int sum = nums[i] + nums[j];
						if (sum == target) {
							return new int[] { i, j };
						}
					}
				}
			}
			return new int[0];
		}

	}

	/*
	 * Moderately fast
	 */
	class Solution2 implements Solution {

		@Override
		public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					int sum = nums[i] + nums[j];
					if (sum == target) {
						return new int[] { i, j };
					}
				}
			}
			return new int[0];
		}

	}

	/*
	 * HashMap is faster
	 */
	class Solution3 implements Solution {

		@Override
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			final int length = nums.length;
			int[] res = new int[2];

			for (int i = 0; i < length; i++) {
				int current = nums[i];
				int x = target - current;
				if (map.containsKey(x)) {
					res[0] = map.get(x);
					res[1] = i;
					return res;
				} else {
					map.put(current, i);
				}
			}

			return null;
		}

	}

}
