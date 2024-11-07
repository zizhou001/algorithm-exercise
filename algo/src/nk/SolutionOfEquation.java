package nk;

/**
 * @author zizhou
 * @create 2023-11-25 19:31
 */
public class SolutionOfEquation {
    private int[] values;
    private int n;

    SolutionOfEquation(int _n) {
        values = new int[]{1, 2, 3, 4, 5};
        n = _n;
    }

    /**
     * 输出问题解的方法
     */
    private void output() {
        System.out.println(
                values[0] + "*" + values[1] + "-"
                        + values[2] + "*" + values[3]
                        + "-" + values[4] + "=1"
        );
    }

    /**
     * 判断某个向量是否是问题的解
     * @param a 向量
     * @return 是问题的解返回True，反之返回False
     */
    public boolean solved(int[] a) {
        return a[0] * a[1] - a[2] * a[3] - a[4] == 1;
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
     * 问题解决函数（全排列）
     * @param k 当前层数
     */
    public void solution(int k) {

        //如果到达排列数最后一层，判断是否是问题的解
        if (k >= n) {
            if (solved(values)) output();
            else return;
        }

        for (int i = k; i < n; i++) {
            swap(values, k, i);
            solution(k + 1);
            swap(values, i, k);
        }
    }


    public static void main(String[] args) {
        SolutionOfEquation s= new SolutionOfEquation(5);
        s.solution(0);
    }
}
