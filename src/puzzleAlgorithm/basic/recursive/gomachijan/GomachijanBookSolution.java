package puzzleAlgorithm.basic.recursive.gomachijan;

import java.util.*;

/**
 * 책에 되어있는 버전 (GPT는 이게 더 낫다고 함)
 */
public class GomachijanBookSolution {

    private final int EMPTY;
    private final int PLUS = 1;
    private final int MINUS = 2;
    private final int MUL = 3;
    private final int DIV = 4;

    private final StringBuilder sb = new StringBuilder();

    // 만들고자 하는 수
    private final double TARGET;

    GomachijanBookSolution(double target){
        this.TARGET = target;
        this.EMPTY = 0;
    }

    private AbstractMap.SimpleEntry<List<Double>, List<Integer>> makePair(List<Double> newValues, List<Integer> newSigns) {
        return new AbstractMap.SimpleEntry<>(newValues, newSigns);
    }

    /**
     * [ ]에 넣은 연산자 중 공백을 연결하는 함수
     * @param signs 연산자
     * @return 공백이 처리되고 난 후 남은 숫자와 연산자의 튜플
     */
    private AbstractMap.SimpleEntry<List<Double>, List<Integer>> calcEmpty(List<Integer> signs){
        // 공백 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList<>(); // 수
        List<Integer> newSigns = new ArrayList<>(); // 연산자

        // 도중 경과 값(고마치잔의 맨 처음 값은 1이다)
        double val = 1;

        // 연산자를 순서대로 살펴본다.
        for (int i = 0; i < signs.size(); ++i){
            // 새로운 수(i=0, ..., 7일 때 add=2, ..., 9) => 다음 숫자네;
            double add = i + 2;
            int sign = signs.get(i);
            
            if (sign == EMPTY){
                // 공백일 경우 수를 연결한다. (ex: 23 x 10 + 4 = 234)
                val = val * 10 + add;
            } else {
                // 그렇지 않은 경우 연산자와 조합을 새로 기록한다.
                newValues.add(val);
                newSigns.add(sign);

                // [ ] 직후의 새 값을 val에 기록한다.
                val = add;
            }
        }

        // 마지막 값을 push 해서 답을 반환한다.
        newValues.add(val);
        return makePair(newValues, newSigns);
    }

    /**
     * 연산자 중 곱셈 나눗셈을 처리하는 함수
     * @param vals 연산할 숫자
     * @param signs 연산자
     * @return 곱셈 나눗셈이 처리되고 난 후 남은 숫자와 연산자의 튜플
     */
    private AbstractMap.SimpleEntry<List<Double>, List<Integer>> calcMulDiv(List<Double> vals, List<Integer> signs) {
        // 곱셈 나눗셈 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList<>(); // 수
        List<Integer> newSigns = new ArrayList<>(); // 연산자

        // 도중 경과값
        double val = vals.get(0);

        // 연산자를 순서대로 살펴본다.
        for(int i = 0; i < signs.size(); i++){
            // 새로운 수. 즉 다음에 올 숫자
            double add = vals.get(i + 1);
            int sign = signs.get(i);

            if(sign == MUL){
                val *= add;
                continue;
            }

            if(sign == DIV){
                val /= add;
                continue;
            }

            // 곱셈 나눗셈이 아닐 경우 수와 연산자의 조합을 새로 기록한다.
            newValues.add(val);
            newSigns.add(sign);

            // [] 직후의 새 값을 val에 기록한다.
            val = add;
        }

        // 마지막에 값을 push 해서 답을 반환한다.
        newValues.add(val);
        return makePair(newValues, newSigns);
    }

    /**
     * 연산자 중 덧셈 뺄셈을 처리하는 함수
     * @param vals 연산할 숫자
     * @param signs 연산자
     * @return 최종 연산값
     */
    private double calcPlusMinus(List<Double> vals, List<Integer> signs) {
        // 도중 경과값
        double val = vals.get(0);

        // 연산자를 순서대로 살펴본다.
        for(int i = 0; i < signs.size(); i++){
            // 새로운 수. 즉 다음에 올 숫자
            double add = vals.get(i + 1);
            int sign = signs.get(i);

            if(sign == PLUS){
                val += add;
                continue;
            }

            if(sign == MINUS){
                val -= add;
            }
        }

        return val;
    }

    /**
     * 
     * @param signs 연산자가 나열된 배열
     * @return 계산된 값
     */
    private double calc(List<Integer> signs) {
        // step1: 공백 연결
        AbstractMap.SimpleEntry<List<Double>, List<Integer>> step1 = calcEmpty(signs);

        // step2: 곱셈, 나눗셈
        AbstractMap.SimpleEntry<List<Double>, List<Integer>> step2 = calcMulDiv(step1.getKey(), step1.getValue());
        
        // step3: 덧셈, 뺄셈
        return calcPlusMinus(step2.getKey(), step2.getValue());
    }

    /**
     * []에 넣은 연산자를 지정했을 때 구체적인 계산식을 복원한다.
     * @param signs 연산자가 담긴 배열
     * @return 계산식
     */
    private String decode (List<Integer> signs) {
        // 중간 값
        int val = 1;
        sb.setLength(0);
        sb.append(val);

        for(int i = 0; i < signs.size(); i++){
            int add = i + 2;
            // 연산자 추가
            switch (signs.get(i)){
                case MUL:
                    sb.append(" * ");
                    break;
                case DIV:
                    sb.append(" / ");
                    break;
                case PLUS:
                    sb.append(" + ");
                    break;
                case MINUS:
                    sb.append(" - ");
                    break;
                default:
            }
            
            // 수 추가
            sb.append(add);
        }

        return sb.toString();
    }

    /**
     * 책에서 제시한 문제푸는 방법 (재귀함수를 이렇게 활용했음)
     * @param vec 재귀 함수를 처리하기 위한 배열
     * @param res 해를 저장한 배열
     */
    void rec(List<Integer> vec, List<String> res) {
        // 종료조건: vec의 크기가 8
        if(vec.size() == 8){
            // 계산 결과와 값 100의 차이가 충분히 작을 때 일치한다고 간주한다.
            double EPS = 1e-9;
            if(Math.abs(calc(vec) - TARGET) < EPS){
                res.add(decode(vec));
            }

            // 재귀처리를 마친다.
            return;
        }

        // vec 말미에 값 5를 순서대로 삽입해 시험한다. 공백, 곱, 나, 덧, 뺄 연산자임.
        for (int add = 0 ; add < 5; ++add){
            vec.add(add);
            rec(vec, res);
            vec.remove(vec.size() - 1);
        }
    }

    void solve() {
        // 재귀 함수를 처리하기 위한 빈 배열을 정의한다.
        List<Integer> vec = new ArrayList<>();

        // 해를 저장한 배열
        List<String> res = new ArrayList<>();

        // 재귀적으로 구한다.
        rec(vec, res);

        // 답을 출력한다.
        for(String str : res){
            System.out.println(str + " = " + TARGET);
        }

        System.out.println("The number of solutions: " + res.size());
    }

    public static void main(String[] args) {
        GomachijanBookSolution gomachijan = new GomachijanBookSolution(100);
        gomachijan.solve();
    }
}
