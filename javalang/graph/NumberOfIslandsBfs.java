// LeetCode 200. Number of Islands
package javalang.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslandsBfs {
    char[][] grid;
    int m, n;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        m = grid.length; // rows
        n = grid[0].length; //cols
        visited = new boolean[m][n];
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    bfs(r, c);
                }
            }
        }
        return count;
    }

    public void bfs(int sr, int sc) {
         Queue<int[]> q = new ArrayDeque<>();
         q.offer(new int[]{sr, sc});
         visited[sr][sc] = true;

         while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] == '1' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
         }

    }
}
