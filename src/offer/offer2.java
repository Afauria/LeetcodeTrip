package offer;

import org.junit.Test;
import java.util.LinkedList;

/**
 * Created by Afauria on 2021/11/23.
 */
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
// 调用 min、push 及 pop 的时间复杂度都是 O(1)。
public class offer2 {
    @Test
    public void main() {
    }

    //思路1：自己实现栈，Node中存储min，保存当前Node之下的最小值
//思路2：两个栈，栈1存储数据，栈2存储当前栈1区间最小值，当被推出的数据是最小值时，栈2也推出最小值，更新最小值为栈2顶部的值
// 如：栈1=[9,10,7,3,5]，栈2=[9,7,3]，5pop之后，最小值还是3，3pop之后，栈2也要pop，最小值变为7
//思路3：1个栈，每次push的时候先push当前的最小值，再push数据。pop的时候pop两次。
// 即每个元素中间插入一个min，表示当前栈底区间的最小值，如[min=max,data=3],[min=3,data=2],[min=2,data=1]
    class MinStack {
        private int min = Integer.MAX_VALUE;
        private LinkedList<Integer> list;

        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            list.push(min);
            if (min > x) {
                min = x;
            }
            list.push(x);
        }

        public void pop() {
            list.pop();
            min = list.pop();
        }

        public int top() {
            return list.peek();
        }

        public int min() {
            return min;
        }
    }
}