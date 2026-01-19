# State Space Tree (상태 공간 트리)

상태: 특정순간의 상황을 정의하는 모든 정보의 집합.
**재귀 함수에서는 '매개변수'들이 이 사애를 의미한다**

구성 :

1. 상태(State, Node)
2. 상태 전이(Edge)
3. 초기 상태(Root Node)
4. 최종 상태()

## 예제

### 상태

여기서는 start, seleted
start: 다음 탐색을 시작할 배열의 인덱스
seleted: 현재까지 선택된 숫자들의 목록

```
dfs(int[] nums, int target, int start, List<Integer> seleted)
```

### 상태 전이

전이 할때는 다음에 사용할때를 대비해서 원상복귀 시켜야한다.

```
selected.add(num[i])
dfs(nums, target, m, i + 1, seleted)
selected.remove(seleted.size() - 1) // 원복
```

### 초기 상태

dfs 를 호출하는곳에서 넣어주는 초기 상태. 여기서는 0, new ArrayList<>()

```
boolean solution(int[] nums, int target, int m) {
    return dfs(nums, target, m, 0, new ArrayList<>());
}
```

### 최종상태

재귀함수에서는 주로 base case

```
if (selected.size == m) {
    return sum == target;
}
```

# 코드 작성 팁

(자바 강의 상태공간트리 영상 다시보기)

1. 초기 상태(호출부)
2. 최종상태(base case)
3. 상태전이(패턴 코드)
4. 최종 반환 값(base case 밑에 작성, 전역변수를 활용하는것도 포인트)

## 예제

m개의 요소의 합이 target 이 되면 true 반환하기

```
public class MSum {

    // 초기 상태
    boolean solution(int[] nums, int target, int m){
        return dfs(nums, target, m, 0, 0, 0)
    }

    /**
     * 상태 전이
     * start: 현재 노드
     * sum: 노드를 저장하기보다는 합계를 사용
     * depth: 현재 깊이
    */
    boolean dfs(int[] nums, int target, int m, int start, int sum, int depth) {
        if(depth == m) {
            return sum == target;
        }
        for (int i = start; i < nums.length; i++) {
            if(dfs(nums, target, m, i + 1, sum + nums[i], depth + 1)){
                return true;
            }
        }
        return false;
    }
}
```

# 탐욕법(Greddy algorithme)

아래 두가지 조건이 만족하지 않으면 탐욕 알고리즘은 최적해를 구하지 못한다.
(근사해까지는 구할 수 있으나 정확한 답이 필요한 코딩테스트에서는 의미가 없다)

1.  탐욕스런 선택조건: 앞의 선택이 이후의 선택에 영향을 주지 않는다.
2.  최적 부분 구조 조건: 문제에 대한 최적해가 부분문제에 대해서도 역시 최적해이다.
    이러한 문제가 어떤 문제인지는 경험적으로 밖에 알 수 없다.(즉 문제은행식으로 많은 문제를 풀어서 적용가능한 문제를 알아야 한다는 뜻이다)

## 문제 예시

- 거스름돈 문제 -> 큰 동전을 먼저 선택하는 것이 각 단계에서 최적의 선택이고(각 단계에서의 '최적해'란 말, 최적 부분 구조조건), 또한 가능한 한 가장 큰 단위의 동전을 사용한 선택이 이후 선택에 영향을 주지 않는다.(탐욕스런 선택조건)

* 단 거스름돈은 배수라는 제약조건이 있어야한다.(50원, 100원, 500원, 1000원)
