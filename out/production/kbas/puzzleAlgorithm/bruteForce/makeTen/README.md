# 텐퍼즐(ten puzzle): 완전 탐색

## 텐퍼즐이란?
**텐퍼즐**은 주어진 4개의 수로 사칙연산을 조합해 만들고자 하는 수(대개 10)를 만드는 퍼즐이다. 

<u>예를 들어,</u>
<br/>
1, 2, 3, 4 를 이용하여 10을 만드는 방법은 **1 + 2 + 3 + 4** 혹은 **(4 * 3) - (2 * 1)** 등이 있다.
<br/>
<br/>
<u>좀 더 어렵게 하자면,</u><br/>
1, 2, 7, 7 을 이용해 10을 만드는 방법은 **(7 - 1) / 2 + 7** 등이 있으며
<br />
<br />
<u>더더욱 어렵게 하자면,</u><br/>
1, 3, 3, 7 을 이용해 만드는 방법으로는 **(1 + 7 / 3) * 3**이 있겠다.

## 풀이 방법
사실 이 문제는 이 문제는 이론적으로 '4개의 수를 사용한 계산식'을 전부 알아 보야야 풀 수 있다. 
이처럼 생각할 수 있는 모든 경우를 알아보는 방법을 <u>**완전 탐색**(brute-force search)</u>라고 한다.

보통 문제 풀이를 할 때에 가장 간단하고도 무식한(?) 방법은 완전탐색인데, 완전탐색 알고리즘을 선택하기 전에 두 가지 사항을 고려해야 한다.
이따가 다시 이야기하겠지만, 고려해야 할 사항은 아래와 같다.
 * 생각할 수 있는 경우를 어떻게 열거할 것인가?
 * 경우의 수는 몇가지가 나오는가?
<br/>

### 역폴란드 표기법(reverse Polish notation)
일반적인 계산식은 연산자가 계산하는 숫자들 사이에 들어간다. 이렇게 말이다. => **1 + 2** <br/>
역폴란드 표기법은 연산자가 계산하는 숫자들 뒤 쪽으로 옮겨진다. 이렇게 말이다. => **12+**

역폴란드 표기법을 이용하면 두 수의 연산 뿐 아니라 복잡한 계산식도 보다 간결해진다고 한다. <br/>
**1 + 2 + 3 + 4** 계산식을 역폴란드 표기법으로 풀어본다면 아래와 같다.<br />
```
12+3+4+
```
**(4 * 3) - (2 * 1)** 계산식을 역폴란드 표기법으로 풀어본다면 아래와 같다.<br />
```
43*21*-
```
**(7 - 1) / 2 + 7** 계산식을 역폴란드 표기법으로 풀어본다면 아래와 같다.<br />
```
71-2/7+
```
**(1 + 7 / 3) * 3** 계산식을 역폴란드 표기법으로 풀어본다면 아래와 같다.
```
173/+3*
```
순서 말고 중요한 차이점이 보이는가, **계산식에서 괄호가 필요 없어졌다!**<br/>
텐게임에 필요한 숫자는 4개이며 연산자는 3개가 필요하다. 괄호가 필요 없어졌으니 어떠한 계산식이든 모두 7글자로 이루어진다.

좋다. 우리는 이렇게 해볼 것이다.<br/>
예를 들어, **"12+3+4+"** 라는 계산식이 들어온다면 앞에서부터 한글자씩 읽어들여서 문자가 숫자라면 배열 말미에 삽입하고, 연산자가 들어온다면
배열 맨 뒤 두 숫자를 "꺼내서" 해당 연산자에 따라 계산한 후 다시 배열의 맨 뒤에 삽입할 것이다.<br/>
맨 마지막에 남은 숫자 하나가 바로 계산 결과이다.<br/>
구현 코드는 역폴란드 표기법으로 계산된 수식을 계산하는 함수인 <u>**calcPoland()**</u>를 참고하기 바란다.<br/>

## 완전탐색 시 고려사항
앞서 말했다시피 보통 문제 풀이를 할 때에 가장 간단하고도 무식한(?) 방법은 완전탐색이다.<br />
<u>하지만 과연 일일히 모든 경우의 수를 조합하는 이 방법이 효율적일까?</u>

### 컴퓨터의 계산 능력
일반적으로 문제를 푸는 알고리즘을 판단하려면 컴퓨터의 계산 능력을 알아야 한다.<br/>
평범한 가정용 컴퓨터를 사용할 경우, <u>1초 동안 처리 가능한 계산 스텝횟수는 **약 10억 회**</u>라고 한다.

10억 회 반복문을 수행한다면 
``` java
for(int i = 0; i < 1000000000; i++){
    
}
```