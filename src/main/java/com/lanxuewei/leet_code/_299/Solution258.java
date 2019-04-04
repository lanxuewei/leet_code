/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._299;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/4/4 15:08
 * Description: 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * 除了传统的单纯循环，还可以找规律。
 * 假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，经过一次各位相加后，变为s2 = a + b + c，减小的差值为(s1 -s2) = 99 * a + 9 * b
 * 差值可以被9整除，每一个循环都这样，缩小了9的倍数。
 * 当num小于9，即只有一位时，直接返回num，大于9时，如果能被9整除，则返回9（因为不可能返回0也不可能返回两位数及以上的值），如果不能被整除，就返回被9除的余数。
 */
@Slf4j
public class Solution258 {

    public int addDigits(int num) {
        if (num > 9) {
            num = num % 9;
            if (num == 0) {
                return 9;
            }
            return num;
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 38;
        Solution258 solution258 = new Solution258();
        log.info("Solution258.addDigits(num) = {}", solution258.addDigits(num));
    }
}
