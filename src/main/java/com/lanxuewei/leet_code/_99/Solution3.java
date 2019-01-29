/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._99;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lanxuewei Create in 2019/1/28 17:25
 * Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
@Slf4j
public class Solution3 {

    /**
     * description: 将每次子串长度都记录下来，获得最大子串
     * @param s 原字符串
     * @return int
     * @author lanxuewei 2019/1/29 15:51
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> subStrSet = new HashSet<>(); // 子串集合
        TreeSet<Integer> subStrLengthSet = new TreeSet<>();// 子串长度集合
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i <= s.length()-1; i++) {
            Character c = s.charAt(i);
            if (!subStrSet.contains(c)) {   // 不包含则继续加入
                subStrSet.add(c);
            } else {            // 如果包含则清空
                i = ++index;    // 重新开始某个点遍历
                i--;            // 抵消i++操作产生的误差
                subStrLengthSet.add(subStrSet.size()); // 记录当前子串长度
                subStrSet.clear();
            }
        }
        subStrLengthSet.add(subStrSet.size());
        return subStrLengthSet.size() > 0 ? subStrLengthSet.last() : 0;
    }

    // test
    public static void main(String[] args) {
        String str = "aab";
        Solution3 solution1 = new Solution3();
        log.info("lengthOfLongestSubstring = {}", solution1.lengthOfLongestSubstring(str));
    }
}
