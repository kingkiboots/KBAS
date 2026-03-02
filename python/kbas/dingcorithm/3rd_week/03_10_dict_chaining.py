"""
체이닝을 구현해보자. 체이닝은 해시테이블에서 인덱스가 겹칠 걸 대비한 알고리즘이다.
해당 요소에 [...[key, value] -> [key, value]] 이렇게 해보자

hash('77') hash("333") 의 인덱스가 같다고 할 때
self.items[1] : ['77', '느리다'] -> ['333', '빠르다.'] 이렇게 링크트 리스트
키값에서 원하는 키 값의 value를 반환

또 다른 충돌을 방지하는 방법은 배열의 다음 남든 공간에 넣는 것임
"""

# print(hash("fast"))
# print(hash("fast") % 8)

class LinkedTuple:
    def __init__(self):
        self.items = []

    def add(self, key, value):
        self.items.append([key, value]) # ['77', '느리다'] -> ['333', '빠르다.']

    def get(self, key):
        for k, v in self.items:
            if k == key:
                return v
        return None

class LinkedDict:
    def __init__(self):
        self.items = []
        for i in range(8):
            self.items.append(LinkedTuple())
    
    # dictionay에 key에 해당하는 곳에 value를 저장해두겠다.
    def put(self, key, value):
        index = hash(key) % len(self.items)
        self.items[index].add(key, value) # 한번더 호출되면 ['77', '느리다'] -> ['333', '빠르다.']        

    # dictionary에 key에 해당하는 value를 반환한다.
    def get(self, key):
        index = hash(key) % len(self.items)
        return self.items[index].get(key)
    
dict = LinkedDict()
dict.put('333', "빠르다.")
dict.put('77', "느리다")
dict.put('test', 3)

print(dict.get('333'))
print(dict.get('77'))
print(dict.get('test'))
