"""
해쉬?
컴퓨팅에서 키를 값에 매핑할 수 있는 구조인, 연관배열 추가에 사용되는 자료구조.
해시 테이블을 해시 함수를 사용하여 색인을 버킷이나 슬롯의 배열로 계산한다.
데이터를 다루는 기법 중에 하나로서 **검색과 저장이 아주 빠르게** 진행된다.

python의 dictionary다.
배열은 모든 요소를 순회해야 했다면 키로 검색을 하니깐 매우 유용한 자료구조이다.

그러나 신기하게도, dictionary는 내부적으로 배열을 사용한다.
키의 값이 배열 어딘가 위치하고 있다고 할 때, 그 인덱스를 몇번에 넣어야 하는지, 몇번에서 찾아야 하는지
찾아줄 때 해쉬 함수를 이용한다.

해쉬함수? 임의의 길이를 갖는 메시지를 입력하여 고정된 길이의 해쉬값을 출력하는 함수다.

이 함수를 이미 파이썬에서 제공하고 있다.
hash("fast")이렇게

총 들어있는 배열의 길이만큼 나눠서 저장

hash("fast") % 8 이렇게 해서
fast -> hash한 값으로 만듦 -> 배열의 길이로 나누어서 생긴 나머지를 인덱스 -> 에다가 value를 저장해주겠다.

충돌
근데, 해쉬값으로 나머지 값 구한 인덱스가 같아서 덮어씌워지는 경우가 있다.
해쉬 테이블 구조상 어쩔 수가 없앋ㅠ
이런걸 해결해주기 위해서는 Chainig 이라는 기법을 사용. 링크드 리스트를 사용한다.
충돌이 일어나면 링크드 리스트로 관리하겠다는 뜻
"""

# print(hash("fast"))
# print(hash("fast") % 8)

class Dict:
    def __init__(self):
        self.items = [None] * 8
    
    # dictionay에 key에 해당하는 곳에 value를 저장해두겠다.
    def put(self, key, value):
        index = hash(key) % len(self.items)
        self.items[index] = value

    # dictionary에 key에 해당하는 value를 반환한다.
    def get(self, key):
        index = hash(key) % len(self.items)
        return self.items[index]
    
dict = Dict()
dict.put('Fast', "빠르다.")
dict.put('Slow', "느리다")
dict.put('test', 3)

print(dict.get('Fast'))
print(dict.get('Slow'))
print(dict.get('test'))
