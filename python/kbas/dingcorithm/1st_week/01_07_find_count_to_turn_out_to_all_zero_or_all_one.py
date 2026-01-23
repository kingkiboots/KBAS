"""
kbas.python.kbas.dingcorithm.1st_week.01_07_find_count_to_turn_out_to_all_zero_or_all_one의 Docstring

Q. 
0과 1로만 이루어진 문자열이 주어졌을 때, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다. 할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.

예를 들어 S=0001100 일 때,

전체를 뒤집으면 1110011이 된다.
4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.

주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.
"""

"""
연속된 숫자의 집합을 구할까?

001100
[0, 1, 0]
{ 0: 2, 1: 1 }


0101010110
[0,1,0,1,0,1,0,1,0]
{
0: 5,
1: 4
}
그리고 연속된 숫자의 집합이 적은 애가 최소로 뒤집을 수 있는 거
"""

input = "0101010101"


def find_count_to_turn_out_to_all_zero_or_all_one(string):
    # 이 부분을 채워보세요!
    zero_or_one_occurrance = [0] * 2
    #첫번쨰 숫자
    current_num = string[0]
    #첫번째 숫자의 집합 += 1
    zero_or_one_occurrance[int(current_num)] = 1
    # 인덱스 1부터 loop 시작
    for num in string[1:]:
        # 연속된 숫자면 뭐 더 안함
        if num == current_num:
            continue
        # 다른 숫자 등장임
        # 비교할 현재 숫자 변경
        current_num = num
        # 숫자 집합 개수 + 1
        zero_or_one_occurrance[int(num)] += 1

    return min(zero_or_one_occurrance)


result = find_count_to_turn_out_to_all_zero_or_all_one(input)
print(result)