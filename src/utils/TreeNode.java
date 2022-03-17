package utils;

/**
 * @moduleName: utils.TreeNode
 * @description: 二叉树节点
 * @author: 杨睿
 * @date: 2022-02-25 14:08
 **/
 public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;

     public TreeNode() {}

     public TreeNode(int val) {
         this.val = val;
     }

     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
