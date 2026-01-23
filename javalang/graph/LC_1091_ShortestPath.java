// LeetCode 1091. Shortest Path in Binary Matrix
// '최단'경로라는 키워드가 있기 때문에 BFS로 먼저 접근한다.
// 8방향 탐색 필요
package javalang.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC_1091_ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {
            {-1,-1}, {0,-1}, {1,-1},
            {-1,0},           {1,0},
            {-1,1},  {0,1},  {1,1}
        };

        // 시작,끝 칸이 막혀있다면 시작 불가
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1}); // 길이는 방문한 칸수라서 1로 시작

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            if (r == m - 1 && c == n - 1) return d;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && 
                    grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }

        return -1;
    }
}
