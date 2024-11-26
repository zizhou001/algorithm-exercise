package heat100;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-31 10:22
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListUtils.printList(new SwapPairs().swapPairs(ListUtils.generateList(new int[]{1,2,3,4})));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        // 将链表其余节点交换，交换后的新头结点为head的下一个节点
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }


    /**
     * 原地普通交换
     *
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        ListNode fastNext = null, pre = slow;
        head = fast;
        while (fast != null){
            pre.next = fast;
            fastNext = fast.next;
            slow.next = fastNext;
            fast.next = slow;
            pre = slow;
            slow = slow.next;
            if (slow == null) break;
            fast = slow.next;
        }
        return head;
    }
}
