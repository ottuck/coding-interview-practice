package javalang.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// HashMap 버전
public class Bfs2 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex); // 시작 노드 예약
        visited.put(startVertex, true); // 의미없는 true를 넣기 싫다면 Set으로 생성

        while (!queue.isEmpty()) {
            int curVertex = queue.poll(); // 방문
            System.out.println("visit: " + curVertex);

            for (int nextVertex : graph.get(curVertex)) { // 인접 노드 확인
                if (!visited.containsKey(nextVertex)) {
                    queue.offer(nextVertex); // 다음 노드 예약
                    visited.put(nextVertex, true);
                }
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

        bfs(0); // 시작 정점
    }
}

// 최단경로 문제 등 grid 탐색 문제 풀이의 기본이고, 코테에서 굉장히 많이 나오기 때문에  때문에 체화 해두는게 중요하다 