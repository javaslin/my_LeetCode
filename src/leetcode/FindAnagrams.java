package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
438. 找到字符串中所有字母异位词
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        /**
         滑动窗口法, 定义两个指针lo和hi表示窗口的左端和右端,
         一个counter=p.length作为指示
         从右端开始右滑, 遇到一个p内的字符就将counter减1,
         如果counter变为0判断窗口是否满足要求
         一旦窗口大小等于p的长度, 需要删去左端点字符,
         删去时需要考虑是否要将counter加1
         **/
        List<Integer> ret = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (s.length() < p.length()) return ret;
        int[] map = new int[26];
        for (char ch : p.toCharArray())
            map[ch - 'a']++;

        int counter = p.length();  // 指示条件, 如果counter被减为0需要
        // 判断窗口内的字符是否满足要求
        int lo = 0, hi = 0;
        char[] ss = s.toCharArray();

        while (hi < m) {
            // 每次都要向右移动一次hi, 如果hi对应的字符出现
            // 次数大于等于1说明该字符在p中, 将counter减1
            if (map[ss[hi] - 'a']-- >= 1)
                counter--;
            hi++;
            // 如果counter减为0, 将左端点index加入返回值
            if (counter == 0)
                ret.add(lo);
            // 如果hi-lo == p.length说明窗口大小超出限制, 需要将
            // lo右移一位同时判断lo对应的字符是否在p中并决定是否对counter加1
            if (hi - lo == n) {
                // 只有当lo对应的字符个数大于等于0才说明lo对
                // 应的字符属于p, 否则其对应值应为负值
                if (map[ss[lo] - 'a']++ >= 0)
                    counter++;
                lo++;
            }
        }
        return ret;
    }
}
