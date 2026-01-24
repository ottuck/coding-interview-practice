//BackJoon 14502. laboratory
// 문제: 0(통로),1(벽),2(바이러스) 를 표현한 grid 배열이 주어진다. 2라는 바이러스가 인접한 칸 상하좌우로 퍼지고 있다. 벽 3개를 세워 바이러스를 최대한 효율적으로 차단했을때의 안전지대 영역(0)이 얼마인지 구하라.
// 제약조건: N,M: 3~8개, 바이러스 수: 2~10개, 빈칸 수: 3개 이상
// 접근: 모든 방식으로 벽을 3개 세운다(조합) -> 그 과정마다 바이러스가 퍼트리며 0의 개수를 샌다(BFS) -> 남아있는 0의 개수를 샌다
package javalang.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14502_Laboratory {
    static int N, M;
    static int[][] board;

    static final List<int[]> empties = new ArrayList<>();
    static final List<int[]> viruses = new ArrayList<>();

    // 4방향 (상하좌우)
    static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        // 입력 및 빈 칸, 바이러스 위치 저장
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] == 0) empties.add(new int[]{r, c});
                else if (board[r][c] == 2) viruses.add(new int[]{r, c});
            }
        }

        // 빈 칸 중 3개 선택 (조합)
        selectWalls(0, 0, new int[3][2]);
        System.out.println(answer);
    }

    // 조합으로 벽 3개 선택
    static void selectWalls(int start, int count, int[][] walls) {
        if (count == 3) {
            // 벽 설치
            for (int[] w : walls) board[w[0]][w[1]] = 1;

            // 바이러스 확산 후 안전 영역 계산
            answer = Math.max(answer, bfs());

            // 벽 원상복구
            for (int[] w : walls) board[w[0]][w[1]] = 0;

            return;
        }

        for (int i = start; i < empties.size(); i++) {
            int[] e = empties.get(i);
            walls[count][0] = e[0];
            walls[count][1] = e[1];

            selectWalls(i + 1, count + 1, walls);
        }
    }

    static int bfs() {
        // board 복사 (벽은 설치된 상태)
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) tmp[i] = board[i].clone();

        // multi-source BFS: 모든 바이러스에서 시작
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] v : viruses) q.offer(new int[]{v[0], v[1]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (tmp[nr][nc] != 0) continue; // 빈칸(0)만 감염

                tmp[nr][nc] = 2;
                q.offer(new int[]{nr, nc});
            }
        }

        // 안전 영역(0) 카운트
        int safe = 0;
        for (int[] row : tmp) {
            for (int cell : row) {
                if (cell == 0) safe++;
            }
        }
        return safe;
    }
}