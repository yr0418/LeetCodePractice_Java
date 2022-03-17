package leetcode;

import utils.TreeNode;

class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



    public static void main(String[] args) {
        Solution result = new Solution();
        int[] nums = {9,9,9,9,9};
        String s = " fly me  to the moon ";
        System.out.println();

    }
}