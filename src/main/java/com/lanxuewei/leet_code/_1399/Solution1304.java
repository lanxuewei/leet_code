package com.lanxuewei.leet_code._1399;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @author lanxuewei create in 2020/3/6 16:18
 * description: 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。

 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 *
 * 提示：
 * 1 <= n <= 1000
 */
@Slf4j
public class Solution1304 {

    public static void main(String[] args) {
        int[] nums = new Solution1304().sumZero(5);
        // 结果校验
        int sum = 0;
        for (int i = 0; i <= nums.length-1; i++) {
            sum += nums[i];
        }
        assert sum == 0;

        log.info("sumZero arr = {}, sum = {}", nums, sum);
    }

    public int[] sumZero(int n) {
        int left = 0;
        int right = n-1;
        int i = 1;
        int[] nums = new int[n];
        while (left < right) {
            nums[left++] = i;
            nums[right--] = -i;
            i++;
        }
        if (left == right) {
            nums[left] = 0;
        }
        return nums;
    }
}
