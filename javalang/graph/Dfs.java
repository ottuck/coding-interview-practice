package javalang.graph;

import java.util.ArrayList;
import java.util.List;

// Tip : 방문 -> 다음 노드로 재귀 진입 -> 돌아오며 종료
public class Dfs {

    void solution(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        dfs(0, graph, visited);
    }

    void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        visited[cur] = true; // 방문
        System.out.println("visit: " + cur);

        // 다음 노드로 깊게 탐색
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        /*
            그래프 구조

            0
          / | \
         3  1  6
        / \
       2   7
            \
             5
             |
             4

            인접 리스트 표현
        */

        List<List<Integer>> graph = new ArrayList<>();

        graph.add(List.of(1, 3, 6)); // 0
        graph.add(List.of(0, 3));    // 1
        graph.add(List.of(3));       // 2
        graph.add(List.of(0, 1, 2, 7)); // 3
        graph.add(List.of(5));       // 4
        graph.add(List.of(4, 6, 7)); // 5
        graph.add(List.of(0, 5));    // 6
        graph.add(List.of(3, 5));    // 7

        Dfs dfs = new Dfs();
        dfs.solution(graph);
    }
}