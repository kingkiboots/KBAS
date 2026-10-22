# dfs는 stack으로도 구현이 가능하다. recursion이 쌓이지도 않으므로 더 낫다.
# 주의할 점은 탐색하는 순서가 재귀때랑은 다르게 마지막 인접노드부터 탐색하지만 끝까지 탐색하는 것은 같다.

# 위의 그래프를 예시로 삼아서 인접 리스트 방식으로 표현했습니다!
graph = {
    1: [2, 5, 9],
    2: [1, 3],
    3: [2, 4],
    4: [3],
    5: [1, 6, 8],
    6: [5, 7],
    7: [6],
    8: [5],
    9: [1, 10],
    10: [9]
}

# 1. 루트 노드를 스택에 넣는다.
# 2. 현재 스택의 노드를 빼서 visited에 추가한다.
# 3. 현재 바문한 노드와 인접한 노드 중 방문하지 않은 노드를 스택에 추가한다.
# 4. 2부터 반복한다.
# 5. 스택이 비면 탐색을 종료한다.

def dfs_stack(adjacent_graph, start_node):
    # 구현해보세요!
    stack = [start_node]
    visited = []

    while stack: # 스택이 비지 않을 떄까지 반복
        cur_node = stack.pop()
        visited.append(cur_node)

        for adjacent_node in adjacent_graph[cur_node]:
            if adjacent_node not in visited:
                stack.append(adjacent_node)

    return visited


print(dfs_stack(graph, 1))  # 1 이 시작노드입니다!
# [1, 9, 10, 5, 8, 6, 7, 2, 3, 4] 이 출력되어야 합니다!