# Recursion(재귀)

1. 정의: 자신을 정의하면서 자신을 재참조한다
2. 트리, 그래프, 이진탐색, 백트래킹이 필요할때 응용됨 (주로 binary tree 로 사용됨)
3. 트리를 구현할지 아는지 묻는문제, 트리 순회문제 두가지 유형으로 나눠짐

## 예시
fun factorial(n):
    in f == 1:
        return 1
    renturn n * facotrial(n-1)

fun fibo(n):
    if n == 1 or 2:
        return 1
    return fibo(n-1) + fibo(n-2)

## Recursion의 두가지 구성요서
1. recereence relation : 점화식
    -> f(n) 을 f(n-1), f(n-2), f(2), f(1) 등으로 표현하는 것

2. base case
    -> 재귀가 더이상 일어나지 않도록 리턴하도록 하는 조건식(없다면 무한루프가 발생한다)

## 시간복잡도
1.  O(N)
 -> recereence relation : f(n) = f(n-1) * n 

2. O(2^n) : 함수 하나를 호출하면 n개의 함수가 호출 되는 경우
 -> recereence relation : f(n) = f(n-1) + f(n-2)

3. O(logN)
 -> Binary Search


# Tree
1. 트리구조의 각 부위 명칭 기억하기
2. 트리 순회: 전위, 중간, 후위 순회 기억하기
3. BFS(큐 사용), DFS(재귀 구현) 코드 외우기!!