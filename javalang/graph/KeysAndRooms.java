// LeetCode 841 Keys and Rooms
package javalang.graph;

import java.util.*;


public class KeysAndRooms {
    // BFS
    public boolean bfsSolution(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : rooms.get(cur)) { // 연결된 노드를 다음 방문지로 큐에 예약
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        // 정말 모든 vertex 를 방문했나 확인(false 가 있으면 방문 못한거)
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    //DFS
    public boolean dfsSolution(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int cur, List<List<Integer>> rooms, boolean[] visited) {
        visited[cur] = true;
        for (int next : rooms.get(cur)) {
            if (!visited[next]) {
                dfs(next, rooms, visited);
            }
        }
    }
}

