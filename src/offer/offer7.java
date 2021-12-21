package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/28.
 */
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。
// 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

public class offer7 {
    @Test
    public void main() {
        System.out.println(reverseLeftWords1("abcdefg", 2));
    }

    //思路1：计算每个字符位移后的位置，填入新数组。
    public String reverseLeftWords1(String s, int n) {
        char[] newStr = new char[s.length()];
        //前提条件：n<s.length()
//        n = n % s.length();
        for (int i = 0; i < s.length(); i++) {
//            if (i < n) {
//                newStr[i - n + s.length()] = s.charAt(i);
//            } else {
//                newStr[i - n] = s.charAt(i);
//            }
            newStr[(i - n + s.length()) % s.length()] = s.charAt(i);
        }
        return new String(newStr);
    }

    //思路2：使用StringBuilder遍历填入，从n开始遍历填入
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //思路3：由于字符串是整段位移，可以裁剪字符串，再拼接
    public String reverseLeftWords3(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return s2 + s1;
    }

    //思路4：也可以先拼接再裁剪字符串
    public String reverseLeftWords4(String s, int n) {
        return (s + s).substring(n, s.length() + n);
    }
}
