package test;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-01 11:39
 */
public class Solution {

    public static void main(String[] args) {
        ListUtils.printList(new Solution().mergeSort(ListUtils.generateList(new int[]{4,5,1,3,2})));
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 找到链表的中间节点
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;

        // 递归排序左右两部分
        ListNode leftSorted = mergeSort(head);
        ListNode rightSorted = mergeSort(right);

        // 合并两个有序链表
        return merge(leftSorted, rightSorted);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }
}
