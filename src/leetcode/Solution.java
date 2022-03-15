package leetcode;

class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length-1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution result = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(result.removeElement(nums, 1));
    }
}