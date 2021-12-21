package offer;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Afauria on 2021/11/28.
 */
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
//数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
// 请找出数组中任意一个重复的数字。
public class offer8 {
    @Test
    public void main() {
        System.out.println(findRepeatNumber3(new int[]{0, 1, 1}));
    }

    //思路1：由于nums里的数字小于n，因此可以创建一个bool数组，判断对应的索引位置是否被占用
    //也可以创建int数组，每次填入+1，大于1表示重复
    public int findRepeatNumber1(int[] nums) {
        boolean[] box = new boolean[nums.length];
        for (int n : nums) {
            if (box[n]) {
                return n;
            }
            box[n] = true;
        }
        return 0;
    }

    //思路2：使用HashSet判断是否存在
    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }
        return 0;
    }

    //思路3：类似思路1，但是不创建新数组，直接在原数组上判断，如果索引位置和值不相等则交换位置
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i != n && n == nums[n]) {
                return n;
            }
            int tmp = nums[n];
            nums[n] = nums[i];
            nums[i] = tmp;
        }
        return 0;
    }
}
