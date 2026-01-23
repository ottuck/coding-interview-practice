// LeetCode 200. Number of Islands
package javalang.graph;

class NumberOfIslandsDfs {
    int m, n;
    boolean[][] visited;
    char[][] grid;
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    dfs(r, c);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < dc.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            if (grid[nr][nc] == '1' && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}

// Java에서 DFS는 StackcOverFlow가 날수 있기 때문에 고려해 봐야한다. 
// 실행속도는 BFS 와 비슷하다.