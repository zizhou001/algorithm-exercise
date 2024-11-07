package heat;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-05 9:16
 */
public class IsValidBST {



    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{0});
        IsValidBST s = new IsValidBST();
        System.out.println(s.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 设计一个上界和下界，判断当前节点值是否在(lower,upper)中。
     * 查找root左子树时，上界是root.val
     * 查找root右子树时，下界是root.val
     *
     * @param root 当前节点
     * @param lower 下界
     * @param upper 上界
     * @return
     */
    public boolean isValidBST(TreeNode root, Long lower, Long upper){
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValidBST(root.left, lower, Long.valueOf(root.val)) &&
                isValidBST(root.right, Long.valueOf(root.val), upper);
    }


    /**
     * 使用中序遍历
     * 但是空间复杂度较高
     */
    Deque<Double> stack = new LinkedList<>();
    boolean res = true;
    public boolean isValidBST1(TreeNode root) {
        stack.push(-Double.MAX_VALUE);
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (stack.peek() >= root.val) {
            res = false;
            return;
        }else stack.push(Double.valueOf(root.val));
        inorder(root.right);
    }
}
