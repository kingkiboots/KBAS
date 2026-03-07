"""
Q. 오늘 수업에 많은 학생들이 참여했습니다. 단 한 명의 학생을 제외하고는 모든 학생이 출석했습니다. 

모든 학생의 이름이 담긴 배열과 출석한 학생들의 배열이 주어질 때, 출석하지 않은 학생의 이름을 반환하시오.
"""

all_students = ["나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"]
present_students = ["정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현"]


def get_absent_student(all_array, present_array):
    # 구현해보세요!
    # O(N): set은 탐색할 떄 시간 복잡도가 O(1)이다
    # absent_students = []
    # present_set = set(present_array)

    # for student in all_array:
    #     if student not in present_set:
    #         return student

    # 이런 풀이도 됨
    # all_set = set(all_array)
    # present_set = set(present_array)
    # return all_set - present_set

    # 해쉬 테이블을 써보자
    dict = {}
    for key in all_array:
        dict[key] = True # 아무 값이나 넣어도 상관 없음. 여기서 중요한 것은 키
    
    for key in present_array:
        del dict[key] # 삭제 연산이 더 무거운 편임
    
    for key in dict.keys():
        return key # 한 명만 출석 안 한 걸 알고 있으니 이렇게 해도 됨


print(get_absent_student(all_students, present_students))

print("정답 = 예지 / 현재 풀이 값 = ",get_absent_student(["류진","예지","채령","리아","유나"],["리아","류진","채령","유나"]))
print("정답 = RM / 현재 풀이 값 = ",get_absent_student(["정국","진","뷔","슈가","지민","RM"],["뷔","정국","지민","진","슈가"]))