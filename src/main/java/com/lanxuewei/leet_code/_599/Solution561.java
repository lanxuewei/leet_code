/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._599;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author lanxuewei Create in 2019/3/16 16:50
 * Description: 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
@Slf4j
public class Solution561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i+2) {
            sum += nums[i];
        }
        return sum;
    }

    // test
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        Solution561 solution561 = new Solution561();
        log.info("arrayPairSum = {}", solution561.arrayPairSum(arr));
    }
}
