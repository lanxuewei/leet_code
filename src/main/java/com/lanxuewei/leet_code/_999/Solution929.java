/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._999;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/22 15:49
 * Description: 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * 除了小写字母，这些电子邮件还可能包含 ',' 或 '+'。
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * 可以同时使用这两个规则。
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 *
 * 示例：
 *
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 */
@Slf4j
public class Solution929 {

    /**
     * 1、正常规则进行
     * @param emails emails
     * @return 匹配个数
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (int i = 0; i <= emails.length-1; i++) {
            String cleanedEmailStr = cleanEmail(emails[i]);
            if (cleanedEmailStr != null) {  // 不为空则加入
                emailSet.add(cleanedEmailStr);
            }
        }
        return emailSet.size();
    }

    /**
     * 将email转化为真实地址
     * @param emailStr 原email地址
     * @return email真实地址
     */
    private String cleanEmail(String emailStr) {
        if (emailStr == null || emailStr.length() <= 0) {
            return null;
        }
        String headStr = null;  // 本地名称
        String tailStr = null;  // 域名
        int lastIndexOfSplit = emailStr.lastIndexOf("@");
        tailStr = emailStr.substring(lastIndexOfSplit+1);   // 获取域名
        headStr = getRealLocalName(emailStr.substring(0, lastIndexOfSplit));  // 获取本地名称
        return headStr + tailStr;
    }

    /**
     * 获取真实本地名称
     * @param localName 本地名称
     * @return 经过过滤的本地名称
     */
    private String getRealLocalName(String localName) {
        if (localName == null || localName.length() <= 0) {
            return "";
        }
        localName = localName.replace(".", "");  // 替换掉所有.
        int i = localName.indexOf('+');
        if (i != -1) {
            localName = localName.substring(0, i);
        }
        return localName;
    }

    // test
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        Solution929 solution929 = new Solution929();
        log.info("numUniqueEmails = {}", solution929.numUniqueEmails(emails));
    }

}
