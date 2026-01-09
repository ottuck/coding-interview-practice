# 순열 문제: nums = [1,2,3,4]로 만들 수 있는 모든 '순열'을 반환하시오.
nums = [1,2,3,4]

def permuttation(nums):
    def backtrack(curr):
        if len(curr) == len(nums): # base case
            answer.append(curr[:])
            return

        for num in nums: # base case에 해당하지 않는 경우
            # 아래 3줄이 키 포인트
            if num not in curr: # 이미 지나간 노드는 여기서 걸러진다
                curr.append(num)
                backtrack(curr) # 트리 구조를 따라 내려가며 반복(재귀)작업
                curr.pop() # 1,2,3,4 를 차례대로 작업하게 하는 역할
    answer = []
    backtrack([])
    return answer


# 조합 문제: nums = [1,2,3,4] 에서 두 개의 원소를 선택해서 만들 수 있는 모든 '조합'을 반환하시오.
def combination(k):
    ans = []

    def bk(start, curr):
        if len(curr) == k: # k만큼 차면 reult 에 curr 값을 복사해서 넣어주는 base case
            ans.append(curr[:])
            return

        for i in range(0, len(nums)):
            curr.append(nums[i])
            bk(i + 1, curr) # 자기 자신은 제외하고 백트래킹하기 위해 i+1
            curr.pop()

    bk(start = 0, curr = [])
    return ans

combination(nums, k = 2) # k 는 2개의 원소


# 조합 문제: nums = [1,2,3,4]로 만들 수 있는 '부분집합'을 반환하시오.
# 팁: 조합 문제 처럼 '몇개의 원소'(k)로 조합할수 있는지만 파악하면 되기 때문에 조합문제 코드와 상당히 비슷해진다.
def subset():
    result = []

    def backtracking(start, curr):
        if len(curr) == k: # k만큼 차면 reult 에 curr 값을 복사해서 넣어주는 base case
            result.append(curr[:])
            return

        for i in range(0, len(nums)):
            curr.append(nums[i])
            backtracking(i + 1, curr) # 자기 자신은 제외하고 백트래킹하기 위해 i+1
            curr.pop()
    
    for k in range(len(nums) + 1):
        backtracking(start = 0, curr = [])
    
    return result

print(subset(nums = [1,2,3,4]))