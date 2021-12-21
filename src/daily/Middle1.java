package daily;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Afauria on 2020/5/2.
 */
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

//输入: "bbbbb"
//输出: 1

//输入: "pwwkew"
//输出: 3
public class Middle1 {
    @Test
    public void main() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 滑动窗口方法，有重复的移除左边的
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        LinkedList queue = new LinkedList();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (queue.indexOf(temp) != -1) {
                queue.removeFirst();
                i--;
            }else{
                queue.add(temp);
            }
            if (length < queue.size()) {
                length = queue.size();
            }
        }
        return length;
    }
}
