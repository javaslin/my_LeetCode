package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
763. 划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

示例 1:

输入: S = "ababcbacadefegdehijhklij"
输出: [9,7,8]
解释:
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
注意:

S的长度在[1, 500]之间。
S只包含小写字母'a'到'z'。
在真实的面试中遇到过这道题？

 */
public class PartitionLabels {
    public List<Integer> partitionLabel(String s) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[char2Index(s.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < s.length() && i <= lastIndex; i++) {
                int index = lastIndexOfChar[char2Index(s.charAt(i))];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private int char2Index(char c) {
        return c - 'a';
    }
}