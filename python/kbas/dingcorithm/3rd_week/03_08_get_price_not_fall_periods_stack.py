"""
Q.

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 함수를 완성하세요.

prices = [1, 2, 3, 2, 3]
answer = [4, 3, 1, 1, 0]
"""

prices = [1, 2, 3, 2, 3]

# O(N**) 단순히 큐 쓴다고 시간 복잡도가 개선 되는 건 아님
def get_price_not_fall_periods(prices):
    N = len(prices)
    answer = [0] * N
    stack = []
    for i in range(N - 2, -1 , -1):
        # 스택 중 최신 순으로 보다 높은 가격은 삭제
        while stack and stack[-1][1] >= prices[i]:
            stack.pop()

        # 위에서 살아 남았다는 건 오른쪽 가장 가까운 곳의 떨어진 가격이라는 것
        if stack:
            answer[i] = stack[-1][0] - i
        # 그렇지 않다면 끝까지 자신 보다 가격이 떨어진 게 없다는 것
        else:
            answer[i] = N - i - 1

        # [현재 인덱스, 가격] 담기
        stack.append([i, prices[i]])
    
    return answer


print(get_price_not_fall_periods(prices))

print("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods(prices))
print("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods([3, 9, 9, 3, 5, 7, 2]))
print("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods([1, 5, 3, 6, 7, 6, 5]))