package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.HashMap;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-06 9:38
 */
public class BuildTreeByPreorderAndInorder {

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        utils.printByLevelOrder(new BuildTreeByPreorderAndInorder().buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}));
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pLen = preorder.length;
        int iLen = inorder.length;
        if (pLen == 1 && iLen == 1) return new TreeNode(preorder[0]);
        for (int i = 0; i < iLen; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, pLen - 1, 0, iLen - 1);
    }

    /**
     * 递归构建
     * 1. 前序集合中的结构为 [ root, {left_subtree}, {right_subtree} ]
     * 2. 中序集合中的结构为 [ {left_subtree}, root, {right_subtree} ]
     * 3. 递归出口：preorder_start_idx > preorder_end_idx
     * 4. 先构建root，根据root.val 找到 inorder中的root_inorder_idx
     * 5. 根据四个索引，将两个集合分为左子树和右子树
     * 6. 递归构建左子树和右子树
     *
     * @param preorder  前序遍历集合
     * @param inorder   中序遍历集合
     * @param preorder_start_idx 前序遍历集合中子树元素值的起始索引
     * @param preorder_end_idx  前序遍历集合中子树元素值的结束索引
     * @param inorder_start_idx 中序遍历集合中子树元素值的起始索引
     * @param inorder_end_idx   中序遍历集合中子树元素值的结束索引
     * @return 构建好的root
     */
    public TreeNode build(int[] preorder, int[] inorder, int preorder_start_idx, int preorder_end_idx,
                          int inorder_start_idx,
                          int inorder_end_idx) {
        if (preorder_start_idx > preorder_end_idx) {
            return null;
        }
        int preorder_root_idx = preorder_start_idx;
        int inorder_root_idx = map.get(preorder[preorder_root_idx]);
        TreeNode root = new TreeNode(preorder[preorder_root_idx]);
        int nums_in_left_subtree = inorder_root_idx - inorder_start_idx;
        root.left = build(preorder, inorder,
                preorder_start_idx + 1, preorder_start_idx + nums_in_left_subtree,
                inorder_start_idx, inorder_root_idx - 1);
        root.right = build(preorder, inorder,
                preorder_start_idx + nums_in_left_subtree + 1, preorder_end_idx,
                inorder_root_idx + 1, inorder_end_idx);
        return root;
    }
}
