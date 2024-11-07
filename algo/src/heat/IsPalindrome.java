package heat;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 10:07
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node = ListUtils.generateList(new int[]{1, 1, 2, 1});
        System.out.println(new IsPalindrome().isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode firstHalfEnd = getHalf(head);
        ListNode reversedSecondHalfBegin = reverseList(firstHalfEnd.next);

        ListNode p1 = head, p2 = reversedSecondHalfBegin;
        while (p2 != null){
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(reversedSecondHalfBegin);
        return true;
    }

    public ListNode getHalf(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, next = null, cur = head;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
