import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @moduleName: Solution
 * @description: 算法
 * @author: 杨睿
 * @date: 2022-01-17 15:57
 **/

class Solution {
    public int exchangeBits(int num) {
        // 奇数位
        int odd = num & 0x55555555;
        // 偶数位
        int even = num & 0xaaaaaaaa;

        odd <<= 1;
        even >>= 1;

        return odd | even;
    }
}
