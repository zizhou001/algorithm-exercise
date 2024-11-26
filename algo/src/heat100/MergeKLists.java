package heat100;

import utils.ListNode;
import utils.ListUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-02 8:54
 */
public class MergeKLists {

    PriorityQueue<Status> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        ListNode list1 = ListUtils.generateList(new int[]{1, 4, 5});
        ListNode list2 = ListUtils.generateList(new int[]{1, 3, 4});
        ListNode list3 = ListUtils.generateList(new int[]{2, 6});
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        ListUtils.printList(new MergeKLists().mergeKLists2(lists));
    }

    /**
     * 不创建额外的空间，递归使用归并排序，用时最短
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];

        // copyOfRange的参数区间是  左闭右开
        ListNode left = mergeKLists2(Arrays.copyOfRange(lists, 0, n / 2));
        ListNode right = mergeKLists2(Arrays.copyOfRange(lists, n/2, n));

        return merge2SortedList(left, right);
    }

    public ListNode merge2SortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }

    /**
     * 使用优先队列时，比较Status(val, ptr)中的val
     *
     * @param lists
     * @return
     * @see Status
     * @see queue
     */
    public ListNode mergeKLists12(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) queue.offer(new Status(node.val, node));
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()){
            Status status = queue.poll();
            cur.next = status.ptr;
            cur = cur.next;
            if (status.ptr.next != null) queue.offer(new Status(status.ptr.next.val, status.ptr.next));
        }
        return head.next;
    }

    /**
     * 通过，但是执行用时和内存消耗较高
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        ListNode p = null;
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            p = lists[i];
            while (p != null) {
                queue.add(p.val);
                p = p.next;
            }
        }

        ListNode head = new ListNode(-1);
        p = head;

        while (queue.peek() != null) {
            ListNode node = new ListNode(queue.poll());
            p.next = node;
            p = node;
        }
        return head.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }


        @Override
        public int compareTo(Status status) {
            return this.val - status.val;
        }
    }
}
