package javalang.exhaustiveserch;

import java.util.Arrays;

public class MSumDfs {

    public static boolean solution(int[] nums, int target, int m) {
        return dfs(nums, target, m, 0, 0, 0);
    }

    // start: 다음에 고를 수 있는 시작 인덱스(중복 방지)
    // sum: 현재까지 선택한 값의 합
    // depth: 지금까지 몇 개 골랐는지
    private static boolean dfs(int[] nums, int target, int m, int start, int sum, int depth) {
        // base case: m개를 다 골랐으면 합이 target인지 확인
        if (depth == m) {
            return sum == target;
        }

        for (int i = start; i < nums.length; i++) {
            if (dfs(nums, target, m, i + 1, sum + nums[i], depth + 1)) {
                return true;
            }
        }

        return false;
    }

    // ----------------------------------------
    public static void main(String[] args) {
        int[] nums = {4, 9, 7, 5, 1};
        int target = 15;
        int m = 3;

        boolean ok = solution(nums, target, m);
        System.out.println("nums=" + Arrays.toString(nums) + ", target=" + target + ", m=" + m);
        System.out.println("exists? " + ok); // 기대: true (예: 9+5+1=15)
    }
}