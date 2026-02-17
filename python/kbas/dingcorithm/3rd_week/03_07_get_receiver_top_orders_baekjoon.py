"""
kbas.python.kbas.dingcorithm.3rd_week.03_07_get_receiver_top_orders의 Docstring

https://www.acmicpc.net/problem/2493

Q. 수평 직선에 탑 N대를 세웠습니다. 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다.
발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다. 또한 ,한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.

예를 들어 높이가 6, 9, 5, 7, 4 인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 
그러면, 탑은 다음과 같이 신호를 주고 받습니다. 

높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑에서 수신하고, 
높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 
높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 

높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 
어떤 탑에서도 수신할 수 없습니다.

이 때, 맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때
각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 반환하시오. 만약 신호를 수신하는 탑이 없으면 0으로 표시합니다.
"""

N = int(input())
tops = list(map(int, input().split()))

def get_receiver_top_orders(N, tops):
    stack = []
    answer = [0] * N
    
    for i in range(N):
        # 현재 탑보다 낮은 탑은 스택에서 제거.
        while stack and stack[-1][1] < tops[i]:
            stack.pop()
        # 스택이 비어 있지 않다면, 가장 위의 탑이 수신탑임
        if stack:
            answer[i] = stack[-1][0] + 1
        # 현재 탑 정보를 stack에 추가
        stack.append([i, tops[i]])
    
    print(" ".join(map(str, answer)))

get_receiver_top_orders(N, tops)