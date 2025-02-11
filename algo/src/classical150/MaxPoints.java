package classical150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-11 11:14
 */
public class MaxPoints {

    public static void main(String[] args) {
        MaxPoints s = new MaxPoints();
        int[][] points = {{1, 0}, {0, 0}};
        System.out.println(s.maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;

        for (int i = 0; i < n; i++) {

            // 1. 枚举到i点时，最多只能找到n-i个点共线，若结果ret已经ret >= n - i 结束
            // 2. 若一条直线经过了图中超过半数的点，那么ret就是答案
            if (ret >= n - i || ret > n / 2){
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < n; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0){
                    y = 1;
                }else if (y == 0){
                    x = 1;
                } else{
                    // 规定分母不为负数
                    if (y < 0){
                        x = -x;
                        y = -y;
                    }
                    // 最大公约数
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    // 化简表示斜率的分数
                    x /= gcdXY;
                    y /= gcdXY;
                }
                // 浮点数无法精确表示斜率
                int key = y + x * 200001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getValue();
                // num+1表示需要加上当前考虑的点i
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b){
        return b != 0 ? gcd(b, a % b) : a;
    }
}
