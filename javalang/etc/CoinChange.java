// LeetCode 322 Coin Change
//
// (중요)그리디 알고리즘을 적용할 수 있어보이지만 각 동전이 배수가 아니기 때문에 적용할 수 없다.
// 이럴때는 우선 그림을 그리든 접근해 보는게 좋다
// 경우의 수를 세다 보면 결국 이 문제는 '완전탐색' 으로 풀릴 문제라는걸 알게된다
// BFS 로 제일 적은 탐색을 했을때의 조합을을 반환하게 하면 될듯(최소, 최단 키워드는 BFS)
// DFS 로 할 경우 DP 로 하는게 좋다
package javalang.etc;

import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        int level = 0; // 사용한 동전 갯수

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int c : coins) {
                    int next = cur + c;
                    // base case
                    if (next == amount) {
                        return level;
                    }
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}


// Dist사용 방식
class BfsDistSoulution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dist = new int[amount + 1];
        Arrays.fill(dist, -1); // 금액으로 나올수 없는 값인 음수로 설정한다

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int c : coins) {
                int next = cur + c;
                if (next > amount) continue;

                if (dist[next] == -1) { // 처음 방문(초기값 -1로 판단)
                    dist[next] = dist[cur] + 1;

                    if (next == amount) {
                        return dist[next];
                    }

                    q.offer(next);
                }
            }
        }
        return -1;
    }
}

//DP 풀이
// 점화식: 금액 x를 만들기 위해 동전 c 하나를 마지막으로 사용했다고 가정하면, 그 직전 금액(x-c) 를 만드는 최소 동전 개수 +1 이다.
class DpSolution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int INF = amount + 1; // 나올 수 없는 동전의 개수
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x = 1; x <= amount; x++) {
            for (int c : coins) {
                // base case
                if (x - c >= 0) {
                    dp[x] = Math.min(dp[x], dp[x - c] + 1);
                }
            }
        }

        if (dp[amount] == INF) return -1; // 한번도 갱신되지 않았다면

        return dp[amount];
    }
}
