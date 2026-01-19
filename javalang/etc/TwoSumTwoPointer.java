package javalang.etc;

// 시간 복잡도는 O(n), 정렬이 안되어 있다면 시간복잡도가 O(nlogn)이 된다
public class TwoSumTwoPointer {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;   // 합이 작으면 왼쪽 증가
            } else {
                right--;  // 합이 크면 오른쪽 감소
            }
        }

        return new int[]{-1, -1}; // 문제 조건상 도달 안 함
    }
}