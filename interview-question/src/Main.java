import java.util.Scanner;

/**
 * 一个n行m列的矩阵，求该矩阵有多少个2*2的子矩阵满足1和0的数量相等。
 * 输入：两个整数n和m，空格隔开，接下来的n行输入长度为m的串，来表示矩阵。
 * 输出：一个整数
 * zizhou
 * @create 2024-03-23 10:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j) - '0';
                if (i > 0) matrix[i][j] += matrix[i - 1][j];
                if (j > 0) matrix[i][j] += matrix[i][j - 1];
                if (i > 0 && j > 0) matrix[i][j] -= matrix[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int ones = matrix[i + 1][j + 1];
                if (i > 0) ones -= matrix[i - 1][j + 1];
                if (j > 0) ones -= matrix[i + 1][j - 1];
                if (i > 0 && j > 0) ones += matrix[i - 1][j - 1];
                if (ones == 2) count++;
            }
        }
        System.out.println(count);
    }
}