/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code.other;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/3/11 20:26
 * Description: 在数组中查找数相关问题
 */
@Slf4j
public class Solution1 {

    /**
     * description: 一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
     * @param arr 无序数组
     * @return int 缺失的那个数
     * @author lanxuewei 2019/3/11 20:32
     */
    public static int findLoseNum(int[] arr) {
        int sum = 0;
        for (int temp : arr) {
            sum += temp;
        }
        return (1+100)*50 - sum;
    }

    /**
     * description: 题目扩展：一个无序数组里有若干个正整数，范围从1到100，其中99个整数都出现了偶数次，
     * 只有一个整数出现了奇数次（比如1,1,2,2,3,3,4,5,5），如何找到这个出现奇数次的整数？
     *
     * 解法：遍历整个数组，依次做异或运算。由于异或在位运算时相同为0，不同为1，因此所有出现偶数次的整数都会相互抵消变成0，只有唯一出现奇数次的整数会被留下。
     * 假设数组长度是N，那么该解法的时间复杂度是O（N），空间复杂度是O（1）。
     *
     * @param arr 无序数组
     * @return int 只出现奇数次的数
     * @author lanxuewei 2019/3/12 10:00
     */
    public static int findSingleNum(int[] arr) {
        int res = 0;
        for (int temp : arr) {
            res = res^temp;
        }
        return res;
    }

    // test
    public static void main(String[] args) {

    }
}
