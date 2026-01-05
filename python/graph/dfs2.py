# 이해를 위해 전역변수를 사용하여 단순화
graph = {...}
visited = []

def dfs(cur_v):
    visited.append[cur_v]:
    for v in graph[cur_v]:
        if v not in visited:
            dfs(v)

# dfs('A')