package leetcode;

import utils.TreeNode;

import java.util.logging.Logger;

class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getCountNodes(root);
    }

    public int getCountNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1+ getCountNodes(node.left) + getCountNodes(node.right);
    }




    public static void main(String[] args) {

    }
}