package leetcode;

import utils.Node;
import utils.TreeNode;

import java.util.*;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = " ";
        int[] nums = {5,4,3,2,1};
        String[] words = new String[]{"Hello","Alaska","Dad","Peace"};
        System.out.println();
    }
}