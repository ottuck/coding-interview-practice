# 문제: 두 노드의 조상 조상 노드(LCA : the lowest common ancesotor)
# 중 가장 낮은 레벨의 노드를 찾아라
#
# 제한 : 2 <= node 개수 <= 10^5 (n^2 보다 빠른 풀이 필요)
# 모든 Node.val 은 유니크하다
# p != q 이다
# p,q 는 모두 주어진 노드 트리에 속해있다
#
# 접근방식 : 각 노드가 처음으로 만나는 레벨의 노드를 찾는다
#
# 케이스 구분 (노드 구조를 이미지화 해본다)
# case1: x -> x
# case2: p || q -> 자기 자신 리턴 (p || q)
# case3: left child && right child -> 자기 자신 리턴
# case4: left child || right child -> left child || right child
# * 위 조건대로 분기키시기 위해서는 자식노드의 리턴값을 '먼저' 알고 있어야 한다.

def LCA(root, p, q):
    if root == None:
        return None
    
    left = LCA(root.left, p, q)
    right = LCA(root.right, p, q)
    if root == p or root == q:
        return root
    elif left and right:
        return root
    return left or right
