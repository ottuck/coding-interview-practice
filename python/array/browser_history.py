# '브라우저 기록 기능' 구현하기
# 특정 페이지 방문, 뒤로가기, 앞으로 가기 버튼이 있어야 하고 방문시 이전 페이지의 기록은 삭제되어야 한다.
# 문제를 봤을대 (doubly)LinkedList 구조와 잚 맞기 때문에 채택한다.

class ListNode(object):
    def __init__(self, val=0, next=None, prev=None):
        self.val = val
        self.next = next
        self.prev = prev

class BrowserHistory(object):
    def __init__(self, homepage):
        self.head = self.current = ListNode(val=homepage)
    
    #새로운 LinkedList 객체 생성 후 current.next 가 새로 생성된 LinkedList를 가르키도록하고, 현재 current 커서를 next로 이동
    def visit(self, url): 
        self.current.next = ListNode(val=url, prev=self.current)
        self.current = self.current.next
        return None
    
    # stack 을 비울때까지 current 커서를 앞으로 움기거나(back) 뒤로 움긴다(forword)
    def back(self, steps):
        while steps > 0 and self.current.prev != None:
            steps -= 1
            self.current = self.current.prev

    def forward(self, steps):
        while steps > 0 and self.current.next != None:
            steps -= 1
            self.current = self.current.next
        return self.current.val