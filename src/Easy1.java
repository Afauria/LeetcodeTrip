import org.junit.Test;

/**
 * Created by Afauria on 2020/5/3.
 */
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//示例 1:
//  输入: 121
//  输出: true
//示例 2:
//  输入: -121
//  输出: false
//  解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//示例 3:
//  输入: 10
//  输出: false
//  解释: 从右向左读, 为 01 。因此它不是一个回文数。
public class Easy1 {
    @Test
    public void main() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(456));
        System.out.println(isPalindrome(34543));
        System.out.println(isPalindrome(4444));
    }

    public boolean isPalindrome(int x) {
        //负数不是回文数
        if (x < 0) {
            return false;
        }
        //末尾为0且不是0的数不是回文数
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int reverse = 0;
        //int范围2147483647，当最后一位大于2时可能溢出
        //只反转后一半数字，防止溢出
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse == x || reverse / 10 == x;
    }
}
