# MergeSort(0, N) = Merge(MergeSort(0, N/2) + MergeSort(N/2, N))

# O(N)
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


# O(N)?? nono. N ? 2 ^ k => log N * N
def merge_sort(array):
    if len(array) <= 1:
        return array

    mid = (0 + len(array)) // 2
    left_array = merge_sort(array[:mid]) # 왼쪽 부분을 정렬하고
    right_array = merge_sort(array[mid:]) # 오른쪽 부분을 정렬하고
    print(left_array, right_array)
    return merge(left_array, right_array)

print(merge_sort([5,3,1,2,6,8,7,4]))