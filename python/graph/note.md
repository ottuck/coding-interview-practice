# Graph
1. Vertax(정점)와 edge(간선)로 이뤄진다.
2. Tree 는 Graph 개념안에 속한다고 볼 수 있다.

## 그래프의 종류
1. 방향 그래프(단방향) vs 무향 그래프(양방향, 코테에 가장 많이 등장)
2. 단순 그래프 vs 다중 그래프(한번에 여러 간선 사용)
3. 가중치 그래프, 다익스트라

## 그래프 활용
1. 현실 세계의 사물, 추상적인 개념을 표현하기 좋다보니 코테에 정말 많이 등장한다.
2. 예시 : 지하철 연결 노선도, 컴퓨터 네트워크, 소셜 네트워크 분석

## 그래프의 표현 방법
1. 인접 리스트(adjacency matrix) 
    -> vertax 에 연결된 edge 를 이중 리스트를 사용하여 matrix 로 표현 잘 쓰지 않는다
2. 인접 리스트(adjacency list)
    -> vertax(key) 에 연결된 인접 리스트(배열)를 표현한다(dictianry 사용), 단순하다 보니 자주 사용된다.
3. 암시적 그래프(implicit graph)
    -> 눈으로 보이는 데이터 형태 자체를 복수의 리스트(matrix형태)로 표현한다, 활용하기 좋다보니 제일 자주 사용된다.

### 간선리스트 -> 인접리스트 변환 코드
'''
public class BuildAdjList {

    // edges: 각 원소 [a, b] 는 a -> b 단방향 간선
    public static List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);

        // 0..n-1 각각의 인접 리스트 공간 확보
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가 (directed)
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }

        return graph;
    }

    public static void printGraph(List<List<Integer>> graph) {
        System.out.println("graph = [");
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("  " + i + ": " + graph.get(i) + ",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {2, 0},
                {2, 4},
                {3, 1},
                {4, 0},
                {4, 2},
                {4, 3}
        };

        List<List<Integer>> graph = buildGraph(n, edges);
        printGraph(graph);
    }
}
'''

'''
// 간선리스트 -> HashMap 전환 방식
Map<Integer, List<Integer>> graph = new HashMap<>();
for (int i = 0; i < n; i++) {
    graph.put(i, new ArrayList<>());
}
for (int[] e : edges) {
    graph.get(e[0]).add(e[1]);
}

// 탐색할때
for (int next : graph.get(cur)) { ... }
'''

## DFS, BFS 주요 문제

1. 연결된 영역의 갯수 (주로 BFS를 사용하나, DFS로도 가능)
    * 네트워크 개수
    * 연결 요소의 개수
    * 두 요소간 연결 여부
2. 최단거리 (BFS를 사용하면 가중치가 동일한 경우를 쉽게 찾을 수 있다)
    * 숨바꼭질