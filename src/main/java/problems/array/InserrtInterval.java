package main.java.problems.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class InserrtInterval {
    // LeetCode 57 - Insert Interval
    // https://leetcode.com/problems/insert-interval/

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = insert(intervals, newInterval);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Deque<Integer[]> stack = new LinkedList<>();
        stack.push(new Integer[]{newInterval[0], newInterval[1]});

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            Integer[] prevInterval = stack.peek();

            if (end < prevInterval[0]) { // in front
                Integer[] tempInterval = stack.pop();
                stack.push(new Integer[]{start, end});
                stack.push(tempInterval);
            } else if (start > prevInterval[1]) { // in end
                stack.push(new Integer[]{start, end});
            } else { // overlapping
                Integer[] tempInterval = stack.pop();

                int minStart = Math.min(start, tempInterval[0]);
                int maxEnd = Math.max(end, tempInterval[1]);
                stack.push(new Integer[]{minStart, maxEnd});
            }

        }

        int[][] res = new int[stack.size()][];

        for (int i = res.length - 1; i >= 0; i--) {
            Integer[] t = stack.pop();
            res[i] = new int[]{t[0], t[1]};
        }

        return res;
    }

}
