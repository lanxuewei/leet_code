/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code.model;

/**
 * @author lanxuewei Create in 2019/1/29 19:39
 * Description: 链表相关
 */
public class ListNode {

    /** 节点值 */
    public int val;

    /** 下一节点指针 */
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * description: 产生一条数据从0开始到length-1的链表
     * @param length 链表长度
     * @return com.lanxuewei.leet_code.model.ListNode
     * @author lanxuewei 2019/3/11 11:04
     */
    public static ListNode createListByLength(int length) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i < length; i++) {
            ListNode listNode = new ListNode(i);
            temp.next = listNode;
            temp = listNode;
        }
        return head;
    }

    /**
     * description: 产生一条数据从0开始到length-1的链表，带环
     * @param length 链表长度
     * @return com.lanxuewei.leet_code.model.ListNode
     * @author lanxuewei 2019/3/11 11:30
     */
    public static ListNode createRingByLength(int length) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode ringEntranceNode = null;   // 环入口节点
        int ringEntranceIndex = length/2;
        for (int i = 1; i < length-1; i++) {
            ListNode listNode = new ListNode(i);
            if (ringEntranceIndex == i) {
                ringEntranceNode = listNode;
            }
            temp.next = listNode;
            temp = listNode;
        }
        temp.next = ringEntranceNode;   // 将最后节点指向环入口节点，形成环
        return head;
    }

    /**
     * description: 判断链表是否包含环
     * @param head 头结点
     * @return com.lanxuewei.leet_code.model.ListNode
     * @author lanxuewei 2019/3/11 14:12
     */
    public static boolean isContainRing(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowListNode = head;
        ListNode fastListNode = head.next;
        while (slowListNode != null && fastListNode != null) {
            if (slowListNode.equals(fastListNode)) {
                return true;
            }
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next.next;
        }
        return false;
    }

    /**
     * description: 打印链表
     * @param head 头结点
     * @author lanxuewei 2019/3/11 11:15
     */
    public static void printListNode(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // test
    public static void main(String[] args) {
        ListNode listNode = createListByLength(5);
        printListNode(listNode);
    }



}
