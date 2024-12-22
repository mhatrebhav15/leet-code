package com.leetcode.easy.array;

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
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;

		int[] twoSum = twoSum(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}

	public static int[] twoSum(int[] nums, int target) {
		// HashMap to store numbers and their corresponding indices
		Map<Integer, Integer> numMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			// Check if the complement is already in the map
			if (numMap.containsKey(complement)) {
				// Return the indices of the complement and the current number
				return new int[] { numMap.get(complement), i };
			}
			numMap.put(nums[i], i);
		}

		// No solution found
		return new int[] {};
	}

}
