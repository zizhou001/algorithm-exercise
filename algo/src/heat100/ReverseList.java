package heat100;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 9:56
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node = ListUtils.generateList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = new ReverseList().reverseList(node);
        ListUtils.printList(reversed);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, next = null, cur = head;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
