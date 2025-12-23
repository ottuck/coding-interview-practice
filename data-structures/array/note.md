# Python Array

파이썬의 제공하는 list 자료형은 linkedList 로 제공되며, linkedList 는 Dyanamic array 로 구현되어 있다.

## 배열의 특성
1. 고정된 저장공간(fixed-size, static array일 경우)
2. 순차적인 저장공간(random access 가능)

#### Random acceess (Direct access)
배열의 메모리 주소(0번째 인덱스값이 저장된 메모리주소)만 알면 나머지 인덱스의 주소값도 유추 가능하며 바로 접근이 가능하기 때문에 **array 의 시간복잡도는 O(1)** 이다. 
반면 **linked list 는 이렇게 주소를 알수 없기 떄문에 O(n)의 시간 복잡도** 를 갖는다.

### Danamic Array
처음 할당한 고정 배열 크기 보다 더 저장해야할 경우. 2배 더 큰 배열을 새로 선언한 후(doubling) 기존 기존 배열의 값을 복사, 이후 값을 추가하게 된다.
따라서 처음 할당 크기 안에 저장 가능한 값일 경우 시간복잡도는 O(1), 배열을 resizing 해야 한다면 시간복잡도는 O(n)이 된다. -> 하지만 '분할상한기법' 에 의해 이 경우도 O(1) 시간복잡도라 말할 수 있다.

## 배열 적용 팁
1. 반복문
2. Sort & Two Pointer

### 예시
TwoSum 문제단순히 반복문을 두번쓰면 n2 시간복잡도지만 