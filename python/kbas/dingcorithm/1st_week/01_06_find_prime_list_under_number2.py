"""
❓ Q. 정수를 입력 했을 때, 그 정수 이하의 소수를 모두 반환하시오. 

소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다.

</aside>

```python
# 20이 입력된다면, 아래와 같이 반환해야 합니다!
[2, 3, 5, 7, 11, 13, 17, 19]
```

아리스토레네스의 채 방법 써서 해결할 것임
1. input 만큼의 배열을 만듦 -> prime_array
2. input 만큼 loop 돌면서 i * i 한 다음 i++ 함
3. 만약 prime_array 칸 비어 있으면 넘어감
"""

input = 23


def find_prime_list_under_number(number):
    # 이 부분을 채워보세요!
    prime_list = []
    for n in range(2, number + 1):
        for i in prime_list:
            if n % i == 0: # 소수가 아님
                break
        else: # break 가 발생하지 않으면, 이라는 문법
            prime_list.append(n)
 
    return prime_list


result = find_prime_list_under_number(input)
print(result)