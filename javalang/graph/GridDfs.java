package javalang.graph;

// 굉장히 심플해 보이는 패턴이니,
class GridDfs {
    int[][] grid;
    boolean[][] visited;
    int rows, cols;

    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < rows &&
                 nc >= 0 && nc < cols &&
                  !visited[nr][nc] &&
                   grid[nr][nc] == 1)
                dfs(nr, nc);
        }
    }

    public void solve(int[][] inputGrid) {
        grid = inputGrid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        if (grid[0][0] == 1) {
            dfs(0, 0);
        }
    }
}

// 좀더 암기 쉬운 버전?
// visited[r][c] = true;
// for (4방향) {
//     if (범위 밖) continue;
//     if (이미 방문) continue;
//     if (갈 수 없음) continue;
//     dfs(...)
// }

// 노드: (r, c)
// 간선: dr/dc
// 조건: grid[nr][nc] == 1