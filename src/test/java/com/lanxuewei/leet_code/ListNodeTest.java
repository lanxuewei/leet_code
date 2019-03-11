/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code;

import com.lanxuewei.leet_code.model.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lanxuewei Create in 2019/3/11 13:53
 * Description: 
 */
@Slf4j
public class ListNodeTest extends TestBase {

    /**
     * description: 创建链表带环函数 测试
     * @author lanxuewei 2019/3/11 13:54
     */
    @Test
    public void testCreateRingByLength() {
        ListNode listNode = ListNode.createRingByLength(5);
        for (int i = 0; i < 10; i++) {
            log.info("{} ", listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * description: 判断链表是否存在环 测试
     * @author lanxuewei 2019/3/11 14:24
     */
    @Test
    public void testIsContainRing() {
        ListNode listNode1 = ListNode.createRingByLength(5);
        log.info("This listNode1 contain ring, isContainRing = {}", ListNode.isContainRing(listNode1));
        ListNode listNode2 = ListNode.createListByLength(5);
        log.info("This ListNode2 does not contain ring, isContainRing = {}", ListNode.isContainRing(listNode2));
    }
}
