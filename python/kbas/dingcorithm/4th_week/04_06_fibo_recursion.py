input = 20


def fibo_recursion(n):
    if n <= 2:
        return 1
    return fibo_recursion(n - 1) + fibo_recursion(n - 2)


print(fibo_recursion(input))  # 6765

# 근데 input 이 100면 결과가 안나온다. -> 너무 연상량이 많아서!
# 같은 걸 계속 반복해서 연산한다. 그러니깐 이러한 방법은 비효율 적인 것이다.