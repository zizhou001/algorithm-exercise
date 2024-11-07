package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 9:20
 */
public class BTreeUtils {

    private ArrayList<TreeNode> lists = new ArrayList<>();

    public static void main(String[] args) {
        BTreeUtils bTreeUtils = new BTreeUtils();
        TreeNode node = bTreeUtils.buildBTreeByPreorder(new Integer[]{1, null, 2, 3}, new int[]{0});
    }

    public TreeNode buildBTreeByPreorder(Integer[] preorder, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] == null) {
            ++index[0];
            return null;
        }
        TreeNode node = new TreeNode(preorder[index[0]++]);
        node.left = buildBTreeByPreorder(preorder, index);
        node.right = buildBTreeByPreorder(preorder, index);
        return node;
    }

    public TreeNode buildBTreeByPreorder(Integer[] preorder, int index){
        if (index >= preorder.length) return null;
        TreeNode node = new TreeNode(preorder[index]);
        node.left = buildBTreeByPreorder(preorder, 2 * index + 1);
        node.right = buildBTreeByPreorder(preorder, 2 * index + 2);
        return node;
    }

    public TreeNode buildTreeByLevel(Integer[] values){
        if (values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]); // 创建根节点
        Queue<TreeNode> queue = new LinkedList<>(); // 队列用于层次遍历
        queue.add(root);

        int index = 1; // 从数组的第二个元素开始
        while (!queue.isEmpty() && index < values.length) {
            TreeNode currentNode = queue.poll(); // 获取当前节点

            // 构建左子节点
            if (index < values.length && values[index] != null) {
                currentNode.left = new TreeNode(values[index]);
                queue.add(currentNode.left);
            }
            index++;

            // 构建右子节点
            if (index < values.length && values[index] != null) {
                currentNode.right = new TreeNode(values[index]);
                queue.add(currentNode.right);
            }
            index++;
        }

        return root;
    }

    public void printByPreorder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        printByPreorder(root.left);
        printByPreorder(root.right);
    }

    public void printByLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " "); // 打印当前节点

            if (node.left != null) {
                queue.add(node.left); // 加入左子树
            }
            if (node.right != null) {
                queue.add(node.right); // 加入右子树
            }
        }
    }
}
