package heat;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 10:43
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = ListUtils.generateList(new int[]{1, 2, 4});
        ListNode node2 = ListUtils.generateList(new int[]{1, 3, 4});
        ListUtils.printList(new MergeTwoSortedLists().mergeTwoLists(node1, node2));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode head = new ListNode(-1);
        ListNode p = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode node = new ListNode(p1.val);
                p.next = node;
                p1 = p1.next;
                p = node;
            } else {
                ListNode node = new ListNode(p2.val);
                p.next = node;
                p2 = p2.next;
                p = node;
            }
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return head.next;
    }
}
