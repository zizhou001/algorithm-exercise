package classical150;

import heat100.SolveNQueens;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-02-05 16:22
 */
public class TotalNQueens {

    Set<Integer> columns = new HashSet<>();
    Set<Integer> primary = new HashSet<>();
    Set<Integer> secondary = new HashSet<>();

    public int totalNQueens(int n) {
        return backtrack(n, 0);
    }

    /**
     * 要点1：判断某个位置是否能放置
     * - 行：每一次放置后，直接跳到下一行，避免同行放置
     * - 列：使用变量columns（Set）记录已经放置的列号
     * - 主对角线：使用变量primary（Set）记录已经放置的主对角线编号
     * -- 对于某条主对角线，改线上的所有方格的row-col相同
     * - 副对角线：使用变量secondary（Set）记录已经放置的副对角线编号
     * -- 对于某条副对角线，该线上的所有方格的row+col相同
     *
     * @see SolveNQueens 普通n皇后问题
     * @param n
     * @param row
     * @return
     */
    public int backtrack(int n, int row){
        if(row == n){
            return 1;
        }else{
            int count = 0;
            for(int i = 0; i < n; i++){
                // not put
                if(columns.contains(i)){
                    continue;
                }
                int p = row - i;
                if(primary.contains(p)){
                    continue;
                }
                int s = row + i;
                if(secondary.contains(s)){
                    continue;
                }

                // put
                columns.add(i);
                primary.add(p);
                secondary.add(s);
                count += backtrack(n, row + 1);
                secondary.remove(s);
                primary.remove(p);
                columns.remove(i);
            }
            return count;
        }
    }
}
