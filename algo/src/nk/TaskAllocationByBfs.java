package nk;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

/**
 * 节点结构
 */
final class Enode implements Comparable<Enode>{
    //保存当前 已分配的 任务总花销
    private final int cost;
    //保存当前 已完成的 分配策略
    private final Vector<Integer> alloc = new Vector<>();


    public Enode() {
        alloc.add(0);
        cost = 0;
    }

    public Enode(int cost, Vector<Integer> alloc) {
        this.alloc.clear();
        this.alloc.addAll(alloc);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public Vector<Integer> getAlloc() {
        return (Vector<Integer>) alloc.clone();
    }

    @Override
    public int compareTo(Enode o) {
        return this.cost - o.cost;
    }
}

public class TaskAllocationByBfs {

    //活节点的优先队列
    private Queue<Enode> queue = new PriorityQueue<>();
    //最小话费值
    private int minCost = Integer.MAX_VALUE;
    //任务数量
    private final int N = 4;
    //最优策略
    private Vector<Integer> strategy = new Vector<>();
    //任务分配信息矩阵
    private int[][] c = {
        {0, 0, 0, 0, 0},
        {0, 9, 2, 7, 8},
        {0, 6, 4, 3, 7},
        {0, 5, 8, 1, 8},
        {0, 7, 6, 9, 4}
    };

    public TaskAllocationByBfs(){
        queue.offer(new Enode());
    }


    /**
     * 解决方案（使用优先队列的分支限界法）
     */
    public void solution(){

        while (!queue.isEmpty()){
            // 活节点出队列
            Enode cur_node = queue.poll();
            // 获取活节点的花销和已存在的分配策略
            int cost = cur_node.getCost();
            Vector<Integer> alloc = cur_node.getAlloc();

            int s = alloc.size();
            for (int i = 1; i <= N && s <= N; i++) {
                // 计算扩展子节点后的花销
                int cur_cost = cost + c[s][i];

                Vector<Integer> temp = (Vector<Integer>)alloc.clone();

                // 若当前工作还未分配 并且，
                // 扩展子节点后的花销小于当前最小花销
                if (!alloc.contains(i) && cur_cost < minCost){
                    // 更新分配策略
                    temp.add(i);
                    // 新建节点并入队
                    Enode e = new Enode(cur_cost, temp);
                    queue.offer(e);
                }
            }

            // 若遍历到叶子节点，
            // 比较、更新最小花销值
            if (s > N){
                minCost = cost < minCost ? cost : minCost;
                strategy.clear();
                strategy.addAll(alloc);
            }

        }

        System.out.println("任务分配策略为：");
        for (int i = 1; i <= N; i++) {
            System.out.println("第"+i+
                    "个人执行第"+strategy.get(i)+"号任务");
        }
        System.out.println("最小耗费为：" + minCost);
    }



    public static void main(String[] args) {
        TaskAllocationByBfs t = new TaskAllocationByBfs();
        t.solution();
    }

}
