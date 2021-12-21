package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/12/1.
 */
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//
//给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
// 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  
public class offer12 {
    @Test
    public void main() {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray(new int[]{2, 2, 3, 4, 1}));
        System.out.println(minArray(new int[]{3, 1, 3, 3}));
        System.out.println(minArray(new int[]{3, 1}));
        System.out.println(minArray(new int[]{10, 1, 10, 10, 10}));
    }

    //思路1：二分查找
    //思路2：遍历找到最小值
    //思路3：数组重新排序之后取第一个元素
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int m = (left + right) / 2;//向下取整，因此left<=m<right
            //使用right判断，如[1,2,3,4,5]，[3,4,5,1,2]这种情况下nums[left]<nums[m]，但是无法判断最小值在m左侧还是右侧
            if (numbers[right] < numbers[m]) {
                left = m + 1;
            } else if (numbers[right] > numbers[m]) {
                right = m;
            } else {
                //无法确定在左区间还是右区间，如[1, 1, 1, 0, 1]在右区间、[1, 0, 1, 1, 1]在左区间
                // right可以减1舍弃缩小范围，不影响，因为nums[m]还在区间内，可以作为nums[right]的替代品
                right--;
            }
        }
        return numbers[left];
    }
}
