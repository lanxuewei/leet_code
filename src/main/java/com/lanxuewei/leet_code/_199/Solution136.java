/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._199;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/4/9 20:11
 * Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
@Slf4j
public class Solution136 {

    /**
     * description: 线性复杂度查找只出现一次的数字。
     * 解法：将所有数字进行异或运算^，相同数异或运算后得到结果为0
     * @param nums 待查询数组
     * @return int 只出现一次的数字
     * @author lanxuewei 2019/4/9 20:13
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    // test
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        Solution136 solution136 = new Solution136();
        log.info("solution136.singleNumber = {}", solution136.singleNumber(arr));
    }
}
