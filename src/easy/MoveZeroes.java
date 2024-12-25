package easy;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note : that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1: Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * Example 2: Input: nums = [0] Output: [0]
 * 
 * @link https://leetcode.com/problems/move-zeroes/
 * 
 * @topics Array, Two Pointers
 * 
 * @author bhavesh
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] s = { 0, 1, 0, 3, 12 };

		Solution solution = new MoveZeroes().new Solution1();
		solution.moveZeroes(s);
	}

	interface Solution {
		void moveZeroes(int[] nums);
	}

	class Solution1 implements Solution {

		@Override
		public void moveZeroes(int[] nums) {
			for (int left = 0; left < nums.length; left++) {
				int right = left + 1;
				while (right < nums.length && nums[right] == 0) {
					right++;
				}
				if (nums[left] == 0 && right < nums.length) {
					int temp = nums[left];
					nums[left] = nums[right];
					nums[right] = temp;
				}
			}
			System.out.println(Arrays.toString(nums));
		}

	}

	class Solution2 implements Solution {

		@Override
		public void moveZeroes(int[] nums) {
			int snowBallSize = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					snowBallSize++;
				} else if (snowBallSize > 0) {
					int t = nums[i];
					nums[i] = 0;
					nums[i - snowBallSize] = t;
				}
			}
			System.out.println(Arrays.toString(nums));
		}

	}

}
