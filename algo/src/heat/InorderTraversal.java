package heat;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 9:17
 */
public class InorderTraversal {

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildBTreeByPreorder(new Integer[]{1, null, 2, 3}, new int[]{0});
        InorderTraversal solution = new InorderTraversal();
        List<Integer> res = solution.inorderTraversalByStack(root);
        res.forEach(System.out::println);
    }




    /**
     * 方法1：使用普通的递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 使用栈
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByStack(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
