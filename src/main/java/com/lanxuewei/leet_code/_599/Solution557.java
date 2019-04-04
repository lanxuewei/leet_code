/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._599;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/3/16 17:32
 * Description: 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
@Slf4j
public class Solution557 {

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        String[] sList = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= sList.length-1; i++) {
            res.append(reverseWord(sList[i]));
            if (i != sList.length-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    /**
     * description: 翻转单词
     * @param word 单词
     * @return java.lang.String
     * @author lanxuewei 2019/3/16 17:34
     */
    public String reverseWord(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = word.length()-1; i >= 0; i--) {
            stringBuilder.append(word.charAt(i));
        }
        return stringBuilder.toString();
    }

    // test
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Solution557 solution557 = new Solution557();
        log.info("s = {}", solution557.reverseWords(s));
    }

}
