"""
Q.

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 함수를 완성하세요.

prices = [1, 2, 3, 2, 3]
answer = [4, 3, 1, 1, 0]
"""

prices = [1, 2, 3, 2, 3]


def get_price_not_fall_periods(prices):
    # 이 부분을 채워주세요!
    N = len(prices)
    answer = [0] * N
    for i in range(N - 1): # 어짜피 마지막 애는 0이니깐 거기까지 안 돈다
        price_not_fall_period = 0
        for j in range(i + 1, N):
            price_not_fall_period += 1 # 카운팅
            if prices[i] > prices[j]: # 보다 작은 애를 만나면 멈춰!
                break
        answer[i] = price_not_fall_period # 카운트 한 애를 결과 배열에 삽입

    return answer
    


print(get_price_not_fall_periods(prices))

print("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods(prices))
print("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods([3, 9, 9, 3, 5, 7, 2]))
print("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods([1, 5, 3, 6, 7, 6, 5]))