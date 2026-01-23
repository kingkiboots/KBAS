def find_alphabet_occurrence_array(string):
    # 알파벳이 총 26개니깐
    alphabet_occurrence_array = [0] * 26

    # 이 부분을 세세요.
    for char in string:
        if not char.isalpha():  # 알파벳인지 검사
            continue
        arr_index = ord(char) - ord('a')    # 인덱스로 치환
        alphabet_occurrence_array[arr_index] += 1   # 빈도수 배열의 인덱스로 찾아가 값 업데이트

    return alphabet_occurrence_array

# 문제 어떻게 풀것인가
# 1. find_alphabet_occurrence_array 함수를 통해 a-z 순서로 배열에 등장 개수 보관한 배열 추출
# 2. 숫자가 제일 큰거를 뽑아야겠지?
# 3. 숫자가 제일 큰 애의 인덱스를 보관. 
# 4. 그러면 알파벳 순서로 먼저인 애가 우선순위가 됨
# 5. 알파벳을 반환해야하는데, 그거는 ord(), chr()을 통한 ascii 를 활용
# 6. 가장 큰 인덱스 + ord('a') 는 가장 많이 등장한 알파벳의 ascii 코드
# 7. 이를 chr() 해서 char 값으로 재변환하자

def find_max_occurred_alphabet(string):
    # 이 부분을 채워보세요!
    alphabet_occurrence_array = find_alphabet_occurrence_array(string)

    most_frequent_alphabet_index = 0
    for current_index in range(1, len(alphabet_occurrence_array)):
        most_frequent_alphabet_occurance = alphabet_occurrence_array[most_frequent_alphabet_index]
        current_alphabet_occurance = alphabet_occurrence_array[current_index]

        if most_frequent_alphabet_occurance >= current_alphabet_occurance:
            continue

        most_frequent_alphabet_index = current_index

    return chr(most_frequent_alphabet_index + ord('a'))


result = find_max_occurred_alphabet
print("정답 = i 현재 풀이 값 =", result("hello my name is dingcodingco"))
print("정답 = e 현재 풀이 값 =", result("we love algorithm"))
print("정답 = b 현재 풀이 값 =", result("best of best youtube"))

# 딩코 선생의 풀이 1
print('========== dingco solution 1 ==========')
def dingco_find_max_occurred_alphabet(string):
    alphabet_array = ['a', 'b' ,'c' ,'d' ,'e' ,'f' ,'g','h' ,'i' ,'j' ,'k' ,'l' ,'m' ,
                      'n' ,'o' ,'p' ,'q' ,'r' ,'s' ,'t' ,'u' ,'v' ,'w' ,'x' ,'y' ,'z']
    
    max_occurance = 0
    max_alphabet = alphabet_array[0]

    for alphabet in alphabet_array:
        occurance = 0

        for char in string:
            if char == alphabet:
                occurance += 1

        if max_occurance < occurance:
            max_alphabet = alphabet
            max_occurance = occurance

    return max_alphabet

result = dingco_find_max_occurred_alphabet
print("정답 = i 현재 풀이 값 =", result("hello my name is dingcodingco"))
print("정답 = e 현재 풀이 값 =", result("we love algorithm"))
print("정답 = b 현재 풀이 값 =", result("best of best youtube"))


# 딩코 선생의 풀이 2
print('========== dingco solution 2 ==========')
def dingco_second_find_max_occurred_alphabet(string):
    # 알파벳이 총 26개니깐
    alphabet_occurrence_array = [0] * 26

    # 이 부분을 세세요.
    for char in string:
        if not char.isalpha():  # 알파벳인지 검사
            continue
        arr_index = ord(char) - ord('a')    # 인덱스로 치환
        alphabet_occurrence_array[arr_index] += 1   # 빈도수 배열의 인덱스로 찾아가 값 업데이트
    
    # 빈도수를 담은 배열을 순회하면서 이 값이 최고의 값인지 확인
    max_occurance = alphabet_occurrence_array[0]
    max_alphabet = 0
    for index in range(len(alphabet_occurrence_array)):
        occurance = alphabet_occurrence_array[index]
        
        if occurance > max_occurance:
            max_occurance = occurance
            max_alphabet = index
    
    return chr(max_alphabet + ord('a'))

result = dingco_second_find_max_occurred_alphabet
print("정답 = i 현재 풀이 값 =", result("hello my name is dingcodingco"))
print("정답 = e 현재 풀이 값 =", result("we love algorithm"))
print("정답 = b 현재 풀이 값 =", result("best of best youtube"))