class Person:
    # 생성자
    def __init__(self, name_param):
        # self는 자기 객체의 정보
        # 이 객체의 name 프로퍼티를 설정
        self.name = name_param
        print("Hello world! I'm born", self, self.name)

    # self는 자기 객체의 정보
    # 메서드
    def talk(self):
        print('안녕하세요 저는 ', self.name, '입니다.')


person_1 = Person("유재석")
person_1.talk()

person_2 = Person("박명수")
person_2.talk()