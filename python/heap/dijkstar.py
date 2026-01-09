# 전형적인 shortest path 문제
# 코드 동작
# 1. 우선순위큐에 시작노드 추가
# 2. 우선순위가 가장 높은 노드 추출
# 3. 방문여부 확인
#   3-1. 비용 업데이트
#   3-2. 현재 노드와 연결된 노드를 우선순위 큐에 추가
# 4. 목적지에 기록된 비용 반환

import heapq

def dikstra(graph, start, final):
    costs = {}
    pq = []
    heapq.heqppush(pq, (0, start)) #1

    while pq:
        cur_cost, cur_v = heapq.heappop(pq) #2
        if cur_v not in costs: #3
            costs[cur_v] = cur_cost #3-1
            for cost, next_v in graph[cur_v]: #3-2
                next_cost = cur_cost + cost
                heapq.heappush(pq, (next_cost, next_v))
    return costs[final] #4

graph = {...} # 그래프 정의는 생략
dikstra(graph, 1, 8) # 호출