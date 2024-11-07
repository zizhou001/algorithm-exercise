package heat;

import utils.ListNode;

/**
 *
 * 思路：
 * 1. 快慢指针
 * 2. 若存在环，必然会相遇
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 10:32
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
