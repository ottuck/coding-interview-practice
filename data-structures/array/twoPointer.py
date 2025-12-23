# twoSum 문제 twoPointer 풀이
# 시간복잡도: nLogn
# 정렬 후 배열의 가운데 숫자에서 포인터가 만날때까지 left pointer(가장 작은수), right pointer(가장 큰수)를 조건에 따라 가운데로 전진시키며 합한다. 
# 조건은 합이 원하는 수보다 큰가? 작은가? 이다. 같다면 Ture, 가운데까지 진행했는데 원한느 합이 없다면 False

def twoPointer(nums, target):
    nums.sort()
    l, r = 0, len(nums) - 1
    while l<r:
        if nums[l] < nums[r]: r -= 1
        elif nums[l] > nums[r]: l += 1
        else: return True
    return False

# test
print(twoPointer(nums=[4,1,9,7,5,3,6], target=14))
