## 1. 字符串能否重排

给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

1. 示例 1

   输入: s1 = "abc", s2 = "bca"

   输出: true 

2. 示例 2

   输入: s1 = "abc", s2 = "bad"

   输出: false

说明：

- 0 <= len(s1) <= 100
- 0 <= len(s2) <= 100



### 解法

一般思路就是利用哈希表记录字符以及各个字符的数量，两个字符串能重排得到相同的字符，则两个字符串的字符以及字符数量均相等。遍历两个字符串，判断两个字符串能否重排。

另一种思路就是将两个字符串以字符数组的形式保存，再进行排序。同步遍历两个排序后的数组，若出现字符不一致的情况，则判定不能重排即可。

```java
public boolean CheckPermutation(String s1, String s2) {
    if(s1.length() != s2.length()) {
        return false;
    }
    char ch;
    HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
    for (int i = 0; i < s1.length(); i++) {
        ch = s1.charAt(i);
        // Java 的哈希表不能直接修改值，只能以 put 的形式来进行修改
        chars.put(ch, chars.getOrDefault(ch,0)+1);
    }
    for (int i = 0; i < s2.length(); i++) {
        ch = s2.charAt(i);
        chars.put(ch, chars.getOrDefault(ch,0)-1);
    }
    for(int x: chars.values()) {
        if (x != 0) {
            return false;
        }
    }
    return true;
}

```

---



## 2. 第一个只出现一次的字符

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

1. 示例 1

   输入：s = "abaccdeff"

   输出：'b'

2. 示例 2

   输入：s = "" 

   输出：' '



### 解法：类哈希思想

一般的解法便是建立一个哈希表，遍历字符串，利用键存储出现的字符，值存储字符出现的次数，然后在此遍历字符串，针对遍历到的字符，如果其在哈希表中对应的值为 1，则返回该字符。

但是，题中已经明确字符串只包含小写字符，因此，可以使用长度为 26 的整型数组代替哈希表。步骤如下。

1. 创建整型数组 count，遍历字符串，记录每个字符出现的次数。
2. 遍历字符串，针对遍历到的字符，查看 count 中其出现的次数，若为 1，返回该字符。

```java
public char firstUniqChar(String s) {
    int[] count = new int[26];
    char[] chars = s.toCharArray();
    for (char c : chars) {
        count[c - 'a']++;
    }
    for (char c : chars) {
        if (count[c-'a'] == 1) {
            return c;
        }
    }
    return ' ';
}

```

---



## 3. 两数之和

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。

1. 示例 1

   输入：nums = [2,7,11,15], target = 9

   输出：[0,1]

   解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

2. 示例 2

   输入：nums = [3,2,4], target = 6

   输出：[1,2]



### 解法：哈希表

利用哈希表保存已经遍历过的数字及其索引。

遍历数组，针对当前遍历的数字 $num$：

1. 如果 $target-num$ 存在于哈希表中，则返回对应的键值以及 num 的索引值。
2. 如果不存在，以 num 为键，索引值为值存入哈希表中。

```java
public int[] twoSum(int[] nums, int target) {;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target-nums[i])) {
            return new int[]{i, map.get(target-nums[i])};
        } else {
            map.put(nums[i], i);
        }
    }
    return new int[]{};
}

```

---



## 4. 数组的度

给定一个非空且只包含非负数的整数数组 `nums`，数组的 **度** 的定义是指数组里任一元素出现频数的最大值。

你的任务是在 `nums` 中找到与 `nums` 拥有相同大小的度的最短连续子数组，返回其长度。

**示例 1：**

```
输入：nums = [1,2,2,3,1]
输出：2
解释：
输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
连续子数组里面拥有相同度的有如下所示：
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
```

**示例 2：**

```
输入：nums = [1,2,2,3,1,4,2]
输出：6
解释：
数组的度是 3 ，因为元素 2 重复出现 3 次。
所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
```

**提示：**

- `nums.length` 在 `1` 到 `50,000` 范围内。
- `nums[i]` 是一个在 `0` 到 `49,999` 范围内的整数。



### 解法：哈希表

记原数组中出现次数最多的数为 $x$，那么和原数组的度相同的最短连续子数组，必然包含了原数组中的全部 $x$，且两端恰为 $x$ 第一次出现和最后一次出现的位置。

因为符合条件的 $x$ 可能有多个，即多个不同的数在原数组中出现次数相同。所以为了找到这个子数组，我们需要统计每一个数出现的次数，同时还需要统计每一个数第一次出现和最后一次出现的位置。

在实际代码中，我们使用哈希表实现该功能，每一个数映射到一个长度为 `3` 的数组，数组中的三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置、这个数在原数组中最后一次出现的位置。当我们记录完所有信息后，我们需要遍历该哈希表，找到元素出现次数最多，且前后位置差最小的数。

```java
public int findShortestSubArray(int[] nums) {
    Map<Integer, int[]> map = new HashMap<Integer, int[]>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        if (map.containsKey(nums[i])) {
            map.get(nums[i])[0]++;
            map.get(nums[i])[2] = i;
        } else {
            map.put(nums[i], new int[]{1, i, i});
        }
    }
    int maxNum = 0, minLen = 0;
    for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
        int[] arr = entry.getValue();
        if (maxNum < arr[0]) {
            maxNum = arr[0];
            minLen = arr[2] - arr[1] + 1;
        } else if (maxNum == arr[0]) {
            if (minLen > arr[2] - arr[1] + 1) {
                minLen = arr[2] - arr[1] + 1;
            }
        }
    }
    return minLen;
}
```



