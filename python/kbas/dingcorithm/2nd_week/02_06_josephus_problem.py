"""
kbas.python.kbas.dingcorithm.2nd_week.02_06_josephus_problem의 Docstring

요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
이제 순서대로 K번째 사람을 제거한다.
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

출력
예제와 같이 요세푸스 순열을 출력한다.

예제 입력 1 
7 3
예제 출력 1
<3, 6, 2, 7, 5, 1, 4>
"""

# BOJ 1158

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self, value):
        self.head = Node(value)
    
    def append(self, value):
        new_node = Node(value)
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = new_node

    def get_node(self, index):
        cur = self.head
        cur_index = 0
        while cur_index != index:
            cur = cur.next
            cur_index += 1

        if cur is None:
            return None
        
        return cur
    
    def size(self):
        cur = self.head
        count = 0
        while cur is not None:
            count += 1
            cur = cur.next
        return count

    def delete(self, index):
        if index == 0:
            delete_node = self.head
            self.head = delete_node.next
            return

        prev_node = self.get_node(index - 1)
        delete_node = prev_node.next
        prev_node.next = delete_node.next

"""
문제 풀 방법
1. 링크드에다가 다 삽입하고 list가 다 비워질 때까지 k만큼 next를 함
2. k번째 next 된 애를 삭제. 삭제된 애를 list에 보관
3. 다 비워지면 list 반환
"""
def josephus_problem(n, k):
    # 이 부분을 채워보세요!
    linked_list = LinkedList(1)
    for i in range(1, n):
        linked_list.append(i + 1)

    deleted_result_str = '<'
    index = 0
    while linked_list.size() > 1:
        for _ in range(k - 1):
            index += 1
            if index >= linked_list.size():
                index = 0 + index - linked_list.size()

        deleted_result_str += f"{linked_list.get_node(index).data}, "
        linked_list.delete(index)

    deleted_result_str += f"{linked_list.get_node(index).data}>"
    return deleted_result_str


n, k = map(int, input().split())
print(josephus_problem(n, k))