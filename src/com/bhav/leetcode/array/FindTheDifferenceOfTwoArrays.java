package com.bhav.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDifferenceOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 3 };
		int[] nums2 = { 1, 1, 2, 2 };
		List<List<Integer>> findDifference = new FindTheDifferenceOfTwoArrays().findDifference(nums1, nums2);
		System.out.println(findDifference);
	}

	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> answer = new ArrayList<>();
		List<List<Integer>> k = new ArrayList<>();
		for (int i : nums2) {
			map.put(i, 1);
		}
		for (int i : nums1) {
			if (!map.containsKey(i)) {
				answer.add(i);
				map.put(i, 1);
			}
		}
		k.add(answer);
		answer = new ArrayList<>();
		map = new HashMap<>();
		for (int i : nums1) {
			map.put(i, 1);
		}
		for (int i : nums2) {
			if (!map.containsKey(i)) {
				answer.add(i);
				map.put(i, 1);
			}
		}
		k.add(answer);
		return k;
	}

	public List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
		return Arrays.asList(difference(nums1, nums2), difference(nums2, nums1));
	}

	List<Integer> difference(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		for (int i : nums1) {
			boolean present = false;
			for (int j : nums2) {
				if (!present) {
					present = i == j;
				}
			}
			if (!present && !list.contains(i)) {
				list.add(i);
			}
		}
		return list;
	}

}
