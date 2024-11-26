package heat100;

import utils.BTreeUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 要点：
 * 1. 使用队列记录要扩展的节点
 * 2. 使用nextExpectedPollNodeNums记录下一次要出队列节点的数量，
 *  每当当前节点有左子，+1； 存在右子，+1
 * 3. 使用curExpectedPollNodeNums 记录本次要出队列节点的数量，
 *  每当poll一次，--i，直到出队列到指定数量
 * 4. 本层计算完后，令curExpectedPollNodeNums = nextExpectedPollNodeNums，并将nextExpectedPollNodeNums置零重新计数
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-04 17:09
 */
public class LevelOrder {

    public static void main(String[] args) {
        BTreeUtils utils = new BTreeUtils();
        TreeNode root = utils.buildTreeByLevel(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        lists.stream()
                .map(list -> list.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextExpectedPollNodeNums = 0;
        int curExpectedPollNodeNums = 1;
        while (!queue.isEmpty()) {
            List<Integer> midRes = new ArrayList<>();
            int i = 0;
            nextExpectedPollNodeNums = 0;
            while (i < curExpectedPollNodeNums) {
                TreeNode node = queue.poll();
                if (node != null) {
                    midRes.add(node.val);
                    ++i;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    ++nextExpectedPollNodeNums;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++nextExpectedPollNodeNums;
                }
            }
            res.add(midRes);
            curExpectedPollNodeNums = nextExpectedPollNodeNums;
        }
        return res;
    }
}
