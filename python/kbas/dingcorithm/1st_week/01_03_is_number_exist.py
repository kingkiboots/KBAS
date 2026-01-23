# Q. 다음과 같은 숫자로 이루어진 배열이 있을 때, 
# 이 배열 내에 특정 숫자가 존재한다면 True, 존재하지 않다면 False 를 반환하시오.
def is_number_exist(number, array):
    for n in array: # array의 길이만큼 수행
        if n == number: # 비교연산 1회 수행
            return True # 시간복잡도는 1N만큼 수행
        
    return False


result = is_number_exist
print("정답 = True 현재 풀이 값 =", result(3, [3,5,6,1,2,4])) # 바로 찾는 경우, 시간복잡도가 1임. 최선의 경우에 1만큼 의 연산만 필요 -> 오메가(1)
print("정답 = True 현재 풀이 값 =", result(4, [3,5,6,1,2,4])) # 최악의 경우, 배열 끝까지 가야하므로 시간복잡도가 N임. -> O(N)

print("정답 = Flase 현재 풀이 값 =", result(7, [6,6,6]))
print("정답 = True 현재 풀이 값 =", result(2, [6,9,2,7,1888]))

# 빅오 -> 최악의 경우
# 빅오메가 -> 최선의 경우