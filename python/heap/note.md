# Priority Queue
정의: 우선순위가 높은 값이 먼저 추출되는 큐

## 구현 방법별 시간복잡도
1. enqueue 때는 바로 삽입, ㅊ 후에 한자리씩 당겨줘야함
    * enqueue : O(1)
    * dequeue : O(n)

2. enqueue 한 후 매번 *정렬*, dequeue 할때는 바로 추출
    * enqueue : O(nlogn)
    * dequeue : O(1)

3. 완전 이진트리를 사용하여 구현, 값을 넣고 뺄때 마다 노드를 swap 해줘야 하는데 이때 시간이 걸린다.(그래도 제일 추천하는 Priority Queue 구현 방법)
    * enqueue : O(logn) 
    * dequeue : O(logn)

## 완전 이진트리란?
1. 마지막 노드 전까지 모든 노드가 채워져 있는 트리
2. Heap 자료구조가 완전 이진 트리다(array 로 표현 가능하다. 점화식)

## min heap, max heap
* min heap: 부모 노드의 값이 자식 노드의 값 보다 *작은* 트리 형태의 자료구조
* max heap: min heap 의 반대다
(형제 노드 간에 대소 관계는 상관 없다, Root node 가 가장크거나 작은 값을 갖는다)

### 파이썬에서는 아래처럼 간단한 사용법을 지원한다.

* 아래 경우 자연스럽게 heap 형태의 자료구조에 저장된다(array 형태의 완전이진트리)

'''
import heapq

#### min heqp
min_heap = [5,3,9,1]
heapq.heapify(min_heap)

heapq.heappop(min_heap)     # min_heap 이기 때문에 1이 나온다
heapq.heappush(min_heap, 1)

#### max heap1
max_heap = [5,3,9,1]
heapq._heapify_max(max_heap)
value = heapq._heapify_max(max_heap)

#### max heqp2
max_heap = [5,3,9,1]
max_heap = [i * -1 for i in max_heqp]   # -1 을 곱하고 heapify를 하면 max heqp 순서가 되기 떄문
heapq.heapify(max_heap)
weight = heqpq.heqppop(max_heqp)
value = -1 * weight

#### max heqp3 (2번 방법 개선)
max_heap = [5,3,9,1]
max_heap = [(-1 * i, i) for i in max_heqp]
heapq.heapify(max_heap)
weight, value = heqpq.heqppop(max_heqp)
'''

# 다익스트라
정의: 가중치 그래프에서 시작점과 도착점이 있을때, 최단 경로(shortest path)를 reutrn 하는 알고리즘
