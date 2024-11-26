package heat100;

import utils.ListNode;

/**
 * 思路：
 * 发现环后，ptr = head，与slow一起移动，直到ptr = slow
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 10:56
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow  = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode getCircle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            if (slow == fast) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
