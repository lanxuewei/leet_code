package com.lanxuewei.leet_code._1299;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lanxuewei create in 2020/3/6 16:51
 * description:
 */
@Slf4j
public class Solution1299 {

    public static void main(String[] args) {
        int[] arr = new int[] {17,18,5,4,6,1};

        int[] resArr = new Solution1299().replaceElements(arr);
        log.info("replaceElements resArr = {}", resArr);

        int[] resArr2 = new Solution1299().replaceElements_v2(arr);
        log.info("replaceElements_v2 resArr2 = {}", resArr2);
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;
        int[] resArr = new int[arr.length];
        resArr[arr.length-1] = -1;
        for (int i = arr.length-1, j = arr.length-2; i >= 1; i--, j--) {
            if (max < arr[i]) {
                resArr[j] = arr[i];
                max = arr[i];
            } else {
                resArr[j] = max;
            }
        }
        return resArr;
    }

    public int[] replaceElements_v2(int[] arr) {
        int max = -1;
        for (int i = arr.length-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }
}
