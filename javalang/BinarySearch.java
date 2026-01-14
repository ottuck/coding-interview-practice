package javalang;

// 절반씩 나눠계산하는 선형탐색의 한종류(완전탐색은 아니다)
// '정렬'을 해야한다는 전제 조건이 있다
// 시간복잡도는 O(logn) 이다
// BinarySearch 는 주로 문제해결을 위한 '수단'으로만 활용되기에 코드 템플렛을 외워두는 편이 낫다

// LeetCode 704 Binary Search
// 반복문 구현
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return -1; // 타겟이 배열에 없는 경우
    }
}

// 재귀 구현
class BinarySearchRecursion {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length -1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1; // 타겟이 배열에 없는 경우
        }
        
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }
}