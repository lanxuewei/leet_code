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

    // ----------------------- 关于环 -----------------------
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
        for (int i = 1; i < length; i++) {
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
     * description: 计算链表中环的长度
     * @param head 头节点
     * @return int 环长度
     * @author lanxuewei 2019/3/11 15:37
     */
    public static int calculateRingLength(ListNode head) {
        int length = 0;
        if (head == null || head.next == null) {
            return length;
        }
        ListNode slowListNode = head;
        ListNode fastListNode = head.next;
        boolean isContainRing = false;
        while (slowListNode != null && fastListNode != null) {
            if (slowListNode.equals(fastListNode)) {
                isContainRing = true;
                break;
            }
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next.next;
        }
        if (isContainRing) {
            ListNode temp = slowListNode.next;
            length++;
            while (!temp.equals(slowListNode)) {
                length++;
                temp = temp.next;
            }
        }
        return length;
    }

    /**
     * description: 在一个有环的链表中，找到环的入口
     *
     * 走一步的指针叫slow，走两步的叫fast。
     * 相遇的时候，slow共移动了s步，fast共移动了2s步，这个是显而易见的。
     * 定义a如下： 链表头移动a步到达入口点。
     * 定义x如下： 入口点移动x步到达相遇点。
     * 定义r如下： 从环中的某一点移动r步，又到达的这一点，也就是转了一圈的意思。
     * 定义t如下：　从相遇点移动到入口点的移动步数
     * 定义L如下： 从链表头移动L步，又到达了相遇点。也就是遍历完链表之后，通过最后一个节点的指针，又移动到了链表中的某一点。
     * 其中Ｌ　＝　a + r  =  a + x + t
     * 那么slow和fast相遇了，fast必然比slow多走了n个圈，也就是 n*r 步，那么
     * s = a + x
     * 2s = s + n*r ， 可得  s = n*r
     * 将s=a+x，带入s =n*r，可得 a+x = n*r, 也就是 a+x = (n-1)*r + r 　　
     * 从表头移动到入口点，再从入口点移动到入口点，也就是移动了整个链表的距离，即是 L =  a + r , 所以r = L - a
     * 所以   a+x = (n-1)*r + L - a ,   于是 a  = (n-1)*r + L - a - x = (n-1)*r + t
     * 也就是说，从表头到入口点的距离，等于从相遇点继续遍历又到表头的距离。
     *
     * 所以，从表头设立一个指针，从相遇点设立一个指针，两个同时移动，必然能够在入口点相遇，这样，就求出了相遇点。
     * @param head 头结点
     * @return com.lanxuewei.leet_code.model.ListNode
     * @author lanxuewei 2019/3/11 14:51
     */
    public static ListNode findRingEntrance(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowListNode = head;
        ListNode fastListNode = head.next;
        boolean isContainRing = false;
        while (slowListNode != null && fastListNode != null) {
            if (slowListNode.equals(fastListNode)) {
                isContainRing = true;
                break;
            }
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next.next;
        }
        if (isContainRing) {
            slowListNode = head;
            fastListNode = fastListNode.next;
            while (!slowListNode.equals(fastListNode)) {
                slowListNode = slowListNode.next;
                fastListNode = fastListNode.next;
            }
            return slowListNode;
        }
        return null;
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
