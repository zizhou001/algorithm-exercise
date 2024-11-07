package heat;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-31 9:49
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListUtils.printList(new RemoveNthFromEnd().removeNthFromEnd1(
                ListUtils.generateList(new int[]{1, 2}),
                2));
    }

    /**
     * 使用双指针：
     * 1. 快指针，先行n步
     * 2. 慢指针，指向head
     * 3. 同时走，step=1，直到快指针到结尾
     * 4. 此时，slow所在的就是倒数第n个元素的前一个元素
     * 5. slow.next = slow.next.next
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode fast = head, slow = head;
        while (n > 0) {
            fast = fast.next;
            if (fast == null) return head.next;
            n--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;

    }

    /**
     * 有待改进，这种方法需要遍历两次链表
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd0(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode p = head;
        int len = 0;

        while (p != null) {
            p = p.next;
            ++len;
        }

        if (n == len) return head.next;

        p = head;

        while (len > 0) {
            if (len == n + 1) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
            --len;
        }
        return head;
    }
}
