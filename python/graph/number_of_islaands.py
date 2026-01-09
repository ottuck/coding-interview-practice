# 문제 : gird 는 "1"(land) 과 "0"(water) 로 이뤄진 지도를 표현하는 m x n 이차원 배열이다. 이 지도에 표시된 섬들의 총 갯수를 반환해라.
# 섬이란 수평과 수직으로 땅이 연결되어 있고 주변은 물로 둘러쌓여있는 것을 말한다. 또한 grid의 네 가장자리는 모두 물러 둘서 쌓여 있다고 가정하고 문제를 해결해라.

# 제약조건
# m == grid.length
# n == grid[i].length
# 1 <= m,n <= 300      -> 총 90000개의 데이터가 저장될수 있음
# gird[i][j] is '0' or '1'

from collections import deque

def numIslands(grid):
    number_of_islands = 0
    row = len(grid)
    col = len(grid[0])
    visited = [[False] * col for _ in range(row)]

    def bfs(x, y):
        dx = [0, 0, -1, 1]
        dy = [-1, 1, 0, 0]
        visited[x][y] = True
        queue = deque()
        queue.append((x,y))

        while queue:
            cur_x, cur_y = queue.popleft()
            for i in range(4):
                next_x = cur_x + dx[i]
                next_y = cur_y + dy[i]
                
                if next_x >= 0 and next_x < row and next_y >= 0 and next_y < col:
                    if grid[next_x][next_y] == "1" and not visited[next_x][next_y]:
                        visited[next_x][next_y] = True
                        queue.append((next_x, next_y))

    for i in range(row):
        for j in range(col):
            if grid[i][j] == "1" and not visited[i][j]:
                bfs(i,j)
                # dfs()
                number_of_islands += 1
        
    return number_of_islands

print(numIslands(grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"],
    ["0","0","0","1","1"],
]))