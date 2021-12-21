package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/26.
 */
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
public class offer3 {
    @Test
    public void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new Solution().reversePrint6(head);
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(2);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //思路1：使用栈，后进先出，遍历压栈再遍历推出
//思路2：使用列表，遍历存入列表，再倒序取出
//思路3：先遍历获取链表长度，创建数组，再遍历链表，倒序填入数组
//思路4：链表反转，再存入数组。
//思路5：递归将节点加入列表，再转换为数组
//思路6：使用i记录递推次数，递归到底部创建数组，使用j回溯的时候赋值
    class Solution {
//递归的本质就是栈，先遍历压栈，结束之后再出栈
//    recurse(1) {——递推阶段，压栈
//        recurse(2) {
//            recurse(3) {
//                return;
//            }——回溯阶段，出栈
//        }
//    }

        //思路6：使用i记录递推次数，递归到底部创建数组，使用j回溯的时候赋值
        private int i = 0;
        private int j = 0;
        private int[] result;

        public int[] reversePrint6(ListNode head) {
            recurse(head);
            return result;
        }

        private void recurse(ListNode node) {
            if (node == null) {
                result = new int[i];
                return;
            }
            i++;
            recurse(node.next);
            result[j++] = node.val;
        }

        //思路3：先遍历获取链表长度，创建数组，再遍历链表，倒序填入数组
        public int[] reversePrint3(ListNode head) {
            ListNode cur = head;
            int length = 0;
            while (cur != null) {
                length++;
                cur = cur.next;
            }
            int[] result = new int[length];
            while (head != null) {
                result[--length] = head.val;
                head = head.next;
            }
            return result;
        }

        //思路4：链表反转，再存入数组。
        public int[] reversePrint4(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            int count = 1;
            ListNode newListNode = new ListNode(head.val);
            while (head.next != null) {
                ListNode newHead = new ListNode(head.next.val);
                newHead.next = newListNode;
                newListNode = newHead;
                head = head.next;
                count++;
            }
            int[] result = new int[count];
            for (int i = 0; i < count || newListNode != null; i++) {
                result[i] = newListNode.val;
                newListNode = newListNode.next;
            }
            return result;
        }
    }
}
