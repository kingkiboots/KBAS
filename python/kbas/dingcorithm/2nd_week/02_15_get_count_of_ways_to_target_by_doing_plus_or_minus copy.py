"""
kbas.python.kbas.dingcorithm.2nd_week.02_15_get_count_of_ways_to_target_by_doing_plus_or_minus의 Docstring

Q. 음이 아닌 정수들로 이루어진 배열이 있다. 
이 수를 적절히 더하거나 빼서 특정한 숫자를 만들려고 한다. 
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들기 위해서는 다음 다섯 방법을 쓸 수 있다.

https://school.programmers.co.kr/learn/courses/30/lessons/43165

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

사용할 수 있는 숫자가 담긴 배열 numbers, 
타겟 넘버 target_number이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
타겟 넘버를 만드는 방법의 수를 반환하시오.
"""

numbers = [1, 1, 1, 1, 1]
target_number = 3

OPS_ADD = '+'
OPS_MINUS = '-'
OPTS = [OPS_ADD, OPS_MINUS]

answer = 0
def calculate(numbers, opts):
    result = 0

    for index in range(len(opts)):
        if opts[index] == OPS_MINUS:
            result -= numbers[index]
        else:
            result += numbers[index]
    return result


def assemble_opts(numbers, target, opts, depth):
    global answer
    if depth == len(opts):
        if calculate(numbers, opts) == target:
            answer += 1
    else:
        for opt in OPTS:
            opts[depth] = opt
            assemble_opts(numbers, target, opts, depth + 1)
            opts[depth] = None
            

def get_count_of_ways_to_target_by_doing_plus_or_minus(array, target):
    global answer

    opts = [None] * len(array)
    assemble_opts(array, target, opts, 0)

    return answer


print(get_count_of_ways_to_target_by_doing_plus_or_minus(numbers, target_number))  # 5를 반환해야 합니다!