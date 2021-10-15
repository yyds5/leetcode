package main.java.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // LeetCode #56 - Merge Intervals
    // https://leetcode.com/problems/merge-intervals/

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[][] merge(int[][] intervals) {

        // sort the interval array based on the first value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        for(int[] interval: intervals){
            if(result.isEmpty() || !checkIfInterval(result.get(result.size()-1), interval)){
                // no overlapping add to result list
                result.add(interval);
            }else{
                // check against the previous in result list
                int[] temp = result.get(result.size()-1);
                int[] current = new int[]{Math.min(temp[0], interval[0]), Math.max(temp[1], interval[1])};
                result.set(result.size()-1, current);
            }
        }
        return result.toArray(new int[0][]);
    }

    private static boolean checkIfInterval(int[] result, int[] interval) {
        // check for overlapping
        return interval[1] - result[0] >= 0 && result[1] - interval[0] >= 0;
    }
}
