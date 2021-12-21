package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/28.
 */
//统计一个数字在排序数组中出现的次数。
public class offer9 {
    @Test
    public void main() {
        System.out.println(search2(new int[]{5, 7, 8, 8, 8, 10}, 8));
    }

    //思路1：遍历查找统计，提前结束遍历
    public int search1(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (target == num) {
                count++;
            } else if (count > 0) {
                //由于是排序数组，因此可以提前结束
                //或者判断num > target
                return count;
            }
        }
        return count;
    }

    //思路2：排序数组均可以使用二分查找。
    //两次二分，分别找到目标值左右边界，再相减
    public int search2(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        //先查找左边界
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] >= target) {//目标值在左半部分或者在两侧
                j = m;
            } else if (nums[m] < target) {//目标值在右半部分
                i = m + 1;
            }
        }
        int left = i;
        if (nums[j] != target) return 0;//数组中没有target，可以提前返回
        //左边界已经确定，由于右边界一定大于或等于左边界，因此第二次二分只需要从左边界开始
        j = nums.length - 1;
        //查找右边界
        while (i < j) {
            int m = (i + j + 1) / 2;
            if (nums[m] <= target) {
                i = m;
            } else {
                j = m - 1;
            }
        }
        int right = j;
        return right - left + 1;
    }
}
