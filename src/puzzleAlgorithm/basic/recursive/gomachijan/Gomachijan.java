package puzzleAlgorithm.basic.recursive.gomachijan;

import java.util.*;

public class Gomachijan {

    private final char EMPTY = 0;
    private final char PLUS = 1;
    private final char MINUS = 2;
    private final char MUL = 3;
    private final char DIV = 4;

    private final char[] OPS = { EMPTY, PLUS, MINUS, MUL, DIV };

    private final StringBuilder sb = new StringBuilder();
    Set<String> res = new HashSet<>();

    double target;

    Gomachijan(double target){
        this.target = target;
    }

    private AbstractMap.SimpleEntry<List<Double>, List<Character>> makePair(List<Double> newValues, List<Character> newSigns) {
        return new AbstractMap.SimpleEntry<>(newValues, newSigns);
    }

    private void calcEverySign(int depth, List<String> signs) {
        int OPS_MAX = 8;

        if(depth == OPS_MAX){
            signs.add(sb.toString());
        }
        else {
            for(char op : OPS){
                sb.append(op);
                calcEverySign(depth + 1, signs);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /**
     * [ ]에 넣은 연산자 중 공백을 처리하는 함수
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
        // 곱셈 나눗샘 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList<>(); // 수
        List<Character> newSigns = new ArrayList<>(); // 연산잔

        // 도중 경과값
        double val = vals.get(0);

        // 연산자를 순서대로 살펴본다.
        for(int i = 0; i < signs.size(); i++){
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

            newValues.add(val);
            newSigns.add(sign);

            val = add;
        }

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
            double add = vals.get(i + 1);
            int sign = signs.get(i);

            if(sign == PLUS){
                val += add;
                continue;
            }

            val -= add;
        }

        return val;
    }

    private String decode (String signs) {

        // 중간 값
        int val = 1;
        sb.setLength(0);
        sb.append(val);

        for(int i = 0; i < signs.length(); i++){
            int add = i + 2;
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
                default:

            }
            sb.append(add);
        }

        return sb.toString();
    }

    private void check(double calcRes, String signs){
        double EPS = 1e-9; // 충분히 작은 값


        if (Math.abs(calcRes - target) < EPS){
            String decoded = decode(signs);
            res.add(decoded);
        }
    }

    void solve() {
        List<String> everySigns = new ArrayList<>();
        calcEverySign(0, everySigns);

        for(String signs: everySigns){
            AbstractMap.SimpleEntry<List<Double>, List<Character>> emptyCalculated = calcEmpty(signs.toCharArray());

            // sign의 크기 없다는건 모든 계산 을 끝냈다는 것이니 값 체크하고 얼리 리턴
            if(emptyCalculated.getValue().isEmpty()){
                check(emptyCalculated.getKey().get(0), signs);
                continue;
            }

            AbstractMap.SimpleEntry<List<Double>, List<Character>> mulDivCalculated = calcMulDiv(emptyCalculated.getKey(), emptyCalculated.getValue());


            if(mulDivCalculated.getValue().isEmpty()){
                check(mulDivCalculated.getKey().get(0), signs);
                continue;
            }

            double calcRes = calcPlusMinus(mulDivCalculated.getKey(), mulDivCalculated.getValue());
            check(calcRes, signs);
        }

        for(String one : res){
            System.out.println(one);
        }
        System.out.println(res.size());
    }

    public static void main(String[] args) {
        Gomachijan gomachijan = new Gomachijan(100);
        gomachijan.solve();
    }
}
