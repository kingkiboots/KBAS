"""
힙은 항상 큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있어야 한다.

따라서 원소를 추가하거나 삭제할 때도 위의 규칙이 지켜져야 한다.

원소를 추가할 때는 다음과 같이한다.
1. 원소를 추가할 때는 맨 마지막에 넣는다.
2. 부모 노드와 비교한다. 만약 더 크다면 자리를 바꾼다.
3. 부모 노드보다 작거나 가장 위에 도달하지 않을 때까지 2. 과정을 반복한다.
"""

class MaxHeap:
    def __init__(self):
        self.items = [None]

    def insert(self, value):
        # 구현해보세요!
        # 1. 원소를 추가할 때는 맨 마지막에 넣는다.
        self.items.append(value)

        # 2. 부모 노드와 비교한다. 만약 더 크다면 자리를 바꾼다.
        # 3. 부모 노드보다 작거나 가장 위에 도달하지 않을 때까지 2. 과정을 반복한다.
        cur_index = len(self.items) - 1
        while cur_index > 1: # 1일 경우에는 root node라서 더 비교할 게 없음. 올라갈 것도 없고.
            parent_index = cur_index // 2
            if self.items[cur_index] > self.items[parent_index]:
                self.items[parent_index], self.items[cur_index] = self.items[cur_index], self.items[parent_index]
                cur_index = parent_index
            else: # 만약 자식 노드가 부모 노드보다 크지 않다면 반복문 종료
                break


max_heap = MaxHeap()
max_heap.insert(6)
max_heap.insert(3)
max_heap.insert(4)
max_heap.insert(2)
max_heap.insert(8)
max_heap.insert(7)
max_heap.insert(1)
max_heap.insert(5)
print(max_heap.items)  # [None, 9, 4, 2, 3] 가 출력되어야 합니다!