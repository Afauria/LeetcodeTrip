package daily;

import org.junit.Test;

/**
 * Created by Afauria on 2020/5/3.
 */
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//示例:
//  输入: [-2,1,-3,4,-1,2,1,-5,4],
//  输出: 6
//  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class Easy2 {
    @Test
    public void main() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 动态规划，sum表示前面的子序列的和，如果和小于等于0，直接舍弃，如果和大于0，继续扩大子序列
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}
