# Recursion - 재귀함수

## 재귀 함수?
<u>재귀(recursion)의 사전적 의미</u>는 아래와 같다.
> "어떠한 것을 정의할 때 자기 자신을 참조하는 것을 뜻한다."

즉, 재귀 함수는 자기 자신을 호출하는 함수 라는 의미로 생각하면 되겠다.<br />
자기 자신을 호출하고 호출한다는 것에서 반복문이랑 비슷해 보일 수 있지만 분명 차이가 존재한다.
* 메모리 효율과 속도 측면에서는 반복문이 낫다.
  * 반복문은 CPU 사이클을 사용한다. 
  * 재귀함수 호출은 **스택 메모리에 함수를 누적해서 사용하는 것이기 때문에** 자칫하면 스택오버플로우를 발생시킬 수 있으며 속도도 반복문에 비해 느리다.
* 재귀 함수는 가독성이 좋다.

위의 차이를 본다면 반복문과 재귀함수 호출 중 반복문을 사용하는 게 더 효율적으로 느껴질 수 있다.<br/>
그럼에도 불구하고, **재귀호출를 많이 사용하는 이유가 있다.**

1. 변수의 개수를 줄일 수 있다.
대표적으로, 변수가(variable)의 개수가 줄어든다.
이는 mutable state(변경 가능한 상태)를 줄임으로서 프로그램 오류가 발생할 수 있는 가능성과 인간이 실수할 가능성을 줄일 수 있다.<br/>

2. 알고리즘 자체가 재귀가 더 자연스러울 때에
수열의 점화식을 보더라도 f(n)을 구하려면 f(n-1) f(n-2) ... 도 구해야하는데 인자만 바꾸어 함수 자기 자신을 호출하면 된다.<br />
물론 반복문으로도 가능하지만 재귀호출을 이용하면 더욱 간단하게 구현할 수 있다.

> 저번 시간의 예시를 들어 좀 더 자세히 설명해보도록 하겠다.

## 저번 시간 - MakeTen
저번에 시간에 4개의 숫자를 받고나서 모든 그 숫자들로 만들 수 있는 모든 순열을 구했다. 왜냐하면 순서가 연산 결과에 영향을 끼치기 때문이다.

[해당 클래스](../bruteForce/makeTen/MakeTen.java)를 보면 아래와 같은 메서드가 있다.
```java
/**
 * 재귀 함수를 이용하여 입력받은 4개의 숫자를 이용해 조합할 수 있는 모든 경우의 수를 만들어낸다.
 * @param val 입력받은 4개의 숫자
 * @param start 여기 인덱스의 요소에 i 인덱스의 숫자가 들어가서 만들 수 있는 모든 경우의 수를 계산한다.
 *              start + 1로 permute 함수를 재귀적으로 호출하여, start 다음 위치부터 나머지 배열에 대한 모든 순열을 생성
 * @param everyCases 모든 경우의 수가 담길 Set
 */
private void permute(int[] val, int start, Set<String> everyCases){
    if(start >= val.length){
        for(int num : val) sb.append(num);
        everyCases.add(sb.toString());
        sb.setLength(0); // StringBuilder 초기화
    } else {
        for (int i = start; i < val.length; i++){
            swap(val, start, i);
            permute(val, start + 1, everyCases);
            swap(val, start, i);
        }
    }
}
```

하지만 이 메서드를 재귀를 사용하지 않고 반복문으로 한다면 아래와 같은 메서드가 된다.<br/>
부끄럽지만, 실제로 처음엔 아래와 같은 방식으로 했었다,,,
```java
/**
 * 4개의 수를 조합하여 12개의 경우의 수를 만들어내는 메소드
 * @param val 입력받은 4개의 숫자
 * @return 4개의 수를 조합하여 만든 12개의 경우의 수 문자열
 */
private Set<String> permute(int[] val){
    int len = val.length;
    Set<String> everyCases = new HashSet<>();
    for(int i = 0; i < len; i++){
        String str = "";
        str += String.valueOf(val[i]);
        for(int j = 0; j < len; j++){
            if(j != i) {
                str += String.valueOf(val[j]);
                for (int k = 0; k < len; k++) {
                    if(k != j && k != i){
                        str += String.valueOf(val[k]);
                        for(int l = 0; l < len; l++){
                            if(l != k && l != j && l != i) {
                                str += String.valueOf(val[l]);
                                everyCases.add(str);
                                str = str.substring(0, 3);
                            }
                        }
                        str = str.substring(0, 2);
                    }
                }
                str = str.substring(0, 1);
            }
        }
    }
    return everyCases;
}
```
위 메서드를 보면 몇 가지 문제점이 보인다.
* 반복문의 depth가 깊어질 때마다 변수가 하나씩 생긴다. 그리고 반복문이 for loop도 생기니 코드도 길어진다. 이 때문에 코드의 가독성이 떨어진다.
* 만약 로직의 어떤 부분이 잘못 되어서 고쳐야한다면 동일한 기능을 담당하는 부분들을 일일히 다 똑같이 수정해야하므로 프로그램의 오류가 발생할 수 있는 인간이 실수할 가능성이 높다.
* 지금은 4개 수의 순열을 구하는 것이라서 이 정도에서 끝나지, 만약 10개 수의 순열을 구해야한다고 상상해본다면 코드양은 많아지고 복잡도는 증가할 것이 너무 분명하다.

그에 반해 재귀함수로 된 메서드는 제대로만 만들어 놓는다면
* depth가 깊어질 때마다 변수를 추가할 필요도, 코드가 길어질 필요도 없다.
* 반복문에서처럼 한 부분이 수정하기 위해 동일한 역할을 하는 다른 부분들을 수정할 이유도 없다.

> 이처럼 재귀 함수를 자유자재로 사용하게 되면 탐색 알고리즘의 폭이 넓어지게 된다.

## 이번시간에는 무엇을 하나?
DFS를 이용하여 순열과 조합을 만드는 재귀함수를 만들고, 10개의 수를 이용해 100을 만드는 고마치잔 퍼즐을 만들어보도록 하겠다.
* [순열](./basic/permutation/README.md)
* [조합](./basic/combination/README.md)