package heat100;

import java.util.HashSet;

/**
 * 关键点：
 *  1. 放入set，去重
 *  2. 遍历数组一次
 *  3. 迭代寻找对于当前数字curNum， contains(curNum+1)？？
 *     并且记录长度
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-22 9:51
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] nums){


        HashSet<Integer> set = new HashSet<>();
        int longestLen = 0;
        for (int num : nums) set.add(num);
        for (int num : nums){
            if (!set.contains(num - 1)){
                int curNum = num;
                int curLen = 1;

                while (set.contains(curNum + 1)){
                    curNum += 1;
                    curLen += 1;
                }
                longestLen = Math.max(longestLen, curLen);
            }
        }
        return longestLen;
    }
}
