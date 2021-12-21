package daily;

import org.junit.Test;

/**
 * Created by Afauria on 2020/5/4.
 */
//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//示例:
//  输入: [2,3,1,1,4]
//  输出: 2
//  解释: 跳到最后一个位置的最小跳跃数是 2。
// 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

public class Hard1 {
    @Test
    public void main() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 1, 2, 1, 4}));
        System.out.println(jump(new int[]{2, 1}));
        System.out.println(jump(new int[]{1, 2, 3}));
        System.out.println(jump(new int[]{1, 2, 1, 1, 1}));
        System.out.println(jump(new int[]{1, 2, 4, 1, 1, 1}));
        System.out.println(jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }

    public int jump(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            int step = -1;
            if (i >= nums.length - 1) {
                break;
            }
            if (nums[i] + i >= nums.length - 1) {
                i += nums[i];
                count++;
                break;
            }
            for (int j = i + 1; j < i + nums[i]; j++) {
                if (nums[i] + nums[j] < j - i + nums[j]) {
                    step = j - i;
                }
            }
            if (step != -1) {
                i += step;
            } else {
                i += nums[i];
            }
            count++;
            step = -1;
        }
        return count;
    }
}
