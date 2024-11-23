package com.leetcode.hard;

public class TrappingRainWater {

	public static void main(String[] args) {
//		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int[] height = { 4, 2, 0, 3, 2, 5 };
		int[] height = { 4, 2, 3 };
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
		return trap(height, 0);
	}

	public static int trap(int[] height, int i) {
//		System.out.println(i);
		int units = 0;
		int currentUnits = 0;
		int currentLargestIndex = i;
		boolean found = false;
		while (i < height.length) {
			if (height[i] < height[currentLargestIndex]) {
				found = false;
				currentUnits = currentUnits + (height[currentLargestIndex] - height[i]);
			} else {
				found = true;
				currentLargestIndex = i;
			}
			if (found) {
				units = units + currentUnits;
				currentUnits = 0;
			}
			if (i == height.length - 1 && !found) {
				units = units + trap(height, currentLargestIndex + 1);
			}
			i++;
		}
		return units;
	}

}
