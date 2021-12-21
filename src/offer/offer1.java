package offer;

import org.junit.Test;
import java.util.*;

/**
 * Created by Afauria on 2021/11/23.
 */
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
public class offer1 {
    @Test
    public void main() {
        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }

    class CQueue {
        //使用Stack需要考虑位移和扩容消耗
        private Deque<Integer> stack1 = new LinkedList<>();
        private Deque<Integer> stack2 = new LinkedList<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        //栈2为空的时候从栈1中取
        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.pop();
        }
    }
}