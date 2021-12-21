package offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Afauria on 2021/11/27.
 */
//请实现 copyRandomList1 函数，复制一个复杂链表。
// 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
public class offer5 {
    @Test
    public void main() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.next = second;
        second.next = third;
        first.random = second;
        second.random = second;
        third.random = first;
        Node tmp = first;
        while (tmp != null) {
            System.out.println(tmp.val + "  " + tmp.random.val);
            tmp = tmp.next;
        }
        Node result = copyRandomList2(first);
        while (result != null) {
            System.out.println(result.val + "  " + result.random.val);
            result = result.next;
        }
    }

    //坑在于新链表不能指向原链表的节点，全部都需要复制
    //思路1
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node origin = head;
        Node result = new Node(head.val);
        Node cursor = result;
        cursor.random = head.random;
        //先复制链表，random指向原链表的节点
        while (head.next != null) {
            head = head.next;
            Node tmp = new Node(head.val);
            tmp.random = head.random;
            cursor.next = tmp;
            cursor = cursor.next;
        }
        cursor = result;
        //找到原链表节点在新链表中的对应节点的位置
        while (cursor != null) {
            Node tmp = result;
            head = origin;
            while (cursor.random != head) {
                head = head.next;
                tmp = tmp.next;
            }
            cursor.random = tmp;
            cursor = cursor.next;
        }
        return result;
    }

    //思路2：复制各节点，拼接成一个新链表，再拆分，新链表节点位置在旧链表之后
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cursor = head;
        //修改原列表，复制每一个节点：1->2->3变为1->1->2->2->3->3
        while (cursor != null) {
            Node tmp = new Node(cursor.val);
            tmp.next = cursor.next;
            cursor.next = tmp;
            cursor = tmp.next;
        }
        cursor = head;
        //给新节点的random赋值
        while (cursor != null) {
            Node random = cursor.random;
            if (random != null) {
                cursor.next.random = random.next;
            }
            cursor = cursor.next.next;
        }
        Node result = head.next;
        Node pre = head;
        cursor = head.next;
        //拆分新链表
        while (cursor.next != null) {
            pre.next = pre.next.next;
            cursor.next = cursor.next.next;
            pre = pre.next;
            cursor = cursor.next;
        }
        pre.next = null;
        return result;
    }

    //思路3：使用Map存储两个链表的映射
    public Node copyRandomList3(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cursor = head;
        while (cursor != null) {
            Node newNode = new Node(cursor.val);
            map.put(cursor, newNode);
            cursor = cursor.next;
        }
        cursor = head;
        while (cursor != null) {
            map.get(cursor).random = map.get(cursor.random);
            map.get(cursor).next = map.get(cursor.next);
            cursor = cursor.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

