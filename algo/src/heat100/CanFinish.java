package heat100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-08 9:07
 */
public class CanFinish {

    /**
     * 0:未访问
     * 1：正在访问
     * 2：访问结束
     */
    int[] visited;
    /**
     * 存储由某个节点出发，存在的所有边
     */
    List<List<Integer>> edges;
    /**
     * 是否存在环路（能读完所有课程），默认不存在
     */
    boolean valid = true;

    public static void main(String[] args) {
        CanFinish s = new CanFinish();
        int[][] prerequisites = {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};
        int numCourses = prerequisites.length;
        System.out.println(s.canFinish(numCourses, prerequisites));
    }

    /**
     * 深度优先搜索
     * 1. 将每门课程看成一个节点，若课程1的先修课程为2，则存在一条边 2-->1
     * 2. 初始化：
     *  1) 记录每一个节点存在的边，例如，对于节点5，是两个节点的前序节点，即：5-->2, 5-->4，存储为 5:{2,4}
     *  2) 使用visited记录每个节点的访问情况
     * 3. 对于每一个visited[i]==0（未访问的节点u）,进行深度优先搜索：
     *  1）visited[u]=1,表示正在访问中
     *  2）对于与u相连的每个节点v，对未访问的节点进行递归搜索，
     *      若某个节点状态是1，表明该节点是当前节点的前序节点，如此，产生环路，valid=false
     *  3）搜索完u后，将其标记为搜索完毕,visited[u]=2;
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(i, new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    int[] indeg;

    public boolean canFinish2(int numCourses, int[][] prerequisites){
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
