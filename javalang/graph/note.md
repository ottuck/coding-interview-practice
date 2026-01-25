# 백트래킹 기본 탬플렛

## 배열 기반 상태 + board

// 상태 배열 (문제에 맞게 정의)
boolean[] state1;
boolean[] state2;

// 결과 표현 (선택)
char[][] board;

void dfs(int depth) {
if (depth == LIMIT) {
saveResult();
return;
}

    for (int choice : candidates(depth)) {
        if (!isValid(depth, choice)) continue;

        apply(depth, choice);
        dfs(depth + 1);
        undo(depth, choice);
    }

}

### 적용 예제

'''
public class LC_51_NQueens {
private int n;
private List<List<String>> result = new ArrayList<>();

    // 상태 배열 (O(1) 체크)
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    // 결과 표현용 보드
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;

        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        dfs(0);
        return result;
    }

    // ===== 일반 백트래킹 템플릿 =====
    private void dfs(int row) {
        if (row == n) {
            saveResult();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) continue;

            apply(row, col);
            dfs(row + 1);
            undo(row, col);
        }
    }

    // ===== 템플릿 구성요소 분리 =====
    private boolean isValid(int row, int col) {
        int d1 = row + col;
        int d2 = row - col + n - 1;
        return !cols[col] && !diag1[d1] && !diag2[d2];
    }

    private void apply(int row, int col) {
        int d1 = row + col;
        int d2 = row - col + n - 1;

        board[row][col] = 'Q';
        cols[col] = diag1[d1] = diag2[d2] = true;
    }

    private void undo(int row, int col) {
        int d1 = row + col;
        int d2 = row - col + n - 1;

        board[row][col] = '.';
        cols[col] = diag1[d1] = diag2[d2] = false;
    }

    private void saveResult() {
        List<String> one = new ArrayList<>();
        for (char[] r : board) {
            one.add(new String(r));
        }
        result.add(one);
    }

}
'''
