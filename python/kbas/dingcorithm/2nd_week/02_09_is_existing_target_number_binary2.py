"""
kbas.python.kbas.dingcorithm.2nd_week.02_09_is_existing_target_number_binary2의 Docstring


❓ Q. 다음과 같이 숫자로 이루어진 배열이 있을 때, 
2이 존재한다면 True 존재하지 않는다면 False 를 반환하시오.

```python
[0, 3, 5, 6, 1, 2, 4]
```
"""

finding_target = 2
finding_numbers = [0, 3, 5, 6, 1, 2, 4]


# 하하 근데 이진 탐색법은 무작위로 정렬된 배열에서는 범위를 확실히 자를 수가 없어서 활용할 수 없음
def is_exist_target_number_binary(target, array):
    # 이 부분을 채워보세요!
    min_num, max_num = 0, len(array) - 1
    guess = (min_num + max_num) // 2

    while min_num <= max_num:
        if array[guess] == target:
            return True
        elif array[guess] < target:
            min_num = guess + 1
        else: # array[guess] > target
            max_num = guess - 1

        guess = (min_num + max_num) // 2

    return False


result = is_exist_target_number_binary(finding_target, finding_numbers)
print(result)