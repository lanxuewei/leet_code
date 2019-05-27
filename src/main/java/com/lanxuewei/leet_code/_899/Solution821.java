/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._899;

import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/4/3 20:01
 * Description: 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
@Slf4j
public class Solution821 {

    // 内存消耗大且复杂，考虑其他解法
    public int[] shortestToChar(String S, char C) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (C == S.charAt(i)) {
                list.add(i);
            }
        }
        for (Integer itemIndex : list) {
            // 左边
            for (int i = 0; i < itemIndex; i++) {
                if (arr[i] == 0) {
                    arr[i] = itemIndex-i;
                } else {
                    arr[i] = Math.min(arr[i], itemIndex-i);
                }
            }
            // 右边
            for (int i = itemIndex; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = i-itemIndex;
                } else {
                    arr[i] = Math.min(arr[i], i-itemIndex);
                }
            }
        }
        // 将自身都归为0
        for (Integer index : list) {
            arr[index] = 0;
        }
        return arr;
    }


    public int[] shortestToChar1(String S, char C) {
        return new int[1];
    }

    // test
    public static void main(String[] args) {
        String string = "loveleetcode";
        Solution821 solution821 = new Solution821();
        log.info("solution821.shortestToChar() = {}", solution821.shortestToChar(string, 'e'));
    }
}
