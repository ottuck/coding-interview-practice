from collections import deque

# 외우기!
def bfs(root):
    visited = [] # 방문 노드 기록용
    if root is None:
        return 0;
    q = deque()
    q.append(root)

    while q:
        cur_node = q.popleft() # 하나씩 꺼내서 현재 노드로 저장
        visited.append(cur_node.value)

        if cur_node.left:
            q.append(cur_node.left)
        if cur_node.right:
            q.append(cur_node.right)
    return visited