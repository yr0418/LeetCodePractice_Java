package leetcode;

import utils.ListNode;
import utils.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class Solution {
    private static final Logger log = Logger.getLogger(Solution.class.getName());

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i <= j) {
            char left = s.charAt(i);
            if (!charIsNum(left) && !charIsLetter(left)) {
                i++;
                continue;
            }
            char right = s.charAt(j);
            if (!charIsNum(right) && !charIsLetter(right)) {
                j--;
                continue;
            }
            if (left == right || isSameLetter(left, right)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean charIsNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public boolean charIsLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public boolean isSameLetter(char left, char right) {
        int diffLeft = 0;
        int diffRight = 0;
        if (left <= 'Z') {
            diffLeft = left - 'A';
        } else {
            diffLeft = left - 'a';
        }
        if (right <= 'Z') {
            diffRight = right - 'A';
        } else {
            diffRight = right - 'a';
        }
        return diffLeft == diffRight;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"dog", "racecar", "car"};
        String str = "{[]}";
        int[] intArr = {7,20,5,3,6,4};
        Object result = solution.isPalindrome("A man, a plan, a canal: Panama");
        ListNode list = Utils.buildLinkList(intArr);
        log.info(String.valueOf(result));
    }
}