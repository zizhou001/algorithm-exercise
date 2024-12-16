package classical150;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-16 9:36
 */
public class RotateRight {

    public static void main(String[] args) {
        RotateRight s = new RotateRight();
        ListNode head = ListUtils.generateList(new int[]{1,2,3,4,5});
        ListUtils.printList(s.rotateRight(head, 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;

        // 计算链表长度
        int len = 1;
        ListNode p = head;
        while(p.next != null){
            ++len;
            p = p.next;
        }
        ListNode tail = p;

        // 对原链表不产生影响
        if(len == 1 || k % len == 0) return head;

        // 找到链表的新头结点
        int i = 0;
        ListNode newHead = head;
        while(i < (len - k % len)){
            newHead = newHead.next;
            ++i;
        }

        // 将链表设置为环状
        tail.next = head;

        // 找齐len个节点后断开
        i = 1;
        p = newHead;
        while (i < len){
            p = p.next;
            ++i;
        }
        p.next = null;

        // 返回新头结点
        return newHead;
    }
}
