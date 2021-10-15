package main.java.problems.array;

public class MinPathSum {
    // LeetCode 64 - Minimum Path Sum
    // https://leetcode.com/problems/minimum-path-sum/

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minPath = minPathSumFinder(grid);
        System.out.println(minPath);
    }

    public static int minPathSumFinder(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col > 0) {
                    grid[row][col] += grid[row][col-1];
                } else if (col == 0 && row > 0) {
                    grid[row][col] += grid[row-1][col];
                } else if (row > 0 && col > 0) {
                    grid[row][col] += Math.min(grid[row-1][col], grid[row][col-1]);
                }
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}
