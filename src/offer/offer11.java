package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/28.
 */
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class offer11 {
    @Test
    public void main() {
        int[][] martix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(martix, 5));
        System.out.println(findNumberIn2DArray(martix, 13));
        System.out.println(findNumberIn2DArray(martix, 20));
    }

    //思路1：暴力查找，遍历
    //思路2：从左下角（或者右上角）开始查找，小于目标值则往上搜索，大于目标值则往右搜索。（可以将数组旋转45度，类似二叉搜索树）
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int cursorY = matrix.length - 1;
        int cursorX = 0;
        while (cursorY >= 0 && cursorX < matrix[0].length) {
            int value = matrix[cursorY][cursorX];
            if (value < target) {
                cursorX++;
            } else if (value > target) {
                cursorY--;
            } else {
                return true;
            }
        }
        return false;
    }
}
