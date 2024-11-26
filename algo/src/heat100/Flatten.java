package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.ArrayList;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表
 * - 展开后的单链表应该同样使用 TreeNode ，
 *   其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * - 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-06 9:22
 */
public class Flatten {
   ArrayList<TreeNode> treeNodes = new ArrayList<>();

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{1, 2, 5, 3, 4, null, 6});
        Flatten s = new Flatten();
        s.flatten(root);
        utils.printByLevelOrder(root);
    }

    public void flatten(TreeNode root) {
        preorder(root);
        for (int i = 0; i < treeNodes.size() - 1; i++) {
            treeNodes.get(i).left = null;
            treeNodes.get(i).right = treeNodes.get(i+1);
        }
    }

    public void preorder(TreeNode root){
        if (root == null) return;
        treeNodes.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}
