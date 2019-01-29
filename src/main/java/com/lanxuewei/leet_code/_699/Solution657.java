/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._699;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei Create in 2019/1/29 16:12
 * Description: 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 *
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 *
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 *
 * 示例 1:
 *
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 */
@Slf4j
public class Solution657 {

    /**
     * description: 遍历字符串查看移动之后水平以及垂直是否在原点位置
     * @param moves 原字符串
     * @return boolean
     * @author lanxuewei 2019/1/29 16:21
     */
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.trim().length() == 0) {
            return true;
        }
        int levelIndex = 0;     // 水平
        int verticalIndx = 0;   // 垂直
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                verticalIndx++;
            }
            if (c == 'D') {
                verticalIndx--;
            }
            if (c == 'R') {
                levelIndex++;
            }
            if (c == 'L') {
                levelIndex--;
            }
        }
        return levelIndex == 0 && verticalIndx == 0;
    }

    /**
     * description: 替换掉字符串来统计个数
     * @param moves 原字符串
     * @return boolean
     * @author lanxuewei 2019/1/29 16:39
     */
    public boolean judgeCircle1(String moves) {
        if (moves == null || moves.trim().length() == 0) {
            return true;
        }
        int totalLength = moves.length();    // 原字符串总长度
        moves = moves.replaceAll("U", "");      // 去掉U以后剩余子串
        int uLength = totalLength - moves.length();              // 计算U个数

        totalLength = moves.length();
        moves = moves.replaceAll("D", "");      // 去掉U和D以后子串
        int dLength = totalLength - moves.length();              // 计算D个数
        if (uLength != dLength) {
            return false;
        }

        totalLength = moves.length();
        moves = moves.replaceAll("R", "");
        int rLength = totalLength - moves.length();
        return rLength == moves.length();
    }

    /**
     * description: 替换字符串统计个数-优化
     * @param moves 原字符串
     * @return boolean
     * @author lanxuewei 2019/1/29 16:44
     */
    public boolean judgeCircle2(String moves) {
        if (moves == null || moves.trim().length() == 0) {
            return true;
        }
        int minsULength = moves.replaceAll("U", "").length();
        int minsDLength = moves.replaceAll("D", "").length();
        if (minsULength != minsDLength) {
            return false;
        }
        int minsRLength = moves.replaceAll("R", "").length();
        int minsLLength = moves.replaceAll("L", "").length();
        return minsRLength == minsLLength;
    }

    // test
    public static void main(String[] args) {
        String testStr = "UD";
        Solution657 solution657 = new Solution657();
        log.info("judgeCircle = {}", solution657.judgeCircle1(testStr));
    }
}
