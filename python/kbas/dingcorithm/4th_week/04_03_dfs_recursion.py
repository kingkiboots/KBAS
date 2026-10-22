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
visited = []

# 1. 시작 노드인 1부터 탐색하빈다.
# 2. 현재 방문한 노드를 visited_array에 추가합니다.
# 3. 현재 방문한 노드와 인접한 노드 중 방문하지 않은 노드를 방문합니다.
def dfs_recursion(adjacent_graph: dict[int, list[int]], cur_node: int, visited_array: list[int]) -> int:
    # 구현해보세요!
    visited_array.append(cur_node)
    for adjacent_node in adjacent_graph[cur_node]:
        if adjacent_node not in visited_array: # 방문하지 않았다면:
            dfs_recursion(adjacent_graph, adjacent_node, visited_array)

    return

dfs_recursion(graph, 1, visited)  # 1 이 시작노드입니다!
print(visited)  # [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 이 출력되어야 합니다!

# 재귀함수로 dfs를 구현하는 것은 그다지 좋은 방법은 아니다.
# 깊이가 그리 깊지 않아서 다행이지, 수백만의 깊이면 RecursionError가 발생할 수 있다.