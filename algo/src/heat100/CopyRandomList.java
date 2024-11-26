package heat100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-01 9:32
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        printList(copyRandomList.copyRandomList(generateList(new int[]{1,2,3,4,5})));
    }


    private Map<Node, Node> map = new HashMap<>();

    /**
     * 使用递归求解，用map记录原始节点是否已经被创建，确保不会重复创建
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){
        if (head == null) return null;

        if (!map.containsKey(head)){
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    /**
     * 较为复杂,但内存消耗较少
     * @param head
     * @return
     */
    public Node fun0(Node head) {
        Node newHead = new Node(0);
        Node p = head, pn = newHead;

        HashMap<Node, Integer> nodeIntegerHashMap = new HashMap<>();
        HashMap<Integer, Node> newMap = new HashMap<>();
        HashMap<Integer, Integer> rMap = new HashMap<>();

        // 记录（addr, value)
        int i = 1;
        while (p != null){
            nodeIntegerHashMap.put(p, i);
            p = p.next;
            ++i;
        }

        // 寻找对应关系
        i = 1;
        p = head;
        while (p != null){
            rMap.put(i++, p.random !=null ? nodeIntegerHashMap.get(p.random) : -1);
            p = p.next;
        }

        // 复制val
        i = 1;
        p = head;
        while (p != null) {
            Node node = new Node(p.val);
            newMap.put(i++, node);
            pn.next = node;
            pn = node;
            p = p.next;
        }
        pn.next = null;

        // 添加random指向
        i = 1;
        pn = newHead.next;
        while (pn != null){
            pn.random = rMap.get(i) != -1 ? newMap.get(rMap.get(i)) : null;
            pn = pn.next;
            ++i;
        }
        return newHead.next;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node curr = head;
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

    public static Node generateList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            node.random = null;
            curr.next = node;
            curr = node;
        }
        curr.next = null;

        Node p1 = head;
        Node p2 = p1.next;
        Node p3 = p2.next;
        Node p4 = p3.next;
        Node p5 = p4.next;

        p1.random = p4;
        p2.random = null;
        p3.random = p1;
        p4.random = p3;
        p5.random = p1;


        return head;
    }
}
