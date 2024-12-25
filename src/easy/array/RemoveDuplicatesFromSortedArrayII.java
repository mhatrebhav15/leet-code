package easy.array;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 * 
 * @author bhavesh
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		int k = removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(k);

	}

	public static int removeDuplicates(int[] nums) {
		int k = 0;
		int count = 1;
		int value = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == value) {
				count++;
			} else {
				count = 1;
				value = nums[i];
			}
			if (count <= 2) {
				k++;
			}
			nums[k] = nums[i];
		}
		return k + 1;
	}

}
