// LeetCode 1 TwoSum
// 문제: nums 배열에서 두 수의 합이 target이 되는 인덱스 반환
//
// input: {2, 7, 11, 15}
// output: 9

package jav.ps.pending;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSumHashMap {

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer j = indexByValue.get(target - nums[i]);
            if (j != null) {
                return new int[]{j, i};
            }
            indexByValue.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = solution(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result)); // [0, 1]
    }
}