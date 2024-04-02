package leetcode;

import utils.TreeNode;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.logging.Logger;

class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());

    private static Deque<Character> stack = new LinkedList<>();

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (numCountMap.containsKey(current)) {
                int count = numCountMap.get(current) + 1;
                numCountMap.put(current, count);
                numIndexMap.get(current).add(1, i);
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                numCountMap.put(current, 1);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                numIndexMap.put(current, list);
                if (maxCount < 1) {
                    maxCount = 1;
                }
            }
        }

        int minLen = nums.length;
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                List<Integer> list = numIndexMap.get(entry.getKey());
                int len = list.size() <= 1 ? 1 : list.get(1) - list.get(0) + 1;
                minLen = Math.min(minLen, len);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        int len = solution.findShortestSubArray(nums);
        log.info(String.valueOf(len));
    }
}