// LeetCode 79 WordSearch
package jav.exhaustive_serch;

public class WordSearch {

    private int n; // row
    private int m; // coloms
    private char[][] board;
    private String word;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.n = board.length;
        this.m = board[0].length;
        this.visited = new boolean[n][m];

        // 모든 칸을 시작점으로 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtracking(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(int i, int j, int w) {
        // 범위 & 방문 & 문자 불일치 체크
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(w)) return false;

        // 단어 끝까지 매칭 성공
        if (w == word.length() - 1) return true;

        visited[i][j] = true;

        // 상하좌우 탐색
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] d : dirs) {
            if (backtracking(i + d[0], j + d[1], w + 1)) {
                visited[i][j] = false;
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

    // main (로컬 실행용)
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(solution.exist(board, "ABCCED")); // true
        System.out.println(solution.exist(board, "SEE"));    // true
        System.out.println(solution.exist(board, "ABCB"));   // false
    }
}

/**
// 깔끔해 보이는 코드 (외워두기)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int idx, char[][] board, String word) {
        if( idx == word.length()) return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx)) return false;

        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs( r + 1, c, idx + 1, board, word) ||
                        dfs( r, c + 1, idx + 1, board, word) ||
                        dfs( r - 1, c, idx + 1, board, word) ||
                        dfs( r, c - 1, idx + 1, board, word);
        board[r][c] = temp;

        return found;
    }
}
*/