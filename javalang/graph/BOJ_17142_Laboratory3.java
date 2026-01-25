// 접근: 바이러스를 퍼뜨리는 '최소'시간을 구하는 문제이기 때문에 BFS 접근을 생각해보자
// 맵 입력 받을때 바이러스 위치를 따로 저장해둔다
package javalang.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17142_Laboratory3 {
    static int N, M;
    static int[][] lab;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static int emptyCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                lab[r][c] = Integer.parseInt(st.nextToken());
                if (lab[r][c] == 2) viruses.add(new int[]{r, c});
                else if (lab[r][c] == 0) emptyCount++;
            }
        }

        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }

        int answer = choose(0, 0, new ArrayList<>(), Integer.MAX_VALUE);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 바이러스 M개 조합 선택
    static int choose(int start, int chosen, ArrayList<int[]> active, int best) {
        if (chosen == M) {
            int time = bfs(active);
            return Math.min(best, time);
        }

        for (int i = start; i < viruses.size(); i++) {
            active.add(viruses.get(i));
            best = choose(i + 1, chosen + 1, active, best);
            active.remove(active.size() - 1);
        }
        return best;
    }

    // multi-source BFS
    static int bfs(ArrayList<int[]> active) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new ArrayDeque<>();

        // 선택된 바이러스들을 동시에 시작점으로
        for (int[] v : active) {
            dist[v[0]][v[1]] = 0;
            q.offer(new int[]{v[0], v[1]});
        }

        int infected = 0;
        int maxTime = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (lab[nr][nc] == 1) continue;      // 벽
                if (dist[nr][nc] != -1) continue;   // 방문됨

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});

                // 빈 칸만 감염 카운트 + 시간 갱신
                if (lab[nr][nc] == 0) {
                    infected++;
                    maxTime = dist[nr][nc];
                    if (infected == emptyCount) return maxTime;
                }
            }
        }

        return Integer.MAX_VALUE; // 모든 빈 칸을 감염시키지 못함
    }
}
