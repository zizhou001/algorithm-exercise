package nk;

/**
 * @author zizhou
 * @create 2023-11-25 19:55
 */
public class TaskAllocation {
    //价值花费
    private int[][] c;
    //问题的解向量,s[1]=2表示第1个人完成任务2
    private int[] best_s;
    //任务数量
    private int n;
    //最小花费
    private int min_cost = Integer.MAX_VALUE;

    TaskAllocation(int _n){
        c = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 9, 2, 7, 8},
                {0, 6, 4, 3, 7},
                {0, 5, 8, 1, 8},
                {0, 7, 6, 9, 4}
        };
        best_s = new int[]{0,1,2,3,4};
        n = _n;
    }

    /**
     * 交换数组的两个元素
     * @param arr 数组
     * @param index1 索引
     * @param index2 索引
     */
    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    /**
     * 获取当前开销
     * @param s 某种特定解决方案
     * @return 特定解决方案的开销
     */
    public int getCurCost(int[] s){
        int cost = 0;
        for (int i = 1; i <= n; i++) {
            cost += c[i][s[i]];
        }
        return cost;
    }

    public int[] getBestS() {return best_s;}
    public int getMinCost() {return min_cost;}

    /**
     * 解决问题的方法（排列树）
     * @param s 解决方案
     * @param k 层
     */
    public void solution(int[] s, int k){
        if (k >= n) {
            //若发现更小的开销，克隆解决方案并记录最小开销
            int curCost = getCurCost(s);
            if (curCost <= min_cost){
                best_s = s.clone();
                min_cost = curCost;
            }
        }
        else{
            for (int i = k; i <= n; i++) {
                swap(s, k, i);
                solution(s,k+1);
                swap(s, i, k);
            }
        }
    }

    public static void main(String[] args) {
        final int N = 4;
        TaskAllocation t = new TaskAllocation(N);
        t.solution(t.getBestS(), 1);
        for (int i = 1; i <= N; i++) {
            System.out.println("第"+i+
                    "个人执行第"+t.getBestS()[i]+"号任务");
        }
        System.out.println("最小的花销为："+t.getMinCost());
    }
}
