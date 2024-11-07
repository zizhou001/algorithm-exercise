package utils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 10:51
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
        this.val = null;
    }
}
