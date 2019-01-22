/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._999;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanxuewei Create in 2019/1/22 19:55
 * Description: 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 */
@Slf4j
public class Solution961 {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>(A.length);
        for (int temp : A) {
            if (set.contains(temp)) {
                return temp;
            } else {
                set.add(temp);
            }
        }
        return 0;
    }

    // test
    public static void main(String[] args) {
        int[] A = {1,2,3,3};
        Solution961 solution961 = new Solution961();
        log.info("repeatedNTimes = {}", solution961.repeatedNTimes(A));
    }
}
