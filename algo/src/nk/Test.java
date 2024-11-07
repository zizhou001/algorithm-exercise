package nk;

/**
 * @author zizhou
 * @create 2023-11-26 16:57
 */
public class Test {

    private int[][] a;
    private int bestc;
    private int[] bestx;
    private int n;
    private int[] x;
    private final int NO_EDGE = Integer.MAX_VALUE;
    private int cc;


    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void solution(int i){
        //已经到达叶子节点
        if(i == n+1){

            // 若当前节点n是可达的叶节点，
            // 且当前节点到源节点可达，
            // 且当前记录的路径开销更小：
            if( a[x[n-1]][x[n]] != NO_EDGE &&
                a[x[n]][x[1]] != NO_EDGE &&
                (bestc == NO_EDGE ||
                  (cc + a[x[n-1]][x[n]] + a[x[n]][x[1]]) < bestc)){
                for (int j = 1; j <=n; j++)
                    //保存当前最优的路径
                    bestx[j] = x[j];
                //保存当前最优的开销
                bestc = cc + a[x[n-1]][x[n]] + a[x[n]][x[1]];
            }
        }else {
            for (int j = i; j <=n; j++){
                // 判断是否可以进入子树:
                // 若当前节点可达，
                // 且花销更少
                if(a[x[i-1]][x[i]] != NO_EDGE &&
                   (bestc == NO_EDGE || cc + a[x[i-1]][x[i]] < bestc)){
                    swap(x, j, i);
                    cc += a[x[i-1]][x[i]];
                    //递归调用下一层
                    solution(i+1);
                    //回溯
                    cc -= a[x[i-1]][x[i]];
                    swap(x, i, j);
                }
            }
        }
    }
}
