package classical150;

import utils.ListNode;
import utils.ListUtils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-16 10:23
 */
public class PartitionListNode {

    public static void main(String[] args) {
        PartitionListNode s = new PartitionListNode();
        ListNode head = ListUtils.generateList(new int[]{1,4,3,0,2,5,2});
        ListUtils.printList(s.partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode dummyNode = new ListNode(-201);
        dummyNode.next = head;
        ListNode p = dummyNode, part1Tail = dummyNode;
        int checkedVal = dummyNode.val;
        while(p.next != null){
            checkedVal = Math.max(p.val, checkedVal);
            if(p.next.val < x && checkedVal >= x){
                ListNode target = p.next;
                p.next = p.next.next;
                ListNode tailNext = part1Tail.next;
                part1Tail.next = target;
                target.next = tailNext;
                part1Tail = target;
            }else{
                part1Tail = p.val < x ? p : part1Tail;
                p = p.next;
            }
        }
        return dummyNode.next;
    }
}
