// LeetCode 77 Combination
package jav.ps.pending;

import java.util.ArrayList;
import java.util.List;

class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result
    ) {
        // base case: k개를 뽑았으면 완료
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // start부터 n까지 탐색
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination solution = new Combination();
        List<List<Integer>> result = solution.combine(4, 2);

        System.out.println(result);
    }
}