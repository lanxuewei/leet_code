/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._899;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/22 20:48
 * Description: 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 */
@Slf4j
public class Solution832 {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length-1; i++) {
            for (int j = 0; j < (A[i].length)/2; i++) {   // 只需要遍历[0,length/2]
            }
        }
        return new int[1][1];
    }

    // test
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        log.info("arr[0][1] = {}", arr[0][1]);
    }
}
