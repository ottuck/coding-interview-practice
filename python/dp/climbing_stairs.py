# 문제 계단을 올라가고 있다. 계단의 꼭대기에 올라가려면 n개의 steps 만큼 올라가야 한다. 한번에 올라갈때 1step or 2steps 로 올라갈 수 있다. 꼭대기에 도달하는 방법의 개수는 총 몇 가지 일까?

# 제약 조건: 1 <= n <= 45

# input: n=2, output: 2
# 나올 수 있는 스텝의 조합
# 1. 1 + 1
# 2. 2

# input: n = 3, output: 3
# 나올 수 있는 스텝의 조합
# 1. 1 + 1 + 1
# 2. 1 + 2
# 3. 2 + 1

# 풀이 : 이 문제에서 마지막 원하는 계단에 오기위한 경우의 수는 사실 마지막 계단(n)과 이전 두 계단 (n-1, n-2)의 경우밖에 없다. 이 케이스 점화식으로 사용하여 재귀로 최종 답을 구해 볼 수 있다.(subproblem 으로 나누고 해결)

memo = {}
def cs(n):
    # base case
    if n == 1:
        return 1
    if n == 2:
        return 2
    
    if n not in memo:
        # recurrence relation
        memo[n] = cs[n - 1] + cs[n - 2]

    return memo[n]


# input: n = 5
# output: 8