package heat;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-01 8:39
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListUtils.printList(new ReverseKGroup().reverseKGroup(ListUtils.generateList(new int[]{1,2,3,4,5}), 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode p = head;
        ListNode gNewHead = null, gNewTail = null, lastNewTail = null;

        int i = 0;
        while (p != null){

            ListNode gOldHead = p;
            while (i < k - 1 && p != null){
                p = p.next;
                ++i;
            }
            if (p == null) {
                lastNewTail.next = gOldHead;
                return head;
            }
            ListNode gOldTail = p;
            ListNode gOldTailNext = gOldTail.next;

            i = 0;
            ListNode[] reversedTmp = reverseList(gOldHead, gOldTailNext);
            gNewHead = reversedTmp[0];
            gNewTail = reversedTmp[1];
            if (lastNewTail == null) {
                head = gNewHead;
            }
            else {
                lastNewTail.next = gNewHead;
            }
            lastNewTail = gNewTail;
            gNewTail.next = gOldTailNext;
            p = gOldTailNext;
        }

        return head;
    }

    public ListNode[] reverseList(ListNode head, ListNode tailNext) {
        ListNode[] newHeadAndTail = new ListNode[2];
        if (head == tailNext || head.next == tailNext) return new ListNode[]{head, head};
        ListNode prev = null, next = null, cur = head;

        while (cur != tailNext){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        newHeadAndTail[0] = prev;
        newHeadAndTail[1] = head;
        return newHeadAndTail;
    }
}
