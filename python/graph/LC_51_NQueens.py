from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []

        # 상태 배열
        cols = [False] * n
        diag1 = [False] * (2 * n)  # row + col
        diag2 = [False] * (2 * n)  # row - col + n - 1

        # 결과 표현용 보드
        board = [['.'] * n for _ in range(n)]

        def dfs(row: int):
            # 종료 조건
            if row == n:
                result.append([''.join(r) for r in board])
                return

            for col in range(n):
                d1 = row + col
                d2 = row - col + n - 1

                if cols[col] or diag1[d1] or diag2[d2]:
                    continue

                # place
                board[row][col] = 'Q'
                cols[col] = diag1[d1] = diag2[d2] = True

                dfs(row + 1)

                # undo
                board[row][col] = '.'
                cols[col] = diag1[d1] = diag2[d2] = False

        dfs(0)
        return result