package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/12/7.
 */
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//0<=n<=100
public class offer20 {
    @Test
    public void main() {
        System.out.println(fib3(1));
        System.out.println(fib2(1));
    }

    //由于int类型会越界，因此需要取模
    //思路1：递归，效率低，大量重复计算，超时。如计算f(3)，需要计算f(2)和f(1)，计算f(2)又要计算一遍f(1)
    private int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib1(n - 1) + fib1(n - 2)) % 1000000007;
    }

    int[] save = new int[101];

    //思路2：递归基础上建一个数组存储f(n)的值，避免重复计算
    private int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (save[n] != 0) {
            return save[n];
        }
        save[n] = (fib2(n - 1) + fib2(n - 2)) % 1000000007;
        return save[n];
    }

    //思路3：动态规划，时间复杂度O(N)。状态转移方程：F(N) = F(N - 1) + F(N - 2)
    private int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        int a = 1, b = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            b = a;
            a = sum;
        }
        return sum;
    }
}
