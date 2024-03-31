package leetcode;

import java.util.Scanner;

/**
 * @author 杨睿
 * @moduleName Main
 * @description 算法测试类
 * @date 2023/5/4 22:06
 **/
public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String ch = in.nextLine().toLowerCase();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                String c = String.valueOf(str.charAt(i)).toLowerCase();
                if (ch.equals(c)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
