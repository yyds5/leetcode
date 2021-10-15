package main.java.problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date 2021-10-15
 * @apiNote
 */
public class two_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    //Explanation:
    // this problem iterates through array
    //Time: O(N) && Space: O(N)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenMap = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int valToFind = target - nums[i];
            if(seenMap.containsKey(valToFind)){
                return new int[]{i, seenMap.get(valToFind)};
            }

            seenMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
