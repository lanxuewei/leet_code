/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._499;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/29 20:52
 * Description: 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 注意:
 *
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 *
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 */
@Slf4j
public class Solution476 {

    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (char c : binaryString.toCharArray()) {
            if (c == '0') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    /**
     * description: ~num: 取反；Integer.highestOneBit(num)-1: num的二进制的最高位为1的那一位，其余所有位置为0，
     *
     * @param num
     * @return int
     * @author lanxuewei 2019/1/29 21:02
     */
    public int findComplement1(int num) {
        return ~num&(Integer.highestOneBit(num)-1);
    }

    // test
    public static void main(String[] args) {
        int num = 5;
        Solution476 solution476 = new Solution476();
        log.info("findComplement = {}", solution476.findComplement(num));
    }
}
