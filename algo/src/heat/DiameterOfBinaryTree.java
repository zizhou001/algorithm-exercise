package heat;

import utils.BTreeUtils;
import utils.TreeNode;

/**
 * 对于递归的问题
 * 1.从叶子结点思考问题的边界！！！！
 * 2.从小规模推导算法的流程
 *
 * 关于深度：叶子节点 子树深度为 1
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 16:05
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    private int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    public int depth(TreeNode root){
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        maxDepth = Math.max(l + r, maxDepth);
        return Math.max(l, r) + 1;
    }
}
