package heat;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 二叉树的右视图：给定一个二叉树的 根节点 root，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-06 8:16
 */
public class RightSideView {

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{1, 2, 3, null, 5, null, 4});
        RightSideView s = new RightSideView();
        List<Integer> res = s.rightSideView31(root);
        res.forEach(System.out::println);
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView31(TreeNode root){
        dfs(root, 0);
        return res;
    }

    /**
     * 思路3-1：递归深度优先遍历
     * 1. 每次先遍历右子节点
     * 2. 当depth层已经添加过节点后，不在添加节点
     *
     * @param root
     * @param depth
     */
    public void dfs(TreeNode root, int depth){
        if (root == null) return;
        if (depth == res.size()) res.add(root.val);
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

    /**
     * 思路2-1：深度优先
     * 1. 使用map记录每一层记录的节点，确保每一层只记录一个节点，且是右子节点
     * 2. 根据深度max_depth遍历map，获取val
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView21(TreeNode root) {
        HashMap<Integer, Integer> valAtDepth = new HashMap<>();
        int max_depth = 1;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            if (node != null){
                max_depth = Math.max(depth, max_depth);
                if (!valAtDepth.containsKey(depth)){
                    valAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        return IntStream.rangeClosed(0, max_depth)
                .filter(valAtDepth::containsKey)
                .mapToObj(valAtDepth::get)
                .collect(Collectors.toList());
    }

    /**
     * 思路1-2：广度优先
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView12(TreeNode root) {
        HashMap<Integer, Integer> valAtDepth = new HashMap<>();
        int max_depth = 1;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            Integer depth = depthQueue.poll();
            if (node != null){
                max_depth = Math.max(depth, max_depth);
                // 直接更新，最终记录的是最后一次的更新结果（该层最后一个节点）
                valAtDepth.put(depth, node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                // 添加两次，因为是二叉树，每个root右两个孩子
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        return IntStream.rangeClosed(0, max_depth)
                .filter(valAtDepth::containsKey)
                .mapToObj(valAtDepth::get)
                .collect(Collectors.toList());
    }

    /**
     * 思路1-1：广度优先，（执行用时和空间复杂度较高）
     * 1. 得到层序遍历结果
     * @see LevelOrder#levelOrder(TreeNode)
     * 2. 取每个层最后一个元素
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView11(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);
        List<Integer> res = lists.stream()
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(list.size() - 1))
                .collect(Collectors.toList());
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        deque.add(root);
        int nextLayerExpectedNums = 2;
        int curLayerNums = 1;
        while (!deque.isEmpty()) {
            nextLayerExpectedNums = 0;
            int i = 0;
            ArrayList<Integer> midRes = new ArrayList<>();
            while (i < curLayerNums) {
                TreeNode node = deque.poll();
                midRes.add(node.val);
                ++i;
                if (node.left != null) {
                    deque.add(node.left);
                    ++nextLayerExpectedNums;
                }
                if (node.right != null) {
                    deque.add(node.right);
                    ++nextLayerExpectedNums;
                }
            }
            curLayerNums = nextLayerExpectedNums;
            ans.add(midRes);
        }
        return ans;
    }
}
