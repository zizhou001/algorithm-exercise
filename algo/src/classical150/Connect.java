package classical150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-12-17 11:16
 */
public class Connect {

    /**
     * 遍历当前层时，就为下一层构建next指针
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return null;

        Node cur = root;
        while (cur != null) {
            // 下一层虚拟头结点
            Node dummy = new Node(0);
            // 用于构建下一层的链表
            Node p = dummy;
            // 使用当前层所有的节点，构建下一层
            while (cur != null) {
                if (cur.left != null) {
                    p.next = cur.left;
                    p = p.next;
                }
                if (cur.right != null) {
                    p.next = cur.right;
                    p = p.next;
                }
                cur = cur.next;
            }
            // 下一层构建完毕

            // 考察下一层
            cur = dummy.next;
        }
        return root;
    }

    public Node connect0(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i != 1) {
                    last.next = node;
                }
                last = node;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
