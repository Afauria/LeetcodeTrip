package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/11/27.
 */
//链表反转：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
public class offer4 {
    @Test
    public void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode result = reverseList3(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //思路1：倒着构造链表，保存已构造好的链表，每次循环创建新的头节点，连接上已构造好的链表
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        while (head.next != null) {
            ListNode newHead = new ListNode(head.next.val);
            newHead.next = result;
            result = newHead;
            head = head.next;
        }
        return result;
    }

    //思路2：双指针，使用临时变量暂存下一个节点，将当前节点断开指向前一个节点
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    //思路3：递归
    //1,2,3（终止）,2,1
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList3(head.next);
        head.next.next = head;  //下一个节点指向自己
        head.next = null;   //自己指向null
        return node;
    }

    //思路4：递归
    public ListNode reverseList4(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }

    //f(n,n-1)=f(n+1,n)+n指向n-1
    //[1,null], [2,1], [3,2], [null,3]（终止）, [3,2], [2,1], [1,null]
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

