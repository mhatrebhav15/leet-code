package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {

	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();
		int[] array = new int[] { 2, 2, 1 };
		System.out.println(singleNumber.singleNumber(array));
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer integer = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
			map.put(nums[i], integer + 1);
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (1 == entry.getValue()) {
				return entry.getKey();
			}
		}
		return 0;
	}

}
