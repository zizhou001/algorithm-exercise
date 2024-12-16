package heat100;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-01 8:39
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListUtils.printList(new ReverseKGroup().reverseKGroup(ListUtils.generateList(new int[]{1, 2, 3, 4, 5}), 2));
    }

    /**
     * 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 子链表长度，不够k时，不做翻转，直接返回子链表head
        ListNode p = head;
        int count = 0;
        while (p != null) {
            ++count;
            p = p.next;
        }
        if (count < k) return head;

        // 递归翻转子链表，例如，对于1,2,3,4,5的第一次调用
        ListNode prev = head, cur = head.next, next = null;
        for (int i = 0; i < k - 1; i++) {  // 只需要处理k-1个节点
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
