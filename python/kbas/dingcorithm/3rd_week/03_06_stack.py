"""
kbas.python.kbas.dingcorithm.3rd_week.03_06_stack의 Docstring
"""

"""
Stack 특성:
1. 한 곳에서만 자료를 넣고 뺼 수 있음
2. LIFO -> Last in First Out. 가장 마지막에 넣은 게 제일 빨리 나간다.
    [4] -> [3] 이면 pop 이라는 함수를 통해서 제일 먼저 [3] 이 삭제 되어야 함
    그러니깐 Push 했을 때는 [3]이 head가 됨

1. push 함수에서 맨 위에 값을 넣을 것이고,
2. pop 함수에서 맨위의 값을 뺼 거고
3. peek 함수에서 맨 위의 값을 불러올 것임. 그러려면 맨위의 값을 쉽게 조회해야함

가장 마지막에 들어온 애를 head로 하자
필요한 것은 무조건 최신것, 즉 마지막 애니깐
"""


class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None

class Stack:
    def __init__(self):
        self.head = None
    
    def push(self, value):
        # 어떻게 하면 될까요?
        new_head = Node(value)
        new_head.prev = self.head
        self.head = new_head

    def pop(self):
        # 어떻게 하면 될까요?
        poping_head = self.head
        self.head = poping_head.prev
        return poping_head
    
    # node 를 반환할 게 아니라 데이터를 반환할 것
    def peek(self):
        # 어떻게 하면 될까요?
        if self.is_empty():
            print("Stack is Empty")
            return None
        
        return self.head.data

    def is_empty(self):
        # 어떻게 하면 될까요?
        return self.head is None
    
stack = Stack()
stack.push(4)
print(stack.peek())
stack.push(5)
print(stack.peek())
stack.push(8)
print(stack.peek())

stack.pop()
print(stack.peek())

stack.pop()
print(stack.peek())

stack.pop()
print(stack.peek())