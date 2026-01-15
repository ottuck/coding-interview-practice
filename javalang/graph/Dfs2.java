package javalang.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// HashMap 버전
public class Dfs2 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void dfs(int curVertex) {
        visited.put(curVertex, true); // 방문 처리
        System.out.println("visit: " + curVertex);

        // 인접 노드 탐색
        for (int nextVertex : graph.get(curVertex)) {
            if (!visited.containsKey(nextVertex)) {
                dfs(nextVertex); // 깊이 우선 탐색
            }
        }
    }

    // ----------------------------------------
    public static void main(String[] args) {
        graph.put(0, List.of(1, 3, 6));
        graph.put(1, List.of(0, 3));
        graph.put(2, List.of(3));
        graph.put(3, List.of(0, 1, 2, 7));
        graph.put(4, List.of(5));
        graph.put(5, List.of(4, 6, 7));
        graph.put(6, List.of(0, 5));
        graph.put(7, List.of(3, 5));

        dfs(0); // 시작 정점
    }
}