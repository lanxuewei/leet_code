/**
 * Copyright (c) 2017-2019 DeepWise All Rights Reserved.
 * http://www.deepwise.com
 */
package com.lanxuewei.leet_code._899;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lanxuewei Create in 2019/1/22 20:27
 * Description: 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 */
@Slf4j
public class Solution804 {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> passWordSet = new HashSet<>(words.length);
        for (String word : words) {
            passWordSet.add(transferWord(word));
        }
        return passWordSet.size();
    }

    /**
     * 将单词翻译为密码
     * @param word 单词
     * @return 翻译结果
     */
    private String transferWord(String word) {
        String[] passWord = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder res = new StringBuilder(word.length());
        for (char c : word.toCharArray()) {
            if (c >= 65 && c <= 90) {   // 将大写字母转化为小写字母
                c -= 32;
            }
            res.append(passWord[c-97]); // a -> 97 但是数组中下标为0
        }
        return res.toString();
    }

    // test
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Solution804 solution804 = new Solution804();
        log.info("uniqueMorseRepresentations = {}", solution804.uniqueMorseRepresentations(words));
    }
}
