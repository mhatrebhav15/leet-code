package com.bhav.leetcode.easy;

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		int climbStairs = climbingStairs.climbStairs(3);
		System.out.println(climbStairs);
	}

	public int climbStairs(int n) {
		int one = 1;
		int two = 1;
		for (int i = 0; i < n - 1; i++) {
			int temp = one;
			one = one + two;
			two = temp;

		}
		return one;
	}

}
