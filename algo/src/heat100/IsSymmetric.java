package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.ArrayList;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 14:57
 */
public class IsSymmetric {

    ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{5,4,1,null,1,null,4,2,null,2,null});
        System.out.println(new IsSymmetric().isSymmetric(root));
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
}
