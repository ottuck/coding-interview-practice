# Queue(Deque)
1. 주요 특징은 FIFO(first in first out)
2. Python 에서는 Deque 로 구현되어 있다.(앞 뒤 연결 노드 메모리 주소를 저장하고 있다), ex) queue = deque()
3. Queue 는 ArrayList 로도 구현 가능 하지만 이렇게 하면 장점이 없기 때문에 
LinkedList 로 구현한다. -> 추가 설명: array list 를 쓸 경우 push, pop 할때 시간복잡도가 O(n) 이 되기 떄문
4. BFS(너비우선탐색) 을 사용해야하는 문제를 풀때 주로 쓰인다.

# Stack
1. 주요 특징은 LIFO(last in first out)
2. array list 로 구현하기 떄문에 Python 에서는 단순히 배열선언만 하면 쓸 수 있다. ex) stack = []
