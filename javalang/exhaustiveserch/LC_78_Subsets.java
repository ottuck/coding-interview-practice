// LeetCode 78 Seubsets
package javalang.exhaustiveserch;

import java.util.ArrayList;
import java.util.List;

// subset 에서는 모든 경우의 수가 필요하니까 모든 path 를 결과에 저장
// 따라서 정답판별용 base case 는 없다고 볼수 있다. 단순하게 조합 코드에서 basecase 를 제거하고 모든 조합을 모아서 return 해준다.
public class LC_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, nums, path, result);
            path.remove(path.size() - 1);
        }
    }

    // ----------------------------------------
    public static void main(String[] args) {
        LC_78_Subsets subsets = new LC_78_Subsets();

        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);

        System.out.println(result);
    }
}

/**
Permutation / Combination / Subset  비교
 • Permutation: “각 위치에 무엇을 둘까?” → used[]
 • Combination: “k개만 고르기” → start + base case size==k
 • Subset: “고를지 말지 전부” → start + 매 호출마다 결과 추가
 */