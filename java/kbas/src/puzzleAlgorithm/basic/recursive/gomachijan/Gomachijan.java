package puzzleAlgorithm.basic.recursive.gomachijan;

import java.util.*;

/**
 * 내가 한번 해본 버전
 */
public class Gomachijan {

    private final char EMPTY = 0;
    private final char PLUS = 1;
    private final char MINUS = 2;
    private final char MUL = 3;
    private final char DIV = 4;

    private final char[] OPS = { EMPTY, PLUS, MINUS, MUL, DIV };
    // 재귀 안에서 매번 생성해 쓰는 것보단 이렇게 상수로 한번 만들어 놓고 쓰는게 효율적
    private final int OPS_MAX;

    private final StringBuilder sb = new StringBuilder();
    Set<String> res = new HashSet<>();

    // 만들고자 하는 수
    private final double TARGET;

    Gomachijan(double target){
        this.TARGET = target;
        this.OPS_MAX = 8;
    }

    private AbstractMap.SimpleEntry<List<Double>, List<Character>> makePair(List<Double> newValues, List<Character> newSigns) {
        return new AbstractMap.SimpleEntry<>(newValues, newSigns);
    }

    /**
     * 공백 포함 모든 연산자의 경우의 수를 연산하는 재귀함수
     * @param depth 깊이
     * @param signs 연산이 완료된 경우의 수를 담는 배열 오브젝트
     */
    private void calcEverySign(int depth, List<String> signs) {
        // 재귀 종료 조건: depth의 깊이가 8일 때.
        if(depth == OPS_MAX){
            // 연산자 경우의 수를 추가 한다.
            signs.add(sb.toString());
            // 재귀 종료
            return;
        }

        // 공백 포함 모든 연산자를 살핀다.
        for(char op : OPS){
            // 연산자 문자열 말미에 새로운 연산자를 붙힌다.
            sb.append(op);
            // 재귀 호출
            calcEverySign(depth + 1, signs);
            // 연산자 문자열 말미에 추가했던 연산자를 지운다.
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * [ ]에 넣은 연산자 중 공백을 연결하는 함수
     * @param signs 연산자
     * @return 공백이 처리되고 난 후 남은 숫자와 연산자의 튜플
     */
    private AbstractMap.SimpleEntry<List<Double>, List<Character>> calcEmpty(char[] signs){
        // 공백 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList<>(); // 수
        List<Character> newSigns = new ArrayList<>(); // 연산자

        // 도중 경과 값(고마치잔의 맨 처음 값은 1이다)
        double val = 1;

        // 연산자를 순서대로 살펴본다.
        for (int i = 0; i < signs.length; ++i){
            // 새로운 수(i=0, ..., 7일 때 add=2, ..., 9) => 다음 숫자네;
            double add = i + 2;
            
            if (signs[i] == EMPTY){
                // 공백일 경우 수를 연결한다. (ex: 23 x 10 + 4 = 234)
                val = val * 10 + add;
            } else {
                // 그렇지 않은 경우 연산자와 조합을 새로 기록한다.
                newValues.add(val);
                newSigns.add(signs[i]);

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
    private AbstractMap.SimpleEntry<List<Double>, List<Character>> calcMulDiv(List<Double> vals, List<Character> signs) {
        // 곱셈 나눗셈 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList<>(); // 수
        List<Character> newSigns = new ArrayList<>(); // 연산자

        // 도중 경과값
        double val = vals.get(0);

        // 연산자를 순서대로 살펴본다.
        for(int i = 0; i < signs.size(); i++){
            // 새로운 수. 즉 다음에 올 숫자
            double add = vals.get(i + 1);
            char sign = signs.get(i);

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
    private double calcPlusMinus(List<Double> vals, List<Character> signs) {
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
    private double calc(String signs) {
        // step1: 공백 연결
        AbstractMap.SimpleEntry<List<Double>, List<Character>> step1 = calcEmpty(signs.toCharArray());
        
        // step2: 곱셈, 나눗셈
        AbstractMap.SimpleEntry<List<Double>, List<Character>> step2 = calcMulDiv(step1.getKey(), step1.getValue());
        
        // step3: 덧셈, 뺄셈
        return calcPlusMinus(step2.getKey(), step2.getValue());
    }

    private void check(double calcRes, String signs){
        double EPS = 1e-9; // 충분히 작은 값


        if (Math.abs(calcRes - TARGET) < EPS){
            String decoded = decode(signs);
            res.add(decoded);
        }
    }

    /**
     * []에 넣은 연산자를 지정했을 때 구체적인 계산식을 복원한다.
     * @param signs 연산자가 담긴 배열
     * @return 계산식
     */
    private String decode (String signs) {
        // 중간 값
        int val = 1;
        sb.setLength(0);
        sb.append(val);

        for(int i = 0; i < signs.length(); i++){
            int add = i + 2;
            // 연산자 추가
            switch (signs.charAt(i)){
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

    void solve() {
        List<String> everySigns = new ArrayList<>();
        calcEverySign(0, everySigns);

        for(String signs: everySigns){
            double calcRes = calc(signs);
            check(calcRes, signs);
        }

        for(String one : res){
            System.out.println(one);
        }
        System.out.println(res.size());
    }

    public static void main(String[] args) {
        Gomachijan gomachijan = new Gomachijan(2022);
        gomachijan.solve();
    }
}
