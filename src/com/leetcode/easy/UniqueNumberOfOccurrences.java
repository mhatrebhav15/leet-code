package com.leetcode.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 2, 1, 1, 3 };
		System.out.println(uniqueOccurrences(arr));
	}

	public static boolean uniqueOccurrences1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		return map.size() == new HashSet<>(map.values()).size();
	}
	
	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Collection<Integer> collection = map.values();
		Set<Integer> set = new HashSet<>(collection.size());
        for (Integer element : collection) {
            if (!set.add(element)) {
                return false;
            }
        }
        return true;
	}

}
