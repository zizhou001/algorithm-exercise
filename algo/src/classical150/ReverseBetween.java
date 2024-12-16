package classical150;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-13 10:54
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ReverseBetween s = new ReverseBetween();
        ListNode head = ListUtils.generateList(new int[]{1, 2, 3, 4, 5});
        head = s.reverseBetween(head, 1, 3);
        ListUtils.printList(head);
    }

    /**
     * 使用头插法，只需要遍历一次
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        // 对于需要用到prev的问题，建立一个临时的节点，放在head之前
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 找到prev of targetNode
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 对于遍历到的节点，插入到prev的后面
        ListNode cur = prev.next, next = null;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }
}
