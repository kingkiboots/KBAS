class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    def append(self, value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(value)

    # 끝에서 k번째...
    # if lastIndex = 10 , 끝에서 2번째는 9,
    # if lastIndex = 10 , 끝에서 8번째는 3,
    # 끝에서 k번째 인덱스는 lastIndex - k + 1
    # 
    def get_kth_node_from_last(self, k):
        # 구현해보세요!
        # cur = self.head
        # # result = []

        # # while cur is not None:
        # #     result.append(cur)
        # #     cur = cur.next

        # # return result[-k]
        # length = 1
        # while cur.next is not None:
        #     cur = cur.next
        #     length += 1
        
        # end_length = length - k
        # cur = self.head
        # for _ in range(end_length):
        #     cur = cur.next

        # return cur
    
        # 근데 위와 같은 방식은 무조건 N이상 만큼 loop함 2N
        slow = self.head
        fast = self.head

        # fast를 k 만큼 앞으로 보냄
        for _ in range(k):
            fast = fast.next
        # fast가 마지막에 도달할 때까지 이동
        while fast is not None:
            slow = slow.next
            fast = fast.next

        # 그럼 결국 마지막엔 뒤에서 k번째 만큼의 노드를 반환하는 것 이렇게 하면 N
        return slow



linked_list = LinkedList(6)
linked_list.append(7)
linked_list.append(8)

print(linked_list.get_kth_node_from_last(2).data)  # 7이 나와야 합니다!