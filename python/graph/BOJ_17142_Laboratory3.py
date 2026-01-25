import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(N)]

viruses = []
empty_count = 0

for r in range(N):
    for c in range(N):
        if lab[r][c] == 2:
            viruses.append((r, c))
        elif lab[r][c] == 0:
            empty_count += 1

# 빈 칸이 없으면 이미 완료
if empty_count == 0:
    print(0)
    sys.exit()

directions = [(-1,0), (1,0), (0,-1), (0,1)]
INF = 10**9 # 절대 나올 수 없는 큰 값으로 설정
answer = INF


def bfs(active):
    """
    active: 선택된 M개의 바이러스 좌표 리스트
    return: 모든 빈 칸을 감염시키는 데 걸리는 최소 시간
            불가능하면 INF
    """
    dist = [[-1]*N for _ in range(N)]
    q = deque()

    # multi-source BFS 시작점
    for r, c in active:
        dist[r][c] = 0
        q.append((r, c))

    infected = 0
    max_time = 0

    while q:
        r, c = q.popleft()

        for dr, dc in directions:
            nr, nc = r + dr, c + dc

            if 0 <= nr < N and 0 <= nc < N:
                if lab[nr][nc] != 1 and dist[nr][nc] == -1:
                    dist[nr][nc] = dist[r][c] + 1
                    q.append((nr, nc))

                    # 빈 칸만 감염 카운트 + 시간 갱신
                    if lab[nr][nc] == 0:
                        infected += 1
                        max_time = dist[nr][nc]

                        # 모든 빈 칸 감염 완료
                        if infected == empty_count:
                            return max_time

    return INF


# 바이러스 중 M개 선택 (active 방식)
for active in combinations(viruses, M):
    answer = min(answer, bfs(active))

print(answer if answer != INF else -1)