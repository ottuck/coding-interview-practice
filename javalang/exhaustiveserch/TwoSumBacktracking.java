package javalang.exhaustiveserch;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBacktracking {

    static int[] nums;
    static int target;
    static List<Integer> picked = new ArrayList<>();

     public static int[] solution(int[] input, int target) {
        nums = input;
        backtracking(0);
        return new int[]{picked.get(0), picked.get(1)};
    }

    private static boolean backtracking(int start) {
        // base case: 두 개를 골랐을 때
        if (picked.size() == 2) {
            int sum = nums[picked.get(0)] + nums[picked.get(1)];
            return sum == target;
        }
        for (int i = start; i < nums.length; i++) {
            picked.add(i);
            if (backtracking(i + 1)) return true;
            picked.remove(picked.size() - 1); // backtrack
        }
        return false;
    }

    // ----------------------------------------
    public static void main(String[] args) {
        int[] res = solution(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res[0] + ", " + res[1]); // 0, 1
    }
}

/**
// 백트랙 패턴 외워두기
boolean backtracking(...) {
    if (정답) return true;
    for (...) {
        if (backtracking(...)) return true;
    }
    return false;
}
*/