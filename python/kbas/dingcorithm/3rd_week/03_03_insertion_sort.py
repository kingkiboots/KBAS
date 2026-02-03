"""
kbas.python.kbas.dingcorithm.3rd_week.03_03_insertion_sort의 Docstring

Q. 다음과 같이 숫자로 이루어진 배열이 있을 때, 오름차순으로 삽입 정렬을 이용해서 정렬하시오.
"""

# 삽입정렬: 이미 앞에는 정렬이 되어있다는 가정 하에... O(N^2)이 O(N)이 될 수 있음

input = [4, 6, 2, 9, 1]


def insertion_sort(array):
    # 이 부분을 채워보세요!
    n = len(array)

    for i in range(1, n):
        for j in range(i):
            cur_index = i - j
            if array[cur_index] < array[cur_index - 1]:
                array[cur_index], array[cur_index - 1] = array[cur_index - 1], array[cur_index]
            else:
                break

    return array


insertion_sort(input)
print(input) # [1, 2, 4, 6, 9] 가 되어야 합니다!

print("정답 = [4, 5, 7, 7, 8] / 현재 풀이 값 = ",insertion_sort([5,8,4,7,7]))
print("정답 = [-1, 3, 9, 17] / 현재 풀이 값 = ",insertion_sort([3,-1,17,9]))
print("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = ",insertion_sort([100,56,-3,32,44]))