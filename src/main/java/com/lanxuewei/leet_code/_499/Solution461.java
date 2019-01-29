/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._499;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/29 17:28
 * Description: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
@Slf4j
public class Solution461 {

    public int hammingDistance(int x, int y) {
        String xString = standBinaryString(Integer.toBinaryString(x));
        String yString = standBinaryString(Integer.toBinaryString(y));
        int count = 0;
        for (int i = 0; i <= xString.length()-1; i++) {
            if (xString.charAt(i) != yString.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private String standBinaryString(String s) {
        int length = s.length();
        StringBuilder zeroSb = new StringBuilder();
        if (length < 31) {
            int addZeroLength = 31-length;
            for (int i = 0; i <= addZeroLength-1; i++) {
                zeroSb.append(0);
            }
        }
        return zeroSb+s;
    }

    // test
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        Solution461 solution461 = new Solution461();
        log.info("hammingDistance = {}", solution461.hammingDistance(x, y));
    }
}
