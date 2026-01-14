package javalang.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// Tip : 시작노드 예약 -> 방문 -> 다음 노드 예약 순으로 이미지화
public class Bfs {

    void solution(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        bfs(0, graph, visited);
    }

    void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        // 시작 노드 예약
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 방문
            System.out.println("visit: " + cur);

            // 다음 노드 예약
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
            그래프 구조 (인접 리스트)
            
            0 -- 1 -- 3
            |    |
            2    4

            graph = [
              [1,2],   // 0
              [0,3,4], // 1
              [0],     // 2
              [1],     // 3
              [1]      // 4
            ]
        */

        List<List<Integer>> graph = new ArrayList<>();

        graph.add(List.of(1, 2));     // 0
        graph.add(List.of(0, 3, 4));  // 1
        graph.add(List.of(0));        // 2
        graph.add(List.of(1));        // 3
        graph.add(List.of(1));        // 4

        Bfs bfs = new Bfs();
        bfs.solution(graph);
    }
}