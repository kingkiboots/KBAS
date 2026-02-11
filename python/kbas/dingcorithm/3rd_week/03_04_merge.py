'''
kbas.python.kbas.dingcorithm.3rd_week.03_04_merge의 Docstring

병합 정렬은 면접에서 직접 구현해보라고 할만큼 굉장히 중요한 알고리즘
배열의 앞부분과 뒷부분의 두 그룹으로 나누어 각각 정렬한 후 병합하는 작업을 반복하는 알고리즘이다.
'''

array_a = [1, 2, 3, 5]
array_b = [4, 6, 7, 8]

def merge(array1, array2):
    # 이 부분을 채워보세요
    result = []

    array1_index = 0
    array2_index = 0

    while array1_index < len(array1) and array2_index < len(array2):
        if array1[array1_index] < array2[array2_index]:
            result.append(array1[array1_index])
            array1_index += 1
        elif array1[array1_index] > array2[array2_index]:
            result.append(array2[array2_index])
            array2_index += 1
        else:
            result.append(array1[array1_index])
            array1_index += 1
            result.append(array2[array2_index])
            array2_index += 1

    while array1_index < len(array1):
        result.append(array1[array1_index])
        array1_index += 1
    
    while array2_index < len(array2):
        result.append(array2[array2_index])
        array2_index += 1

    return result


print(merge(array_a, array_b))  # [1, 2, 3, 4, 5, 6, 7, 8] 가 되어야 합니다!

print("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = ", merge([-7, -1, 9, 40], [5, 6, 10, 11]))
print("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = ", merge([-1,2,3,5,40], [10,78,100]))
print("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = ", merge([-1,-1,0], [1, 6, 9, 10]))