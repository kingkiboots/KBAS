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
def josephus_problem(n, k):
    # 이 부분을 채워보세요!
   # 1번부터 N번까지의 사람 리스트 생성
    people = list(range(1, n + 1))
    result = [] # 제거된 순서를 담을 리스트
    index = 0   # 제거할 사람의 인덱스
    
    while people:
        # (현재 인덱스 + K - 1)을 현재 남은 인원수로 나눈 나머지가 다음 제거 대상
        index = (index + k - 1) % len(people)
        
        # 해당 인덱스의 사람을 꺼내서 결과 리스트에 추가
        result.append(str(people.pop(index)))
    
    # 출력 형식에 맞춰 출력 (<3, 6, 2, 7, 5, 1, 4>)
    return "<" + ", ".join(result) + ">"


n, k = map(int, input().split())
print(josephus_problem(n, k))