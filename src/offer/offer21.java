package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/12/7.
 */
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
public class offer21 {
    @Test
    public void main() {
        System.out.println(numWays(7));
    }

    //动态规划：
    //跳到第1级有1种方式：0->1
    //跳到第2级有2种方式：0->1->2，0->2
    //跳到第3级有3种方式：0->1->2->3，0->2->3，0->1->3
    //f(n)=f(n-1)+f(n-2)
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        int a = 1, b = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            b = a;
            a = sum;
        }
        return sum;
    }
}
