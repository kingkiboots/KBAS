"""
Q.
다음과 같이 숫자로 이루어진 배열이 두 개가 있다. 
하나는 상품의 가격을 담은 배열이고, 하나는 쿠폰을 담은 배열이다. 
쿠폰의 할인율에 따라 상품의 가격을 할인 받을 수 있다. 
이 때, 최대한 할인을 많이 받는다면 얼마를 내야 하는가?
단, 할인쿠폰은 한 제품에 한 번씩만 적용 가능하다.
"""

shop_prices = [30000, 2000, 1500000]
user_coupons = [20, 40]

from math import trunc

def get_max_discounted_price(prices: list[int], coupons: list[int]):
    # 이 곳을 채워보세요!
    # max_discounted_price = 0
    # PN = len(prices)
    # CN = len(coupons)

    # prices.sort(reverse=True)
    # coupons.sort(reverse=True)

    # for i in range(PN):
    #     price = prices[i]
    #     if i >= CN:
    #         max_discounted_price += price
    #     else:
    #         max_discounted_price += trunc(price * ((100 - coupons[i]) / 100))

    # return max_discounted_price

    # 이렇게 풀 수도 있음
    prices.sort(reverse=True)
    coupons.sort(reverse=True)

    prices_index = 0
    coupons_index = 0
    max_discounted_price = 0

    # 현재 가격과 쿠폰이 모두 배열 내의 원소일 때
    while prices_index < len(prices) and coupons_index < len(coupons):
        discouned_price = prices[prices_index] * ((100 - coupons[coupons_index]) / 100)
        max_discounted_price += discouned_price
        prices_index += 1
        coupons_index += 1

    # 즉, 현재 prices_index 가 prices 길이 범위 내라면
    while prices_index < len(prices):
        max_discounted_price += prices[prices_index]
        prices_index += 1

    return max_discounted_price



print("정답 = 926000 / 현재 풀이 값 = ", get_max_discounted_price([30000, 2000, 1500000], [20, 40]))
print("정답 = 485000 / 현재 풀이 값 = ", get_max_discounted_price([50000, 1500000], [10, 70, 30, 20]))
print("정답 = 1550000 / 현재 풀이 값 = ", get_max_discounted_price([50000, 1500000], []))
print("정답 = 1458000 / 현재 풀이 값 = ", get_max_discounted_price([20000, 100000, 1500000], [10, 10, 10]))