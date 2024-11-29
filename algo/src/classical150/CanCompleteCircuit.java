package classical150;

import java.util.Arrays;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2024-11-29 15:02
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {
        CanCompleteCircuit s = new CanCompleteCircuit();
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(s.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0;
            while (cnt < n){
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfGas < sumOfCost){
                    break;
                }else {
                    ++cnt;
                }
            }
            if (cnt == n){
                return i;
            }else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
