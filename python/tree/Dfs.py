# 재귀 개념 이해하며 외우기!
def dfs(cur_node):
    if cur_node is None:
        return
    dfs(cur_node.left)
    dfs(cur_node.right)