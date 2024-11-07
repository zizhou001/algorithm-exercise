package nk;

/**
 * @author zizhou
 * @create 2023-11-25 15:08
 */
public class AlwaysM {
    private int n;
    private int target;
    private int[] numbers;
    private char[] ops;


    AlwaysM(int _n, int _target){
        n = _n;
        target = _target;
        numbers = new int[n];
        ops = new char[n];
        ops[0] = '+';
        for (int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }
    }

    private void output(){
        System.out.print(numbers[0]);
        for (int i = 1; i < n; i++) {
            if (ops[i] != ' ') System.out.print(ops[i]);
            System.out.print(numbers[i]);
        }
        System.out.println("=100");
    }

    /**
     * 获取数组第一个值
     * @return int
     */
    public int getPreValue(){return numbers[0];}

    /**
     * 求解过程
     * @param sum 当前的和
     * @param preValue 上一个加数（将减法看做加法）
     * @param k 当前考虑的符号插入位置
     */
    public void solution(int sum, int preValue, int k){
        if (k == n){
            if (sum == target){
                output();
                return;
            }else return;
        }

        //1.在第k个位置选择 '+',即加上第k+1个元素
        ops[k] = '+';
        sum += numbers[k];

        //继续计算第k+1个位置
        solution(sum, numbers[k],k+1);

        //回溯：重置选择 '+' 之前的状态
        sum -= numbers[k];

        //2.在第k个位置选择 '-'
        ops[k] = '-';
        sum -= numbers[k];

        //继续计算第k+1个位置
        solution(sum, -numbers[k], k+1);

        //回溯：重置选择 '-' 之前的状态
        sum += numbers[k];

        //3.在第k个位置不插入运算符
        ops[k] = ' ';

        //由于本次在两个元素之间不添加运算符+或-，
        //运算值不再是单纯的numbers数组元素，
        //可能因数字顺序组合而产生”组合值“，
        //因此，先减去前一个值，
        //重新计算上一个运算符op和对应的新运算数
        sum -= preValue;
        int temp = 0;

        //计算新的运算数
        if (preValue > 0) temp = preValue * 10 + numbers[k];
        else temp = preValue * 10 - numbers[k];

        sum += temp;

        //继续计算第k+1个位置
        solution(sum, temp, k+1);

        //回溯：重置上一步操作
        sum -= temp;
        sum += preValue;
    }


    public static void main(String[] args) {
        AlwaysM m = new AlwaysM(9, 100);
        m.solution(0, m.getPreValue(), 1);
    }
}
