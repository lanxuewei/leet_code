/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._999;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/3/7 16:43
 * Description: 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
@Slf4j
public class Solution977 {

    /**
     * description: 通过i、j定位第一位以及最后一位，通过对比大小朝中间逼近
     * @param A 原数组
     * @return int[]
     * @author lanxuewei 2019/3/7 16:44
     */
    public int[] sortedSquares(int[] A) {
        int i = 0;
        int j = A.length-1;
        int[] res = new int[A.length];
        int k = A.length-1;
        while (i <= j) {
            if (Math.abs(A[i]) >= Math.abs(A[j])) { // i下标绝对值比较大
                res[k--] = A[i]*A[i];
                i++;
            } else {    // j下标的绝对值比较大
                res[k--] = A[j]*A[j];
                j--;
            }
        }
        return res;
    }

    // test
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        log.info("res = {}", new Solution977().sortedSquares(arr));
    }

}
