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
        if cur_node is None:
            print("[]")
            return

        res_str = '['
        while cur_node.next is not None:
            res_str += f"{cur_node.data}, "
            cur_node = cur_node.next
        res_str += f"{cur_node.data}]"
        print(res_str)

    def get_node(self, index):
        cur = self.head
        # for _ in range(0, index):
        #     if cur.next is None:
        #         print("out of index!")
        #         return None
        #     cur = cur.next
        cur_index = 0
        while cur_index != index:
            if cur.next is None:
                print("out of index!")
                return None
            cur = cur.next
            cur_index += 1
        return cur
    
    def add_node(self, index, data):
        new_node = Node(data)
        if index == 0:
            new_node.next = self.head
            self.head = new_node
            return

        prev_node = self.get_node(index - 1)
        
        next_node = prev_node.next

        new_node.next = next_node
        prev_node.next = new_node

    def delete_node(self, index):
        if index == 0:
            self.head = self.head.next
            return

        prev_node = self.get_node(index - 1)

        target_node = prev_node.next
        prev_node.next = target_node.next




    
linked_list = LinkedList(5)
linked_list.append(12)
linked_list.append(8)

linked_list.delete_node(2)
linked_list.print_all()

linked_list.delete_node(0)
linked_list.print_all()

linked_list.delete_node(0)
linked_list.print_all()