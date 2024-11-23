package com.leetcode.easy;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/merge-sorted-array
 * 
 * @author bhavesh
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		merge(nums1, m, nums2, n);
		Arrays.sort(nums1);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < nums2.length; i++) {
			nums1[m + i] = nums2[i];
		}
	}

}
