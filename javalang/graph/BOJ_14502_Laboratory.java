//BackJoon 14502. laboratory
// 문제: 0(통로),1(벽),2(바이러스) 를 표현한 grid 배열이 주어진다. 2라는 바이러스가 인접한 칸 상하좌우로 퍼지고 있다. 벽 3개를 세워 바이러스를 최대한 효율적으로 차단했을때의 안전지대 영역(0)이 얼마인지 구하라.
// 제약조건: N,M: 3~8개, 바이러스 수: 2~10개, 빈칸 수: 3개 이상
// 접근: 모든 방식으로 벽을 3개 세운다(조합) -> 그 과정마다 바이러스가 퍼트리며 0의 개수를 샌다(BFS) -> 남아있는 0의 개수를 샌다
package javalang.graph;

import java.io.*;
import java.util.*;

public class BOJ_14502_Laboratory {
    static int N, M;
    static int[][] lab;

    static ArrayList<int[]> empties = new ArrayList<>();
    static ArrayList<int[]> viruses = new ArrayList<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());
                if (lab[r][c] == 0) empties.add(new int[]{r, c});
                else if (lab[r][c] == 2) viruses.add(new int[]{r, c});
            }
        }

        chooseWalls(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    // 빈 칸 중 3개 선택 (조합)
    static void chooseWalls(int start, int chosen, ArrayList<int[]> walls) {
        if (chosen == 3) {
            // 벽 설치
            for (int[] w : walls) 
                lab[w[0]][w[1]] = 1;

            // 바이러스 확산
            answer = Math.max(answer, bfs());

            // 벽 원복
            for (int[] w : walls) 
                lab[w[0]][w[1]] = 0;

            return;
        }

        for (int i = start; i < empties.size(); i++) {
            walls.add(empties.get(i));
            chooseWalls(i + 1, chosen + 1, walls);
            walls.remove(walls.size() - 1);
        }
    }

    static int bfs() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) tmp[i] = lab[i].clone();

        Queue<int[]> q = new ArrayDeque<>();

        // multi-source BFS: 모든 바이러스에서 시작
        for (int[] v : viruses) {
            q.offer(new int[]{v[0], v[1]});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (tmp[nr][nc] != 0) continue;

                tmp[nr][nc] = 2;
                q.offer(new int[]{nr, nc});
            }
        }

        // 안전 영역 계산
        int safe = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (tmp[r][c] == 0) safe++;
            }
        }
        return safe;
    }
}