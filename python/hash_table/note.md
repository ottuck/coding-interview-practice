# HashTable(Dictionary)
1. Python 에서는 Dictionary(arrayList based)로 구현되어 있다.
2. 저장,삭제,검색 시간복잡도는 O(1)이다.

# 추가1
hash함수를 안거치고 키값을 그대로 인덱스로 갖는 테이블을 direct table 이라고 한다. 당연히 인덱스 값 문제가 생기기 때문에 아래와 같은 hash 함수를 거친다.

'''
def toHash(key):
    return key % n
'''

# 선언 예제
1. score = {'math': 95, 'english': 80}
2. if math in score:

# 추가2 : Hash Colision
정의: 저장하려는 인덱스에 기존에 값이 있었을 경우 충돌이 발생한다.
해결 방법: 
1. ArrayList based : Open addressing
2. ArrayList + LinkedList based : Seprerate chaning