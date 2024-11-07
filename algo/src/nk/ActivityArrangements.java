package nk;

/**
 * @author zizhou
 * @create 2023-11-24 9:07
 */
public class ActivityArrangements {

    //贪心选择算法
    public static void GreedySelector(int[] b, int[] e, boolean[] s){
        //默认从第一个活动开始
        s[0] = true;
        //用于记录上一个活动的序号
        int j = 0;
        for (int i = 1; i < b.length; i++) {
            //当前活动在上一个活动结束后可以开始，
            //则当前活动可以安排执行
            if(b[i] >= e[j]){
                s[i] = true;
                j = i;
            }else{
                s[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        //开始时间节点
        int[] b = {1, 2, 4, 6};
        //结束时间节点
        int[] e = {3, 5, 8, 10};
        //计数器，用于计算可安排的活动数量
        int count = 0;
        //记录可安排活动的向量
        boolean[] s = new boolean[b.length];
        //调用贪心选择算法
        GreedySelector(b, e, s);
        //输出结果
        System.out.print("可安排的活动编号为：");
        for (int i = 0; i < s.length; i++) {
            if(s[i]){
                ++count;
                System.out.print(i+1 + " ");
            }
        }
        System.out.println("\n最多可安排的活动数为："+count);
    }
}
