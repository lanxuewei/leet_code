/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code;

import java.util.List;

import org.junit.Test;

import com.lanxuewei.leet_code.model.ListNode;

import lombok.extern.slf4j.Slf4j;

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
     * description: 创建两条相交链表 测试
     * @author lanxuewei 2019/3/11 17:06
     */
    @Test
    public void testCreateIntersectList() {
        List<ListNode> listNodes = ListNode.createIntersectList(10);
        ListNode.printListNode(listNodes.get(0));
        System.out.println();
        ListNode.printListNode(listNodes.get(1));
    }

    @Test
    public void testIsIntersectList() {
        log.info("IsIntersectList = {}", ListNode.isIntersectList(ListNode.createIntersectList(10)));
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

    /**
     * description: 找出链表中环的入口 测试
     * @author lanxuewei 2019/3/11 14:59
     */
    @Test
    public void testFindRingEntrance() {
        ListNode listNode = ListNode.createRingByLength(10);    // 10/2=5，即5为环的入口
        log.info("The ring entrance in listNode is = {}", ListNode.findRingEntrance(listNode).val);
    }

    /**
     * description: 计算环的长度
     * @author lanxuewei 2019/3/11 15:49
     */
    @Test
    public void testCalculateRingLength() {
        ListNode listNode = ListNode.createRingByLength(10);
        log.info("The ring length = {}", ListNode.calculateRingLength(listNode));
    }

}
