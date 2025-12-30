# 문제: 정렬되지 않은 정수형 배열이 주어질 때 만들 수 있는 가장 긴 연속된 수의 갯수를 반환하라
# 제약 조건1: 0 <= nums.length <= 10**5      -> O(n**2) 보다 빠른 풀이가 필요
# 제약 조건2: -10**9 <= nums[i] <= 10**9     -> java 같은 python 이외의 언어에서 int 로 선언해도 괜찮다는 힌트
#
# input: [0,3,7,2,5,8,4,6,0,1]
# output: 9 (가장 긴 연속된 수: [0,1,2,3,4,5,6,7,8])

def longestConsecutive(nums):
    longest = 0
    num_dict = {}

    for num in nums:
        num_dict[num] = True

    # 연속 수열의 시작점(num - 1)만 탐색
    for num in num_dict:
        if num - 1 not in num_dict: 
            # 이 분기가 없다면 O(n2), 있다면 O(n)이 된다
            cnt = 1
            cur = num + 1

            while cur in num_dict:
                cnt += 1
                cur += 1

            longest = max(longest, cnt) # 파이썬에서 자주쓰는 update 패턴

    return longest

# Set Version
def longestConsecutive(nums):
    s = set(nums)
    longest = 0

    for num in s:
        if num - 1 not in s:
            cnt = 1
            x = num + 1
            while x in s:
                x += 1
                cnt += 1
            longest = max(longest, cnt)

    return longest