"""
힙은 항상 큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있어야 한다.

따라서 원소를 추가하거나 삭제할 때도 위의 규칙이 지켜져야 한다.

응급실에서 더 급한 우선 순위의 환자가 온 것에 비유

원소를 삭제할 때는 다음과 같이한다.
1. 루트 노드와 맨 끝에 있는 원소를 교체한다.
2. 맨 뒤에 있는 원소를 (원래 루트 노드)를 삭제한다.
3. 변경된 노드와 자식 노드들을 비교합니다. 두 자식 중 더 큰 자식과 비교해서 자신보다 자식이 더 크다면 자리를 바꿉니다.
4. 자식 노드 둘 보다 부모 노드가 크거나 가장 바닥에 도달하지 않을 때까지 3. 과정을 반복합니다.
5. 2에서 제거한 원래 루트 노드를 반환합니다.
"""

class MaxHeap:
    def __init__(self):
        self.items = [None]

    def insert(self, value):
        self.items.append(value)
        cur_index = len(self.items) - 1

        while cur_index > 1:  # cur_index 가 1이 되면 정상을 찍은거라 다른 것과 비교 안하셔도 됩니다!
            parent_index = cur_index // 2
            if self.items[parent_index] < self.items[cur_index]:
                self.items[parent_index], self.items[cur_index] = self.items[cur_index], self.items[parent_index]
                cur_index = parent_index
            else:
                break

    def delete(self):
        # 구현해보세요!
        root_index = 1
        last_index = len(self.items) - 1

        # 1. 루트 노드와 맨 끝에 있는 원소를 교체한다.
        self.items[root_index], self.items[last_index] = self.items[last_index], self.items[root_index]
        # 5. 2에서 제거한 원래 루트 노드를 반환합니다.
        deletion = self.items.pop()

        cur_index = root_index
        # 4. 자식 노드 둘 보다 부모 노드가 크거나 가장 바닥에 도달하지 않을 때까지 3. 과정을 반복합니다.
        while cur_index < last_index:
            left_child_index = cur_index * 2
            right_child_index = left_child_index + 1
            # 3. 변경된 노드와 자식 노드들을 비교합니다. 두 자식 중 더 큰 자식과 비교해서 자신보다 자식이 더 크다면 자리를 바꿉니다.
            if self.items[cur_index] < self.items[left_child_index] or (right_child_index <= last_index and self.items[cur_index] < self.items[right_child_index]):
                # 왼쪽 자식이 더 크다면 부무랑 왼쪽 자식이랑 교체
                if self.items[left_child_index] > self.items[right_child_index]:
                    self.items[cur_index], self.items[left_child_index] = self.items[left_child_index], self.items[cur_index]
                # 오른쪽 자식이 더 크다면 부무랑 오른쪽 자식이랑 교체
                else:
                    self.items[cur_index], self.items[right_child_index] = self.items[right_child_index], self.items[cur_index]
            else:
                break

        # 5. 2에서 제거한 원래 루트 노드를 반환합니다.
        return deletion  # 8 을 반환해야 합니다.

max_heap = MaxHeap()
max_heap.insert(8)
max_heap.insert(6)
max_heap.insert(7)
max_heap.insert(2)
max_heap.insert(5)
max_heap.insert(4)
print(max_heap.items)  # [None, 8, 6, 7, 2, 5, 4]
print(max_heap.delete())  # 8 을 반환해야 합니다!
print(max_heap.items)  # [None, 7, 6, 4, 2, 5]