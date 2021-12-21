package daily;

import org.junit.Test;

/**
 * Created by Afauria on 2020/5/1.
 */
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//示例：
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class Easy1 {
    @Test
    public void main() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(mergeTwoLists(list1, list2).toString());
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cursor = null;
        ListNode temp;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            if (result == null) {
                result = temp;
                cursor = result;
                continue;
            }
            cursor.next = temp;
            cursor = temp;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(val);
            ListNode temp = this;
            while (temp.next != null) {
                temp = temp.next;
                builder.append("->" + temp.val);
            }
            return builder.toString();
        }
    }
}
