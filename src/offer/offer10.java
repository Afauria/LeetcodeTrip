package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/28.
 */
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
// 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
public class offer10 {
    @Test
    public void main() {
        System.out.println(missingNumber3(new int[]{0, 1}));
    }
    //思路4：数学法：正常等差数列和为`sum=n*(n+1)/2`，遍历减去数组中所有数字的和，即可得到缺失的值
    //思路1：综合条件，可知数组不存在相同值，且每次递增1
    //因此可以判断相邻数字相差是否为1，考虑边缘情况：这个数字在第一个或最后一个
    public int missingNumber1(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        int i = 0;
        while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
            i++;
        }
        return nums[i] + 1;
    }

    //思路2：综合条件，可知每一项值等于对应的索引
    //因此可以找出值和索引不一样的项，考虑边缘情况：这个数字在第一个或最后一个
    public int missingNumber2(int[] nums) {
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i] - 1;
            }
        }
        return 0;
    }

    //思路3：由于是排序数组，可以使用二分查找，找到第一个值大于索引的项
    public int missingNumber3(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
