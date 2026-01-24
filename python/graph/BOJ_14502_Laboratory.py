import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

empties = []
viruses = []

for r in range(N):
    for c in range(M):
        if board[r][c] == 0:
            empties.append((r, c))
        elif board[r][c] == 2:
            viruses.append((r, c))

# 4방향
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs_after_walls():
    # board 복사 (벽이 설치된 상태에서 시뮬레이션)
    tmp = [row[:] for row in board]

    q = deque(viruses)  # multi-source BFS

    while q:
        r, c = q.popleft()
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < N and 0 <= nc < M and tmp[nr][nc] == 0:
                tmp[nr][nc] = 2
                q.append((nr, nc))

    # 안전영역(0) 카운트
    safe = 0
    for r in range(N):
        for c in range(M):
            if tmp[r][c] == 0:
                safe += 1
    return safe

answer = 0

# 빈 칸 중 3개 조합 선택
for walls in combinations(empties, 3):
    # 벽 설치
    for r, c in walls:
        board[r][c] = 1

    # 시뮬레이션
    answer = max(answer, bfs_after_walls())

    # 벽 원복
    for r, c in walls:
        board[r][c] = 0

print(answer)