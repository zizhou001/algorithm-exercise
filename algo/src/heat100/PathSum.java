package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-06 14:16
 */
public class PathSum {


    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        PathSum s = new PathSum();
        System.out.println(s.pathSum1(root, 8));
    }

    int res = 0;
    Map<Long, Integer> nodePreSumNums = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        preorder(root, 0, targetSum);
        return res;
    }

    public void preorder(TreeNode root, long curPreSum, int targetSum){
        if (root == null) return;
        curPreSum += root.val;
        if (curPreSum == targetSum) res++;
        // 查找已有的满足条件的路径和
        res += nodePreSumNums.getOrDefault(curPreSum - targetSum, 0);
        // 保存当前节点路径和
        nodePreSumNums.put(curPreSum, nodePreSumNums.getOrDefault(curPreSum, 0) + 1);
        // 遍历左右子树
        preorder(root.left, curPreSum, targetSum);
        preorder(root.right, curPreSum, targetSum);
        // 当前节点的路径和，已经在左右子树中使用完毕，减去，以免后续错误计数
        nodePreSumNums.put(curPreSum, nodePreSumNums.get(curPreSum) - 1);
    }

    /**
     * 穷举法：
     * 1. 计算某个节点node，从root到leaf的路径上，有多少组路径和满足targetSum
     * 2. 计算所有node
     * 但是这种方法，执行比较耗时。存在很多重复计算。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = rootSum(root, targetSum);
        res += pathSum1(root.left, targetSum);
        res += pathSum1(root.right, targetSum);
        return res;
    }

    /**
     * 计算某个节点node，从root到leaf的路径上，有多少组路径和满足targetSum
     * 例如，对于节点10，其一条到达叶子节点的路径为 10 > 5 > 2 > 1
     * 则需要在迭代过程中判断路径：
     *  10 ： 10
     *  10 > 5: 10+5
     *  10 > 5 > 2 : 10+5+2
     *  10 > 5 > 2 > 1: 10+5+2+1
     * 同理。。。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int rootSum(TreeNode root, long targetSum) {
        int ans = 0;
        if (root == null) return 0;
        int rootVal = root.val;
        if (rootVal == targetSum) ans++;
        ans += rootSum(root.left, targetSum - rootVal);
        ans += rootSum(root.right, targetSum - rootVal);
        return ans;
    }
}
