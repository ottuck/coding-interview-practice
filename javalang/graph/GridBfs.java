package javalang.graph;

import java.util.ArrayDeque;
import java.util.Queue;

// 암시적 그래프에서의 탐색
public class GridBfs {
    int[][] grid;
    boolean[][] visited;
    int row, col;

    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public void bfs(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int i = 0; i < cur.length; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (nextRow > 0 && nextRow < row &&
                    nextCol > 0 && nextCol < col &&
                    !visited[nextRow][nextCol] &&
                    grid[nextRow][nextCol] == 1);
            }
        }
    }
    public void solve(int[][] inputGrid){
        grid = inputGrid;
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];

        // start point
        if (grid[0][0] == 1) {
            bfs(0, 0);
        }
    }
}
