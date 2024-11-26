package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 14:04
 */
public class InvertTree {
    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildBTreeByPreorder(new Integer[]{4,2,7,1,3,6,9}, 0);
        InvertTree solution = new InvertTree();
        utils.printByLevelOrder(solution.invertTree(root));
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
