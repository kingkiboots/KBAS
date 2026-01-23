"""Q. 다음과 같이 영어로 되어 있는 문자열이 있을 때, 이 문자열에서 반복되지 않는 첫번째 문자를 반환하시오. 만약 그런 문자가 없다면 _ 를 반환하시오."""


def find_alphabet_occurrence_array(string):
    occurrance_array = [0] * 26

    for char in string:
        arr_index = ord(char) - ord('a')
        occurrance_array[arr_index] += 1
    
    return occurrance_array


def find_not_repeating_first_character(string):
    # 이 부분을 채워보세요!
    occurrance_array = find_alphabet_occurrence_array(string)

    # 내 풀이
    # for char in string:
    #     arr_index = ord(char) - ord('a')
    #     occurance = occurance_array[arr_index]
    #     if occurance == 1:
    #         return char

    # 딩코 선생 풀이
    not_repeating_character = []
    for index in range(len(occurrance_array)):
        occurrance = occurrance_array[index]
        if occurrance == 1:
            ascii = index + ord('a')
            not_repeating_character.append(chr(ascii))
    
    for char in string:
        if char in not_repeating_character:
            return char

    return "_"


result = find_not_repeating_first_character
print("정답 = d 현재 풀이 값 =", result("abadabac"))
print("정답 = c 현재 풀이 값 =", result("aabbcddd"))
print("정답 =_ 현재 풀이 값 =", result("aaaaaaaa"))