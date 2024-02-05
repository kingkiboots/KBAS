package puzzleAlgorithm.bruteForce.makeTen;

import java.util.ArrayList;
import java.util.List;

public class Poland {
    /**
     * 역폴란드 표기법의 계산식을 계산한다.
     * @param exp 일반 계산식
     * @return 역폴란드 표기법의 계산식
     */
    double calcPoland(String exp){
        // 계산을 위한 배열
        List space = new ArrayList<Double>();
        for(char c : exp.toCharArray()){
            if(c >= '0' && c <= '9') {
                // c가 수를 표시하는 문자일 경우
                // '7'처럼 문자 정수르르 7과 같은 수로 반환한다.
                double add =  c - '0';

                // 배열 말미에 삽입한다.
                space.add(add);
            } else {
                // c가 연산자이면 말미에서 2개의 수를 꺼낸다.
                int len = space.size();
                double second = (Double) space.remove(len - 1);
                double first = (Double) space.remove(len - 2);

                // 연산결과를 배열 말미에 삽입한다.
                switch (c){
                    case '+':
                        space.add(first + second);
                        break;
                    case '-':
                        space.add(first - second);
                        break;
                    case '*':
                        space.add(first * second);
                        break;
                    default:
                        space.add(first / second);
                        break;
                }
            }
        }
        // 배열 말미에 남아 있는 값을 반환한다.
        int len = space.size();
        double res = (double) space.get(len - 1);
        return res;
    }

    /**
     * 역폴란드 표기법 계산식에서 기존 계산식으로 복원한다.
     * @param exp 역폴란드 표기법 계산식
     * @return 역폴란드 표기법 계산식에서 기존 계산식으로 복원한 문자열
     */
    String decodePoland(String exp){
        // 기존 계산식 복원을 위한 배열
        List space = new ArrayList<String>();

        // 역폴란드 표기법 exp의 각 문자 c를 순서로 본다.
        for(char c: exp.toCharArray()){
            if(c >= '0' && c <= '9'){
                // 수를 나타내는 문자 c를 문자열로 반환해 배열 말미에 삽입한다.
                space.add(String.valueOf(c));
            } else {
                // c가 연산자이면
                int len = space.size();
                String second = (String) space.remove(len - 1);
                String first = (String) space.remove(len - 2);

                // 곱셈, 나눗셈에서는 연산자의 우선순위가 높으므로
                // 그 전후의 계산식(단독 수 제외)에 괄호를 붙힌다.
                if(c == '*' || c == '/'){
                    if(first.length() > 1)
                        first = "(" + first + ")";
                    if(second.length() > 1)
                        second = "(" + second + ")";
                }

                // 연산자를 토대로 복원한 계산식을 배열 말미에 삽입한다.
                switch (c){
                    case '+':
                        space.add(first + "+" + second);
                        break;
                    case '-':
                        space.add(first + "-" + second);
                        break;
                    case '*':
                        space.add(first + "*" + second);
                        break;
                    default:
                        space.add(first + "/"+  second);
                        break;
                }
            }
        }
        int len = space.size();
        String res = (String) space.get(len - 1);
        return res;
    }
}
