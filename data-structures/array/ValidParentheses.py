# (),{},[]가 담긴 문자열이 주어지면 괄호가 제대로 닫혔는지 검사하는 문제는 대부분 Stack 구조를 사용하라는 문제라 외워두면 좋다.

# 예제 1
# input: s=")("
# output: False
#
# 예제 2
# input: s="{()[]}"
# output: True
#
# 문제
# s:'{(([]))[]}'
# stack: []
# p: '[]'

def isValid(s):
    stack = [] # python 에서 stack 은 기본 컬랙션 arrayList 로 구현되어 있다
    for p in s:
        if p == '(':
            stack.append(')')
        elif p == '{':
            stack.append('}')
        elif p == '[':
            stack.append(']')
        elif not stack or stack.pop() != p:
            return False
    return not stack
