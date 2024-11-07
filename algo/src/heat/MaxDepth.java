package heat;

import utils.BTreeUtils;
import utils.TreeNode;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 11:13
 */
public class MaxDepth {

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildBTreeByPreorder(new Integer[]{3, 9, 20, null, null, 15, 7}, new int[]{0});
        MaxDepth solution = new MaxDepth();
        System.out.println(solution.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftTreeDepth = maxDepth(root.left);
            int rightTreeDepth = maxDepth(root.right);
            return Math.max(leftTreeDepth, rightTreeDepth) + 1;
        }
    }
}
