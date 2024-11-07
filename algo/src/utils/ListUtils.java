package utils;


public class ListUtils {
    /**
     * 链表生成
     *
     * @param arr
     * @return
     */
    public static ListNode generateList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            curr.next = node;
            curr = node;
        }
        curr.next = null;
        return head;
    }

    /**
     * 链表翻转
     *
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 链表打印
     *
     * @param head
     */
    public static void printList(ListNode head) {
        if(head == null) {
            System.out.println("null");return;
        }
        ListNode curr = head;
        int listLen = 0;
        while (true) {
            if (curr.next != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
                listLen++;
            } else {
                System.out.println(curr.val + "\tlen:" + ++listLen);
                break;
            }
        }
    }

    /**
     * TODO:通过率91.30%，提示超时
     * 链表排序（升序）
     *
     * @param head
     * @return
     */
    public static ListNode insertSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;

        while (head != null && head.next != null) {
            // 顺序，继续遍历
            if (head.next.val > head.val) {
                head = head.next;
                continue;
            }

            // 逆序，保存导致逆序的节点
            ListNode target = head.next;
            // 将逆序节点“删除”
            head.next = target.next;

            // 寻找合适的位置
            ListNode prev = newHead;
            while (prev.next.val < target.val) prev = prev.next;


            // 将逆序节点插入合适的位置
            target.next = prev.next;
            prev.next = target;

        }
        return newHead.next;
    }


    /**
     * 获取链表中间节点，中间节点有两个时，取第一个
     * @param head 链表头
     * @return 链表中间节点的引用
     */
    public static ListNode getMidNode(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSorted(ListNode head1, ListNode head2){
        ListNode p1 = head1, p2 = head2, head;
        if(head1.val < head2.val){
            head = head1;
            p1 = p1.next;
        }else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 == null) p.next = p2;
        if(p2 == null) p.next = p1;

        return head;
    }

    /**
     * 进行归并排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMidNode(head);
        ListNode right = mid.next;
        mid.next = null;

        return mergeSorted(sortList(head), sortList(right));
    }

    /**
     * 复制原有链表的值，返回一个新的链表
     * @param head
     * @return
     */
    public static ListNode getNew(ListNode head){
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        ListNode p = newHead;
        head = head.next;
        while (head != null){
            ListNode node = new ListNode(head.val);
            p.next = node;
            p = node;
            head = head.next;
        }
        p.next = null;
        return newHead;
    }

    /**
     * 判断链表是否为回文结构
     * @param head
     * @return
     */
    public static boolean isPail(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }
        ListNode tail = reverse(getNew(head));
        while (head != null){
            if (head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    /**
     * 奇偶节点重排：
     * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
     * 注意是节点的编号而非节点的数值。
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 删除链表中的重复元素
     * 链表特征：
     *   链表节点按照val值从小到大有序排列
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, gap = head;
        while(p.next != null){
            if (p.next.val == gap.val){
                p = p.next;
            }else{
                gap.next = p.next;
                gap = p.next;
                p = gap;
            }
        }
        gap.next = null;
        return head;
    }

    /**
     * 保留链表中只出现一次的元素，并输出
     * 链表特征：
     *  链表节点按照val值从小到大有序排列
     * @param head
     * @return
     */
    public static ListNode remainSingle(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode sHead = new ListNode();
        ListNode p = head, s = sHead, mark = null;
        if(head.val != head.next.val){
            sHead.next = head;
            s = head;
        }
        while (p.next != null){
            if (p.next.val == p.val) p = p.next;
            else{
                mark = p.next;
                if (mark.next == null || mark.next.val != mark.val){
                    s.next = mark;
                    s = mark;
                }
                p = mark;
            }
        }
        return sHead.next;
    }



    public static void main(String[] args) {
        ListNode head = generateList(new int[]{1, 2, 2, 2, 3, 3, 4, 5, 6});
        // ListNode head = generateList(new int[]{1, 1});
        printList(head);
        printList(remainSingle(head));
    }

}
