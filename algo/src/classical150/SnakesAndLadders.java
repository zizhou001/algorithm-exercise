package classical150;

import java.util.*;

/**
 * @author zizhou
 * @version 1.0.0
 * @date 2025-01-15 14:34
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        SnakesAndLadders s = new SnakesAndLadders();
        int ans = s.snakesAndLadders(board);
        System.out.println("============================================");
        System.out.println("ans = " + ans);
    }

    public int snakesAndLadders(int[][] board) {

        final int N = board.length;
        boolean[] visited = new boolean[N * N + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int nextPos = cur[0] + i;
                if(nextPos > N * N) {
                    break;
                }
                int[] rc = id2rc(nextPos, N);
                if(board[rc[0]][rc[1]] > 0){
                    nextPos = board[rc[0]][rc[1]];
                }
                if(nextPos == N * N){
                    return cur[1] + 1;
                }
                if(!visited[nextPos]){
                    visited[nextPos] = true;
                    queue.offer(new int[]{nextPos, cur[1] + 1});
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n){
        int r = (id - 1) / n, c = (id - 1) % n;
        if(r % 2 == 1){
            c = n - c - 1;
        }
        return new int[]{n - 1 - r, c};
    }
}

