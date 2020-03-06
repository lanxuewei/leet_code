package com.lanxuewei.leet_code._599;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * create by lanxuewei in 2019-07-27 00:09
 * description: TinyURL是一种URL简化服务
 * 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
 * 你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
@Slf4j
public class Solution535 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encodeStr = codec.encode("http://www.baidu.com");
        log.info("encodeStr = {}", encodeStr);
        log.info("decodeStr = {}", codec.decode(encodeStr));
    }

    static class Codec {

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (longUrl == null || longUrl.equals("")) {
                return longUrl;
            }
            String first = longUrl.replaceFirst("http://", "");
            StringBuffer sb = new StringBuffer();
            char[] chars = first.toCharArray();
            for (char c : chars) {
                char changed = (char) ((int) c + 1);
                sb.append(changed);
            }
            return "http://" + sb.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (shortUrl == null || shortUrl.equals("")) {
                return shortUrl;
            }
            String first = shortUrl.replace("http://", "");
            StringBuffer sb = new StringBuffer();
            char[] chars = first.toCharArray();
            for (char c : chars) {
                char changed = (char) ((int) c - 1);
                sb.append(changed);
            }
            return "http://" + sb.toString();
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
