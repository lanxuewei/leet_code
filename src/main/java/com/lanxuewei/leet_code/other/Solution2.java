/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code.other;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/3/12 11:40
 * Description: 位运算相关问题
 */
@Slf4j
public class Solution2 {

    /**
     * description: 题目：实现一个方法，判断一个正整数是否是2的乘方（比如16是2的4次方，返回True；18不是2的乘方，返回False）。要求性能尽可能高。
     *
     * 解决思路：其实2的乘方都有一个共同点
     * 十进制           二进制           是否2的乘方
     * 8              1000B            是
     * 16             10000B           是
     * 32             100000B          是
     * 64             1000000B         是
     * 100            1100100B         否
     *
     * 将这些数都减去1，则二进制都是1、11、111...等，所以N&N-1=0
     *
     * @param num 待判断数
     * @return boolean
     * @author lanxuewei 2019/3/12 11:42
     */
    public static boolean isTwoPower(int num) {
        return (num & num-1) == 0;
    }

    /**
     * description: 实现一个方法，求出一个正整数转换成二进制后的数字“1”的个数。要求性能尽可能高。
     * 解决思路： N & N-1 可以清除最右边的1
     * @param num 待处理数
     * @return int 二进制中1个数
     * @author lanxuewei 2019/3/12 14:09
     */
    public static int findOneInBinary(int num) {
        int count = 0;
        num = Math.abs(num);
        while (num != 0) {
            count++;
            num = num & num-1;
        }
        return count;
    }
}
