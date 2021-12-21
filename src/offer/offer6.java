package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/28.
 */
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
public class offer6 {
    @Test
    public void main() {
        System.out.println(replaceSpace5("We are happy."));
    }

    //思路1：正则
    //思路2：Java replace和replaceAll方法
    //思路3：StringBuilder拼接
    //思路4：创建新数组，长度最大为原始3倍，遍历字符串，填入新数组
    //思路5：遍历字符串，统计空格数量。创建新数组，长度=原字符串长度*空格数*2，再遍历填入新数组
    public String replaceSpace3(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == ' ') {
                sb.append("%20");
            } else {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }

    public String replaceSpace5(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') count++;
        }
        char[] newStr = new char[s.length() + count * 2];
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            char tmp = s.charAt(i);
            if (tmp == ' ') {
                newStr[j] = '%';
                newStr[j + 1] = '2';
                newStr[j + 2] = '0';
                j += 2;
            } else {
                newStr[j] = tmp;
            }
        }
        return new String(newStr);
    }
}
