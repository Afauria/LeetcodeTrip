package tencent;

import org.junit.Test;

/**
 * Created by Afauria on 2020/5/2.
 */
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
// 所以返回 [0, 1]
public class Tencent1 {
    @Test
    public void main() {
        int[] result = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(result[0] + "，" + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        //第1个去匹配后面的所有数字
        //如果没有，则第二个去匹配后面的所有数字
        for (int i = 0; i < nums.length; i++) {
            //计算放里面次数会更多
            int num2 = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (num2 == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
