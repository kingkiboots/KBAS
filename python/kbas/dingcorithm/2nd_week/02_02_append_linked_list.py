class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

node = Node(3)
# print(node.data, node.next)

class LinkedList:
    def __init__(self, value):
        self.head = Node(value)
    
    # LinkedList 의 가장 끝에 있는 노드에 새로운 노드를 연결해줘
    def append(self, value):
        cur_node = self.head
        while cur_node.next is not None:
            cur_node = cur_node.next
        cur_node.next = Node(value)

    # LinkedList 에서 저장한 head를 따라가면서 현재 있는 노드들을 전부 출력해보는 함수
    def print_all(self):
        cur_node = self.head
        res_str = '['
        while cur_node.next is not None:
            res_str += f"{cur_node.data}, "
            cur_node = cur_node.next
        res_str += f"{cur_node.data}]"
        print(res_str)

    
linked_list = LinkedList(5)
linked_list.append(12)
linked_list.append(8)
linked_list.print_all()
