package utils;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-23 17:27
 */
public class BarChart {
    private int[] heights;

    public BarChart(int[] heights) {
        this.heights = heights;
    }

    public void draw() {
        int maxHeight = getMaxHeight(heights);

        for (int i = maxHeight; i > 0; i--) {
            for (int height : heights) {
                if (height >= i) {
                    System.out.print("█ "); // 用方框表示
                } else {
                    System.out.print("  "); // 空白表示
                }
            }
            System.out.println();
        }
        for (int i = 0; i < heights.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int getMaxHeight(int[] heights) {
        int max = heights[0];
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        BarChart barChart = new BarChart(heights);
        barChart.draw(); // 绘制柱状图
    }
}


