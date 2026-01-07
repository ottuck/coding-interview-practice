# 문제: n x n binary matirx 인 grid 가 주어졌을때, 출발지에서 목적지까지 가는 가장 빠른경로의 길이를 반환하시오. 만약 경로가 없다면 -1을 반환하시오.

# 출발지: top-left-cell
# 목적지: bottom-right-cell
# 값이 0인 cell만 지나갈 수 있다.
# cell 끼리는 8가지 방향으로 연결되어 있다.(edge와 corner 방향으로 총 8가지)

# 제약조건: 
# n == grid.length
# n == grid[i].length
# 1 <= n <= 100
# grid[i][j] is 0 or 1

from collections import deque

def shortestPathBinaryMatrix(grid):
    shortest_path_len = -1
    row = len(grid)
    col = len(grid[0])

    if grid[0][0] != 0 or grid[row-1][col-1] != 0:
        return shortest_path_len

    visited = [[False] * col for _ in range(row)]

    delta = [
        (1, 0), (-1, 0), (0, 1), (0, -1),
        (1, 1), (1, -1), (-1, 1), (-1, -1)
    ]

    queue = deque()
    queue.append((0, 0, 1))
    visited[0][0] = True

    while queue:
        cur_r, cur_c, cur_len = queue.popleft()
        # 목적지에 도착했을 때의 cur_lenㅇ을 shortest_path_len 에 저자한다
        if cur_r == row - 1 and cur_c == col -1: # 이게 목적지 위치
            shortest_path_len = cur_len
            break

        # 연결된 vertex 확인하기
        for dr,dc in delta:
            next_r = cur_r + dr
            next_c = cur_c + dc
            if next_r >= 0 and next_r < row and next_c >= 0 and next_c <col:
                if grid[next_r][next_c] == 0 and not visited[next_r][next_c]:
                    queue.append((next_r, next_c, cur_len + 1))
                    visited[next_r][next_c] = True

    return shortest_path_len

# input
grid = [[0, 0, 1], [1, 1, 0], [1, 1, 0]]
print(shortestPathBinaryMatrix(grid))