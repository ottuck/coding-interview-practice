from node import Node

# dummy version
class DoublyLinkedList(object):
    def __init__(self):
        self.dummy = Node()
        self.size = 0

    def append(self, value):
        current = self.dummy
        while current.next:
            current = current.next

        current.next = Node(value)
        self.size += 1

    def get(self, idx):
        current = self.dummy.next
        for _ in range(idx):
            current = current.next
        return current.value
    
    def insert(self, idx, value):
        new_node = Node(value)

        prev = self.dummy # 조작(삽입,삭제)할 노드 이전 노드라서 prev로 명명
        for _ in range(idx):
            prev = prev.next

        new_node.next = prev.next
        prev.next = new_node
        self.size += 1
        
    def remove(self, idx):
        prev = self.dummy    
        for _ in range(idx - 1):
            prev = prev.next
        prev.next = prev.next.next # 삭제할 노드를 건너뛰고 다음노드로 이동한다. 즉 타겟인 prev.next 를 지우고 다음 노드를 가르키게 한다
        self.size -= 1
