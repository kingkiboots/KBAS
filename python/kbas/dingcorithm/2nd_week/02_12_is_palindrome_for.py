"""
kbas.python.kbas.dingcorithm.2nd_week.02_12_is_palindrome_recursive의 Docstring
Q. 다음과 같이 문자열이 입력되었을 때, 회문이라면 True 아니라면 False 를 반환하시오.

"""

input = "abcba"


def is_palindrome(string):
    n = len(string)
    last_index = n - 1

    for i in range(n // 2):
        if string[i] == string[last_index - i]:
            continue
        return False

    return True


print(is_palindrome(input))