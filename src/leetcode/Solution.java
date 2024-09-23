package leetcode;

import utils.ListNode;
import utils.Utils;

import java.util.logging.Logger;

class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());

    public boolean validPalindrome(String s) {
        boolean delete = false;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (s.charAt(i) == s.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                if (delete) {
                    return false;
                } else {
                    // 条件 1
                    if (s.charAt(j - 1) == s.charAt(i)) {
                        j -= 2;
                        i += 1;
                        delete = true;
                    }
                    // 条件 2
                    else if (s.charAt(i + 1) == s.charAt(j)) {
                        i += 2;
                        j -= 1;
                        delete = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
        String str = "{[]}";
        int[] intArr = {-1};
        ListNode list = Utils.buildLinkList(intArr);

        Object result = solution.validPalindrome("ebcbbececabbacecbbcbe");
        log.info(String.valueOf(result));
    }
}