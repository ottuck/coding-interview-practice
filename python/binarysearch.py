# 분할정복 방식의 이진 탐색 알고리즘
# 전제조건이 정렬이기 때문에 O(logN) 의 시간복잡도를 갖는다.
# python 에서는 bisect 라이브러리로 간단하게 쓸 수 있도록 제공한다

from bisect import bisect_left

# LeetCode 704 Binary Search
# 반복문 구현
def binary_search(self, nums, target):
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2   # // 연산자를 사용해야 한다
        if nums[mid] == target:
            return mid
        elif target < nums[mid]:
            left = mid + 1
        else:
            rright = mid - 1

    return - 1 # 타겟이 배열에 없는 경우

# 재귀 구현
def search(self, nums, target):
    def bin_search(left, right):
        if left > right:
            return -1 # 타겟이 없는 경우
        
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            return bin_search(mid + 1, right)
        else:
            return bin_search(left, mid - 1)

    return bin_search(0, len(nums) - 1)


# bisect library 사용예
class Solution:
    def search(self, nums, target):
        index = bisect_left(nums, target)
        if index != len(nums) and nums[index] == target:
            return index
        return -1 # 타겟이 배열에 없는 경우


nums = [2, 6, 9, 15, 20, 50, 58, 67, 82]
nums.sort()
print("Sorted List : {nums}")
