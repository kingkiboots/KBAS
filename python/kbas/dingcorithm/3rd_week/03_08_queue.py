"""
Queue
먼저 들어온 애가 먼저 나간다. FIFO
큐 라는 자료 구조에서 제공하는 기능은 다음과 같다.

enqueue(data): 맨 뒤에 데이터 추가하기
dequeue(): 맨 앞의 데이터 뽑기
peek(): 맨 앞의 데이터 보기
isEmpty(): 큐가 비었는지 안 비었는지 여부 반환해주기
"""

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# 얘는 Stack과는 다르게 맨 앞에랑 맨 뒤를 모두 갖고 있어야 한다.
class Queue:
    def __init__(self):
        self.head = None
        self.tail = None
    
    # 맨 뒤에 데이터 추가하기
    def enqueue(self, value):
        new_node = Node(value)
        if self.is_empty():
            self.head = new_node
            self.tail = new_node
            return
        
        self.tail.next = new_node
        self.tail = new_node
    
    # 맨 앞의 데이터 뽑기
    def dequeue(self):
        if self.head is None:
            print("Queue is Empty!")
            return None
        delete_head = self.head
        self.head = delete_head.next
        return delete_head
    
    # 맨 앞의 데이터 보기
    def peek(self):
        if self.is_empty():
            print("Queue is Empty!")
            return None

        return self.head.data
    
    # 큐가 비었는지 안 비었는지 여부 반환해주기
    def is_empty(self):
        return self.head is None

queue = Queue()
queue.enqueue(4)
print(queue.peek())
queue.enqueue(2)
print(queue.peek())
queue.enqueue(3)
print(queue.peek())

queue.dequeue()
print(queue.peek())

queue.dequeue()
print(queue.peek())

queue.dequeue()
print(queue.peek())
