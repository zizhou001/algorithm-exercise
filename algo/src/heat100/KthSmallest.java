package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-05 10:23
 */
public class KthSmallest {

    private int res = -1;

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        KthSmallest s = new KthSmallest();
        System.out.println(s.kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        helper(root, new int[]{k});
        return res;
    }

    public void helper(TreeNode root, int[] k) {
        if (root == null) return;
        helper(root.left, k);
        if (k[0] > 0) {
            res = root.val;
            --k[0];
        }
        helper(root.right, k);
    }
}
