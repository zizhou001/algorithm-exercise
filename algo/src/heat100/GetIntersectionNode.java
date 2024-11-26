package heat100;

import utils.ListNode;

import java.util.ArrayList;

/**
 * 注意：只用作保存代码，不可运行
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-30 9:25
 */
public class GetIntersectionNode {

    /**
     * 使用双指针，空间复杂度降为 O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }

    /**
     * 通过，空间复杂度为O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode head = headA;
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            if (nodes.contains(head)) return head;
            head = head.next;
        }
        return null;
    }
}
