# 피보나치 수열 문제를 재귀로 풀 경우 시간복잡도는 O(2n^2)이지만 
# memoization 을 적용하면 O(n)으로 바뀐다

# top down 방식
memo = {}
def fibo(n):
    if n == 1 or n == 2:
        return 1
    
    if n not in memo:
        memo[n] = fibo(n - 1) + fibo(n - 2)
    
    # bottom up 방식
    # for i in range(3, n + 1)
    #     memo[i] = memo[i - 1] + memo[i - 2]

    return memo[n]