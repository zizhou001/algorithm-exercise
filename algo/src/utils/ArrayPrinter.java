package utils;

import java.util.Arrays;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-10-29 9:03
 */
public class ArrayPrinter {

    public static void main(String[] args) {
        print1DArray(new int[]{1,2,3,4});
    }

    public static void print1DArray(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void print2DArray(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
