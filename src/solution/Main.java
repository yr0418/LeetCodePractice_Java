package solution;

import java.util.*;

/**
 * @moduleName: Main
 * @description: 牛客网
 * @author: 杨睿
 * @date: 2025/2/27 13:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String child = "";
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >='0' && ch <= '9') {
                temp.append(ch);
            } else {
                if (!temp.isEmpty()) {
                    if (ch == '+' || ch == '-' || ch == '*') {
                        char last = temp.charAt(temp.length() - 1);
                        // 最后一位为数字，加入
                        if (last >='0' && last <= '9') {
                            temp.append(ch);
                        }
                        // 最后一位不为数字，表达式终止
                        else {
                            if (temp.length()-1 > child.length()) {
                                child = temp.toString();
                            }
                            temp = new StringBuilder();
                        }
                    }
                    // 数学表达式终止
                    else {
                        if (temp.length() > child.length()) {
                            child = temp.toString();
                        }
                        temp = new StringBuilder();
                    }
                }
            }
        }
        if (temp.length() > child.length()) {
            child = temp.toString();
        }
        System.out.println(child);
    }
}
