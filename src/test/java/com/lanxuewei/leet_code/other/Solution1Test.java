/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code.other;

import com.lanxuewei.leet_code.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lanxuewei Create in 2019/3/11 20:42
 * Description: 
 */
@Slf4j
public class Solution1Test extends TestBase {

    /**
     * description: 查找丢失数函数 测试
     * @author lanxuewei 2019/3/11 20:43
     */
    @Test
    public void testFindLoseNum() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            if (i != 55) {  // 丢失56
                arr[i] = i+1;
            }
        }
        log.info("The lose num = {}", Solution1.findLoseNum(arr));
    }

    /**
     * description: 查找出现奇数次的数 测试
     * @author lanxuewei 2019/3/12 10:18
     */
    @Test
    public void testFindSingleNum() {
        int[] arr = {1, 1, 3, 6, 6, 3, 9};  // 9出现奇数次
        log.info("The single num = {}", Solution1.findSingleNum(arr));
    }

}
