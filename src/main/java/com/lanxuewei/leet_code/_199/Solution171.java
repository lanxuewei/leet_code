/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._199;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/5/27 19:19
 * Description: 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 */
@Slf4j
public class Solution171 {

    public int titleToNumber(String s) {
        if (null == s || s.trim().equals("")) {
            return 0;
        }
        int sum = 0;
        for (int i = s.length()-1, j = 0; i >= 0; i--, j++) {
            int num = s.charAt(i) - 64;
            sum += num * Math.pow(26, j);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution171 solution = new Solution171();
        log.info("solution.titleToNumber(ZY) = {}", solution.titleToNumber("AA"));
    }
}
