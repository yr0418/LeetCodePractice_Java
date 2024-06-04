package leetcode;

import utils.ListNode;
import utils.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0) {
                sb.append('Z');
                columnNumber = columnNumber / 26 - 1;
            } else {
                sb.append((char)('A' + mod - 1));
                columnNumber = columnNumber / 26;
            }
        }
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"dog", "racecar", "car"};
        String str = "{[]}";
        int[] intArr = {7,20,5,3,6,4};
        Object result = null;
        ListNode list = Utils.buildLinkList(intArr);
        log.info(String.valueOf(result));
    }
}