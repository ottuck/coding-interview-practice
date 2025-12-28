import Node

class LinkedList(object):
    def __init__(self):
        self.head = None

    def append(self, value):
        current = self.head
        while current.next:
            current = current.next
        current.next = Node(value)

    def get(self, idx):
        current = self.head
        for _ in range(idx):
            current = current.next
        return current.value
    
    def insert(self, idx, value):
        new_node = Node(value)

        current = self.head
        for _ in range(idx - 1):
            current = current.next
    def remove(self, idx):
