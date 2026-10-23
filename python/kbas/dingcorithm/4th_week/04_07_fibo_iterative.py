# 이건 따로인데, 재귀 사용하면 공간복잡도가 깊어진다. n>=1000이면 Recursion 에러가 발생할지도?
# 공간복잡도가 O(1) 로 구현하는 방법이다.
input = 1000


def fibo_iterative(n):
    if n <= 2:
        return 1
    a, b = 1, 1
    for _ in range(3, n + 1):
        a, b = b, a + b
    return b


print(fibo_iterative(input))