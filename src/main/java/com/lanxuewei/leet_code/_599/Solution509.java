/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._599;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/30 16:53
 * Description: 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 */
@Slf4j
public class Solution509 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int res = 0;
        for (int i = 3; i <= N; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    // test
    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        log.info("fib [{}] = {}", 5, solution509.fib(5));
    }
}
