/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._799;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxuewei Create in 2019/1/30 10:56
 * Description: 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
@Slf4j
public class Solution728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (; left <= right; left++) {
            if (isNatureNum(left)) {
                res.add(left);
            }
        }
        return res;
    }

    private boolean isNatureNum(int num) {
        if (num < 10) { // 个数必定是自然数
            return true;
        }
        String numStr = String.valueOf(num);
        for (char c : numStr.toCharArray()) {
            if (c == '0' || num%Integer.parseInt(String.valueOf(c)) != 0) {
                return false;
            }
        }
        return true;
    }

    // test
    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        Solution728 solution728 = new Solution728();
        log.info("selfDividingNumbers = {}", solution728.selfDividingNumbers(left, right));

        solution728.isNatureNum(13);
    }
}
