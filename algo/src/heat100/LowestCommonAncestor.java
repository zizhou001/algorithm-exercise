package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-06 17:06
 */
public class LowestCommonAncestor {

    Map<TreeNode, TreeNode> fatherMap = new HashMap<>();

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});

        LowestCommonAncestor s = new LowestCommonAncestor();
        System.out.println(s.lowestCommonAncestor2(root, root.left, root.left.right.right).val);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        return find(root, p, q);
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode l = find(root.left, p, q);
        TreeNode r = find(root.right, p, q);
        // 左子树和右子树都非空，说明在左子树和右子树中都找到p和q，则root为最近公共祖先
        if (l != null && r != null) return root;
        // 若左子树为null（未找到目标节点）则说明目标节点在右子树中
        return l == null ? r : l;
    }

    /**
     * 1. 使用 HashMap 结合preorder记录每个节点的父节点
     * 2. 迭代访问p的各个父节点，直到root，使用 HashMap（visited） 记录p访问过的父节点
     * 3. 对于q，访问所有父节点，检查是否已经存在于visited中
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        markFather(root, null);
        TreeNode pf = p, qf = q;
        HashSet<TreeNode> visited = new HashSet<>();
        while (pf != null){
            visited.add(pf);
            pf = fatherMap.get(pf);
        }
        while (qf != null){
            if (visited.contains(qf)) return qf;
            qf = fatherMap.get(qf);
        }
        return null;
    }

    public void markFather(TreeNode root, TreeNode father) {
        if (root == null) return;
        fatherMap.put(root, father);
        markFather(root.left, root);
        markFather(root.right, root);
    }
}
