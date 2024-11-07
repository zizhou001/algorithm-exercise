package nk;

/**
 * @author zizhou
 * @create 2023-11-24 9:41
 */
public class HamiltonianCircuit {

    //初始化解数组
    private int[] x = {0, 0, 1, 2, 3, 4};
    private int n = 5;

    //记录顶点之间的关系
    private int[][] g = {
            {1, 1, 1, 1, 1},
            {1, 1, -1, 1, 1},
            {1, -1, 1, -1, 1},
            {1, 1, -1, 1, 1},
            {-1, 1, 1, 1, 1}
    };

    //输出解的函数
    public void showPath() {
        int start = 0;
        int end = 0;
        for (int i = 1; i <= n; i++) {
            start = x[i];
            end = i == n ? x[1] : x[i+1];
            System.out.print("(" + start + "," + end + ")");
        }
        System.out.println();
    }

    //用于交换数组中两个对应索引位置的值
    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //求解哈密顿回路的函数
    public void hamilton(int k) {
        //判断是否到达最后一层，且最后一个节点可以到达出发的节点
        if (k > n && g[x[k - 1]][x[1]] == 1) showPath();
        else {
            for (int i = k; i <= n; i++) {
                swap(x, k, i);
                if (g[x[k - 1]][x[k]] == 1) hamilton(k + 1);
                swap(x, i, k);
            }
        }
    }

    public static void main(String[] args) {
        HamiltonianCircuit h = new HamiltonianCircuit();
        h.hamilton(1);
    }
}
