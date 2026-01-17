# List
정의: 크기가 고정된 배열(Array)과 달리 동적배열(ArrayList, Dynamic Array)로 구현된 자료구조

## 기본 지원 메서드
get(idx)
add(value)
set(idx, value)
remove(idx || value)
* size 도 기본으로 가지고 있다

## 시간 복잡도
```
ArrayList<Integer> a = new ArrayList<>(List.of(1,2,3));

a.get(0);    // O(1)
a.set(1,9);  // O(1)
a.add(4);    // O(1)
a.add(5);    // O(N) : 배열을 확장하고 넣어줘야 하기에 N이다(2배 확장한 배열 생성 후 새로운 배열로 값을 복사하며 기존 배열은 삭제한다)
a.add(6);    // O(1)
a.remove(a.size() - 1);    // O(1)
a.add(1, 10);   // O(N) : 중간에 삽입하거나 지울때는 나머지 값을 당겨줘야하기 때문에
a.remove(2);    // O(N)
a.contains(4);  // O(N)
a.remove(Integer.valueOf(10));  // O(N)
```

# Linked List
정의: Node가 Pointer(참조)를 통해 연결되ㅇ, 논리적인 순서로 형성된 자료구조

```
class Node {
    int value;
    Node next;
    Node prev; // 다음 노드와 이전 노드 주소를 가지고 있다(양방향 리스트)
    public Node(int value){
        this.value = value;
    }
}
```

### Java 에서 Linked List 선언
```
List<Integer> linked = new LinkedList<>();
```

## 시간복잡도
```
import java.util.LinkedList;

LinkedList<String> list = new LinkedList<>();

list.add("B");   // O(1)
list.add("C");
list.addFirst("A");
list.addLast("C");

String s1 = list.get(1);     // O(N)
String s2 = list.getFirst(); // O(1)
String s3 = list.getLast(); 

list.removeFirst();     // O(1)
list.removeLast();      // O(1)
list.remove("C");       // O(N)

int size = list.size(); // O(1)
boolean hasC = list.contains("A")   // O(N)

### list iterator
list.add("A");
list.add("B");
list.add("C");
list.add("D");
list.add("E");

// 이터레이터를 사용해 커서를 움겨가며 지나간 위치의 값을 삭제한다.
LinkedIterator<String> cursor = list.listIterator(2);
if (cursor.hasPrevious()) {
    cursor.previous();
    cursor.remove();
}
if (cursor.hasNext()) {
    cursor.next();
    cursor.remove();
}
```

#### 2차원 배열 사용시 주의사항
2차원 배열을 CopyOf 메서드로 1차원 배열 복사하듯 복사하게 되면 얕은 복사(shoallow copy)가 일어나서 원본값도 바뀌게 된다. 따라서 반복문을 사용해야 한다.

```
List<List<Integer>> doubleList = new ArrayList<>(); // 초기화

List<List<Integer>> copyList = newArrayList<>();
for(List<Integer> row : doubleList) {
    copyList.add(new ArrayList<>(row))
}
```


# Queue
정의: FIFO(선입선출) 원칙을 따르는 자료구조
-> Java 에서는 **ArrayDeque**(Array를 활용해서 만든 원형큐)를 사용한다.

```
import java.util.ArrayDeque;
import java.util.Queue;

Queue<Integer> queue = new ArrayDeque<>();

queue.offer(10);
queue.offer(20);

int newxtItem = queue.peek();
while (!queue.isEmpty()) {
    int item = queue.poll();
}
System.out.println(queue.popll()); // null 반환
```

## 제공하는 인터페이스
코테에서는 offer, poll 을 더 자주 쓴다(null 값 활용)
* offer = add
* poll = remove
* peek 은 큐에서 값을 빼는게 아니라 해당 값만 보여준다


# Stack
정의: LIFO(후입선출) 원칙을 따르는 자료구조. java에서는 ArrayDeque 을 사용해 구현한다.
팁: LinkedList 를 사용할 수도 있지만 ArrayDeque 가 더 빠르기 때문에 ArrayDeque을 사용한다.
주요 문제: 주식가격, 오늘날씨 (되돌리기가 필요할때 사용하면 좋다)

```
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);

int top = stack.peek();
while (!stack.isEmpty()) {
    int item = stack.poll();
```


# Hash table
정의: key, value 를 한 쌍으로 저장하는 자료구조, 해시 함수가 key 를 특정 숫자(인덱스)로 변환해 주면, 데이터를 해당위치의 배열 공간(버킷)에 바로 저장한다.

* hash collision 은 면접용 개념만 알아두기

```
import java.util.HashMap;
import java.util.Map;

Map<String, String> userMap = new HashMap<>();

// 삽입, 수정: O(1)
userMap.put("mike", "학생1")
userMap.put("henry", "학생2")
userMap.put("mari", "학생3")

// 조회: O(1)
String adminName = userMap.get("mike")

// 키 존재 여부 확인: O(1) : 해시함수로 바로 알 수 있다
```

## Hash 순회
```
// 방법 1: entrySet() (Key, Value 모두 필요할 때)
for(Map.Entry<String, String> entry : userMap.entrySet()) {
    String key = entry.getKey();
    String value = entry.getValue();
}

// 방법 2: keySet() (key 만 필요할 때)
for(String key : userMap.keySet()) {
    String value = userMap.get(key);
}

// 방법 3: forEach() (람다식)
userMap.forEach((key, value) -> {});
```

# HashSet
정의: 중복된 요소를 허용하지 않는 '집합(Set)'을 구현한 자료구조. 내부적으로 HashMap을 활용한다.

```
import java.util.HashSet;
import java.util.Set;

Set<String> tagSet = new HashSet<>();

// add(Value): 데이터 추가
target.add("Java")
target.add("Python")

// 중복된 데이터 추가시 return False
target.add("Java");

if(target.contains("Java")){}  // O(1)

tagSet.remove("Python");  // O(1)

int tagSize = tagSet.size();  // O(1) size도 저장중
```
