package javalang.graph;

import java.util.*;

public class LC_51_NQueens {
    int n;
    char[][] board;
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        dfs(0);
        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            List<String> one = new ArrayList<>();
            for (char[] r : board) {
                one.add(new String(r));
            }
            result.add(one);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1; // 음수를 피하기 위해 n-1 을 해줘야 한다

            if (cols[col] || diag1[d1] || diag2[d2]) continue;
            // place
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            dfs(row + 1);
            // undo
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}