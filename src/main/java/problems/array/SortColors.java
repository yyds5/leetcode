package main.java.problems.array;

import java.util.Arrays;

public class SortColors {

    // LeetCode 75 - Sort Colors
    // https://leetcode.com/problems/sort-colors/

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int lastNum = 0;
        lastNum = sortColor(nums, 0, lastNum);
        lastNum = sortColor(nums, 1, lastNum);
        lastNum = sortColor(nums, 2, lastNum);
    }

    public static int sortColor(int[] nums, int color, int lastNum) {
        int x = lastNum-1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == color) {
                x++;
                swap(nums, x, i);
            }
        }

        return x+1;
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
