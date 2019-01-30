/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._999;

import javafx.collections.transformation.SortedList;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author lanxuewei Create in 2019/1/30 9:50
 * Description: 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 */
@Slf4j
public class Solution973 {

    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, Double> disIdxMap = new HashMap<>();
        for (int i = 0; i <= points.length-1; i++) {
            disIdxMap.put(i, Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]));
        }
        // 将map转化为list使用val进行降序排序
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(disIdxMap.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        int[][] res = new int[K][2];
        for (int i = 0; i <= K-1; i++) {
            res[i] = points[list.get(i).getKey()];
        }
        return res;
    }

    // test
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {-2,2}};
        Solution973 solution973 = new Solution973();
        log.info("kClosest = {}", (Object) solution973.kClosest(arr, 1));
    }
}
