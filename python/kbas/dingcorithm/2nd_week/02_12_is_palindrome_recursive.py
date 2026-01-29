"""
kbas.python.kbas.dingcorithm.2nd_week.02_12_is_palindrome_recursive의 Docstring
Q. 다음과 같이 문자열이 입력되었을 때, 회문이라면 True 아니라면 False 를 반환하시오.
"""

# 재귀함수는 문제의 범위를 조금씩 좁혀가는 것

input = "abcba"


def is_palindrome(string):
    if len(string) <= 1:
        return True

    if string[0] != string[-1]:
        return False
    
    return is_palindrome(string[1:-1])
    
        


print(is_palindrome(input))