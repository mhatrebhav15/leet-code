package com.bhav.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * 
 * @author bhavesh
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
//		int[] nums = { 1, 1, 2 };
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int k = removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(k);
	}

	public static int removeDuplicates(int[] nums) {
		int k = 1;
		int val = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k] = nums[i];
				val = nums[i];
				k++;
			}
		}
		return k;
	}

	public static int removeDuplicates2(int[] nums) {
		int k = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
	}

}
