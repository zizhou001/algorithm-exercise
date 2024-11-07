package heat;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-25 9:25
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {-6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7};
        int k = 7;
        int[] res = maxSlidingWindow3(nums, k);
        System.out.println("================================================");
        for (int e : res) System.out.print(e + " ");
    }


    /**
     * 使用双端队列
     * 1. 双端队列中存放idx
     * 2. 循环比较：
     * 1）若队列左端idx已经失效，从左边出队列
     * 2）若当前值nums[i] > 队列右端值idx对应的值nums[idx]，将这些值从右边出队列
     * 3）将当前值加入队列中
     * 4）判断并记录结果，结果来自于队列左端。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();

            deque.offerLast(i);

            if (i >= k - 1) ans[idx++] = nums[deque.peekFirst()];

        }

        return ans;
    }


    /**
     * 使用优先队列
     * 优先队列中结构为：(val, idx)
     * 1.定义优先队列（特别是排序规则）
     * 2.初始化优先队列，加入前 k个元素的元组，并初始化ans[0]
     * 3.循环向优先队列中放值，并且去除失效的(val,idx)，将最大值放入结果集ans
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {

        if (k == 1) return nums;
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        ans[0] = pq.peek()[0];

        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) pq.poll();
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    /**
     * 超出时间限制  37/51
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {

        int n = nums.length;

        if (n == 1) return new int[]{nums[0]};
        if (k == 1) return nums;

        int[] res = new int[n - k + 1];
        int[] midRes = new int[n];

        System.out.println(n);
        show(nums, 0);

        System.arraycopy(nums, 0, midRes, 0, n);

        for (int j = 2; j <= k; j++) {
            for (int i = 0; i < n - j + 1; i++) {
                midRes[i] = Math.max(midRes[i], nums[i + j - 1]);
            }
            show(midRes, j);
        }

        System.arraycopy(midRes, 0, res, 0, n - k + 1);

        return res;
    }

    public static void show(int[] nums, int msg) {
        System.out.print(msg + ": ");
        for (int e : nums) {
            System.out.print(e + "\t");
        }
        System.out.println();
    }
}
