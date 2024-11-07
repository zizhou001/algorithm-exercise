package nk;

/**
 * @author zizhou
 * @create 2023-11-09 17:08
 */
public class SearchIn2DArray {

    public static boolean searchNumber(int target, int arr[][]){
        boolean found = false;

        int col = arr[0].length - 1;
        int row = 0;

        while (col >=0 && row >= 0){
            if(target == arr[row][col]){
                found = true;
                break;
            }else if (target < arr[row][col])
                --col;
            else
                ++row;
        }

        return found;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1,2,8,9},
                {2,4,9,2},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(searchNumber(10, arr));
    }
}
