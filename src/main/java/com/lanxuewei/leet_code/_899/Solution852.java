/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._899;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/29 20:11
 * Description: 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 */
@Slf4j
public class Solution852 {

    public int peakIndexInMountainArray(int[] A) {
        int preIntIdx = 0;
        for (int i = 1; i <= A.length-1; i++) {
            if (A[preIntIdx] >= A[i]) { // 如果开始变小
                return preIntIdx;
            }
            preIntIdx = i;
        }
        return 0;
    }

    // test
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0};
        Solution852 solution852 = new Solution852();
        log.info("peakIndexInMountainArray = {}", solution852.peakIndexInMountainArray(arr));
    }
}
