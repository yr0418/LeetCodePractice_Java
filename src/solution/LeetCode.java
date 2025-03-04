package solution;

import utils.ListNode;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class LeetCode {
    private static final Logger log = Logger.getLogger(LeetCode.class.getName());

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = Character.toLowerCase(licensePlate.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            }
        }
        int minLen = Integer.MAX_VALUE;
        String result = "";
        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char ch = Character.toLowerCase(word.charAt(i));
                if (ch >= 'a' && ch <= 'z') {
                    tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
                }
            }
            boolean replace = true;
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                if (!tempMap.containsKey(entry.getKey()) || tempMap.get(entry.getKey()) < entry.getValue()) {
                    replace = false;
                }
            }
            if (replace && word.length() < minLen) {
                result = word;
                minLen = word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
        String str = "{[]}";
        int[] intArr = {0, 1, 1, 2};
        ListNode list = Utils.buildLinkList(intArr);
        Object result = null;
        log.info(String.valueOf(result));
    }
}