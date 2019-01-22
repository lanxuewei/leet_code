/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._799;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author lanxuewei Create in 2019/1/22 15:13
 * Description: 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
@Slf4j
public class Solution771 {

    /**
     * 1、超级智障解法
     * @param J 宝石枚举
     * @param S 你所拥有石头
     * @return 宝石个数
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        if (J == null || "".equals(J.trim())
                || S == null || "".equals(S.trim())) {  // 只要J或者S为空或者空字符串就表示0
            return count;
        }
        char[] chars = J.toCharArray();
        List<Character> jewelList = new ArrayList<>();  // 宝石集合
        for (char c : chars) {
            jewelList.add(c);
        }
        char[] myStones = S.toCharArray();
        for (char c : myStones) {
            if (jewelList.contains(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 2、遍历石头字符串，判断当前元素是否存在与宝石J中
     * @param J 宝石枚举
     * @param S 你所拥有石头
     * @return 宝石个数
     */
    public int numJewelsInStones2(String J, String S) {
        int count = 0;
        if (J == null || "".equals(J.trim())
                || S == null || "".equals(S.trim())) {  // 只要J或者S为空或者空字符串就表示0
            return count;
        }
        for (int i=0; i <= S.length()-1; i++) {
            if (J.contains(String.valueOf(S.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    // test
    public static void main(String[] args) {
        String J = "edb";
        String S = "bbb";
        Solution771 solution771 = new Solution771();
        log.info("my jewel num = {}", solution771.numJewelsInStones2(J, S));
    }

}
