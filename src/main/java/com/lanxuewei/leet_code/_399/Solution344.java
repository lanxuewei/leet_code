/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._399;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/30 11:36
 * Description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
@Slf4j
public class Solution344 {

    public void reverseString(char[] s) {
        if (s.length < 1) {
            return;
        }
        for (int i = 0, j = s.length-1; i < s.length/2; i++, j--) {
            char item = s[i];
            s[i] = s[j];
            s[j] = item;
        }
    }

    // test
    public static void main(String[] args) {
        char[] s = {'1', '2', '3', '4', '5', '6'};
        Solution344 solution344 = new Solution344();
        solution344.reverseString(s);
        log.info("reverseString = {}", s);
    }
}
