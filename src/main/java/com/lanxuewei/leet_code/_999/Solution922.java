/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._999;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/29 16:46
 * Description: 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
@Slf4j
public class Solution922 {

    /**
     * description: 记录偶数以及奇数下标，遍历存入
     * @param A 待排序数组
     * @return int[]
     * @author lanxuewei 2019/1/29 16:48
     */
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int[] res = new int[A.length];
        for (int k = 0; k <= A.length-1; k++) {
            if (A[k]%2 == 0) {
                res[i] = A[k];
                i += 2;
            } else {
                res[j] = A[k];
                j += 2;
            }
        }
        return res;
    }

    // test
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4};
        Solution922 solution922 = new Solution922();
        log.info("sortArrayByParityII = {}", solution922.sortArrayByParityII(arr));
    }
}
