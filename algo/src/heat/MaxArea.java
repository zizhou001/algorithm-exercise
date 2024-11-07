package heat;

/**
 * 关键点：
 *  1. 最大值要遍历完所有情况
 *  2. left，right两个指针
 *  3. left，right谁更小，移动谁（寻求更高的高度）
 *
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-23 14:01
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        // int[] height = {1, 2, 1};
        System.out.println(solution(height));

    }

    public static int solution(int[] height) {
        int left = 0, right = height.length - 1;
        int area = Math.min(height[left], height[right]) * (right - left);

        while (left < right){
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return area;
    }
}
