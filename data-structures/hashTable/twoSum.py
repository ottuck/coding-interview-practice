# HashTable 을 활용한다.
# 같은 원소를 두번 사용할 수는 없다.

# 오답
def towSum1(nums, target):
    memo = {} 
    for v in nums: # index 만 쓰고 value 값은 쓰지 않지만 임의로 아무값이나 채워준다
        memo[v] = 1 # 이렇게 먼저 저장하면 자기 자신을 사용하기 때문에 오답이다.
    for v in nums:
        needed_number = target - v
        if needed_number in memo:
            return True
        return False

# 정답
def towSum2(nums, target):
    memo = {}
    for i, v in enumerate(nums):
        if target - v in memo:
            return True
        memo[v] = i # 자기 자신을 쓰지 않기 위해 검사부터 한 후 나중에 저장한다
    return False

