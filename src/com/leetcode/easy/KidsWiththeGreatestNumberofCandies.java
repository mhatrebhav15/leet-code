package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsWiththeGreatestNumberofCandies {

	public static void main(String[] args) {
		int[] candies = { 2, 3, 5, 1, 3 };
		int extraCandies = 3;
		Solution solution = new KidsWiththeGreatestNumberofCandies().new Solution3();
		List<Boolean> kidsWithCandies = solution.kidsWithCandies(candies, extraCandies);
		System.out.println(kidsWithCandies);
	}

	interface Solution {
		List<Boolean> kidsWithCandies(int[] candies, int extraCandies);
	}

	class Solution1 implements Solution {

		@Override
		public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			int maxCandies = Arrays.stream(candies).max().getAsInt();
			return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= maxCandies)
					.collect(Collectors.toList());
		}

	}

	class Solution2 implements Solution {

		@Override
		public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			int maxCandies = Arrays.stream(candies).max().getAsInt();
			List<Boolean> list = new ArrayList<>();
			for (int candy : candies) {
				list.add(candy + extraCandies >= maxCandies);
			}
			return list;
		}

	}

	class Solution3 implements Solution {

		@Override
		public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			int maxCandies = candies[0];

			for (int candy : candies) {
				if (candy > maxCandies) {
					maxCandies = candy;
				}
			}

			List<Boolean> list = new ArrayList<>(candies.length);
			for (int candy : candies) {
				list.add(candy + extraCandies >= maxCandies);
			}
			return list;
		}

	}

}
