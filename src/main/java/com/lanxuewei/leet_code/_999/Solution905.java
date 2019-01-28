/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._999;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/22 19:26
 * Description: 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
@Slf4j
public class Solution905 {

    /**
     * 1、遍历数组，将偶数从头开始存入另一个数组，从尾开始存奇数
     * @param A 待分割数组
     * @return 分割成功后数组
     */
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int tail = A.length-1;
        int head = 0;
        for (int i = 0; i <= A.length-1; i++) {
            if (A[i]%2 == 0) {  // 偶数从头开始存
                res[head++] = A[i];
            } else {            // 奇数从尾巴开始存
                res[tail--] = A[i];
            }
        }
        return res;
    }

    // test
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Solution905 solution905 = new Solution905();
        log.info("sortArrayByParity = {}", solution905.sortArrayByParity(arr));
    }

}
