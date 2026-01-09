# 문제: 리스트 [4,9,7,5,1] 에서 두 개의 숫자를 더해서 12이 될 수 있나요? (중복x)

def solution(nums, target):
    def backtrack(start, curr):
        # sum 부분에서 두 수를 합하는 중
        if len(curr) == 2 and sum(nums[i] for i in curr) == target :
            return
        
        for i in range(start, len(nums)):
            curr.append(i)
            ret = backtrack(i + 1, curr)
            if ret: 
                return ret # 반환값이 있을때
            curr.pop()

        return None # 아무것도 찾지 못 했을때
    return backtrack(0, [])


print(solution(nums = [4,9,7,5,1], target = 12))