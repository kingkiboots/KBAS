"""
kbas.python.kbas.dingcorithm.2nd_week.02_14_is_available_to_order의 Docstring

Q. 배달의 민족 서버 개발자로 입사했다.
상점에서 현재 가능한 메뉴가 ["떡볶이", "만두", "오뎅", "사이다", "콜라"] 일 때, 유저가 ["오뎅", "콜라", "만두"] 를 주문했다.

그렇다면, 현재 주문 가능한 상태인지 여부를 반환하시오.
"""

shop_menus = ["만두", "떡볶이", "오뎅", "사이다", "콜라"]
shop_orders = ["오뎅", "콜라", "만두"]

# O(logN)
def is_exist_target_number_binary(menus, order):
    current_min = 0
    current_max = len(menus) - 1
    current_guess = (current_min + current_max) // 2

    while current_min <= current_max:
        if order == menus[current_guess]:
            return True
        elif order > menus[current_guess]:
            current_min = current_guess + 1
        else: 
            current_max = current_guess - 1

        current_guess = (current_min + current_max) // 2

    return False
            


# shop_orders 중 하나라도 없으면 return false, 다 있으면 return 
def is_available_to_order(menus, orders):
    # 이 부분을 채워보세요!
    # O(logM)
    # menus.sort()
    
    # # O(N)
    # for order in orders:
    #     if not is_exist_target_number_binary(menus, order):
    #         return False
    # # O(logM + N * logN)
    # return True

    # 더 좋은 방법이 있음. list는 in으로 탐색하면 시간복잡도가 O(N) 인데 set은 O(1)임
    # O(M)
    menus_set = set(menus)

    # O(N)
    for order in orders:
        # O(1)
        if order not in menus_set:
            return False
    # O(M + N)
    return True


result = is_available_to_order(shop_menus, shop_orders)
print(result)