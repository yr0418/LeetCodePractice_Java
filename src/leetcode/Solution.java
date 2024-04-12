package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        int difference;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            difference = target - num;
            if (numIndex.containsKey(difference)) {
                result[0] = i;
                result[1] = numIndex.get(difference);
                break;
            } else {
                numIndex.put(num, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
    }
}