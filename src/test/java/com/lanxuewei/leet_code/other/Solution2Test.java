/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code.other;

import com.lanxuewei.leet_code.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lanxuewei Create in 2019/3/12 13:44
 * Description: 
 */
@Slf4j
public class Solution2Test extends TestBase {

    /**
     * description: 判断数是否为2的乘方函数 测试
     * @author lanxuewei 2019/3/12 13:44
     */
    @Test
    public void testIsTwoPower() {
        log.info("{} = {}", 64, Solution2.isTwoPower(64));
        log.info("{} = {}", 100, Solution2.isTwoPower(100));
    }

    /**
     * description: 求某个数二进制中1的个数函数 测试
     * @author lanxuewei 2019/3/12 14:11
     */
    @Test
    public void testFindOneInBinary() {
        log.info("{} - findOneInBinary = {}", 3, Solution2.findOneInBinary(3));
        log.info("{} - findOneInBinary = {}", 5, Solution2.findOneInBinary(5));
    }

    @Test
    public void test() {
        log.info("3 >> {}", 3>>1);
    }
}
