package temp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3, n = 3;
		merge(nums1, m, nums2, n);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		IntStream s1 = Arrays.stream(nums1).limit(m);
		IntStream s2 = Arrays.stream(nums2).limit(n);
		nums1 = IntStream.concat(Arrays.stream(nums1).limit(m), Arrays.stream(nums2).limit(n)).sorted().toArray();
		Arrays.stream(nums1).forEach(s -> System.out.println(s));
	}
}
