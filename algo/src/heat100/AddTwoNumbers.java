package heat100;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-31 9:23
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = ListUtils.generateList(new int[]{2, 4});
        ListNode node2 = ListUtils.generateList(new int[]{5, 6, 4});
        ListUtils.printList(new AddTwoNumbers().addTwoNumbers(node1 ,node2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p1 = l1, p2 = l2, p = head;
        boolean carry = false;

        while (p1 != null && p2 != null){
            int sum = p1.val + p2.val + (carry ? 1 : 0);
            ListNode node = new ListNode(sum > 9 ? sum - 10 : sum);
            carry = sum > 9;
            p.next = node;
            p = node;
            p.next = null;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null){
            int sum = p1.val + (carry ? 1 : 0);
            carry = sum > 9;
            ListNode node = new ListNode(sum > 9 ? sum - 10 : sum);
            p.next = node;
            p = node;
            p.next = null;
            p1 = p1.next;
        }

        while (p2 != null){
            int sum = p2.val + (carry ? 1 : 0);
            carry = sum > 9;
            ListNode node = new ListNode(sum > 9 ? sum - 10 : sum);
            p.next = node;
            p = node;
            p.next = null;
            p2 = p2.next;
        }

        if (carry){
            ListNode node = new ListNode(1);
            p.next = node;
            p = node;
            p.next = null;
        }

        return head.next;
    }
}
