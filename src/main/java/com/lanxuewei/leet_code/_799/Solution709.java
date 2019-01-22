/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._799;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/22 16:27
 * Description: 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 *
 * 示例 2：
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
@Slf4j
public class Solution709 {

    /**
     * 1、将字符串中所有单词转化为小写字母（通过ASCII转化）
     * @param str 待转化字符串
     * @return 转化后字符串
     */
    public String toLowerCase(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i <= str.length()-1; i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {   // 如果是大写字母则转化为小写字母
                c += 32;
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    // test
    public static void main(String[] args) {
        String str = "Hello";
        Solution709 solution709 = new Solution709();
        log.info("toLowerCase = {}", solution709.toLowerCase(str));
    }
}
