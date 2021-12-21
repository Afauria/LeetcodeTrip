package offer;

import org.junit.Test;

import java.util.*;

/**
 * Created by Afauria on 2021/12/1.
 */
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
public class offer13 {
    @Test
    public void main() {
        System.out.println(firstUniqChar2("abaccdeff"));
    }

    //思路1：使用哈希表保存字符出现次数
    //注：HashMap取出不一定保证顺序，题目要求找出第一个只出现一次的字符，因此需要用有序哈希表。
    //或者二次遍历不遍历哈希表，而是遍历字符串
    public char firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    //优化：不使用int计数，保存bool类型
    public char firstUniqChar3(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));//true表示只出现一次
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    //思路2：使用HashMap+队列，首次出现则加到队列中，再次出现如果在队头则出队，保证队头是只出现一次的字符
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, true);
                queue.offer(c);
            } else {
                map.put(c, false);
                //需要遍历出队，如字符串abbcca，队列abc，需要一起出队
                while (!queue.isEmpty() && !map.get(queue.peek())) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll();
    }
}
