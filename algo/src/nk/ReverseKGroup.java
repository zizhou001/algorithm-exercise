package nk;

/**
 * @author zizhou
 * @create 2023-11-15 14:48
 */

class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int _val){
        val = _val;
    }
}

class ListTools{
    public static void printLink(ListNode head){
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode generateList(int length){
        ListNode head = new ListNode(1);
        ListNode curr = head;
        int sum = 2;
        while (sum <= length){
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = temp;
            sum++;
        }
        return head;
    }

    public static ListNode reverseKGroup (ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;

        ListNode newHead = null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        if (count < k) return head;
        count -= count % k;
        curr = head;
        int num = 1;
        ListNode lastEnd = null;
        ListNode thisEnd = null;
        ListNode lastBegin = null;
        while(num <= count){
            if(num % k == 1){//first node in current part
                thisEnd = curr;
                prev = null;
            }else if(num % k == 0){//last node in current part
                if (num == k){ // the first part in list
                    newHead = curr;
                    lastEnd = thisEnd;
                }
                else{
                    lastEnd.next = curr;
                    lastEnd = thisEnd;
                }
            }
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            num++;
        }
        lastEnd.next = curr;

        return newHead;
    }

    public static int getNumber(ListNode head) {
        String numberStr = "";
        while (head != null) {
            numberStr += head.val;
            head = head.next;
        }
        return Integer.parseInt(numberStr);
    }
}

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode head1 = ListTools.generateList(3);
        ListNode head2 = ListTools.generateList(3);


        System.out.println(ListTools.getNumber(head1));

    }
}
