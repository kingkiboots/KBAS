finding_target = 14
finding_numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]


# N / 2
# N / 4
# N / 8
# N / 2^k

# N = 2^k
# log_2(N)

# O(log(N))
# 연산량이 반에반으로 나눠지면 log(N) 이라고 간단히 생각해보자

def is_existing_target_number_binary(target, array):
    # 구현해보세요!
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


result = is_existing_target_number_binary(finding_target, finding_numbers)
print(result)