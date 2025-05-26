package puzzleAlgorithm.basic.recursive.gomachijan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Gomachijan {
    private int EMPTY = 0;
    private int PLUS = 1;
    private int MINUS = 2;
    private int MUL = 3;
    private int DIV = 4;

    /**
     * [ ]에 넣은 연산자 중 공백을 처리하는 함수
     * @param signs
     * @return
     */
    Map.Entry<List<Double>, List<Integer>> calcEmpty(int[] signs){
        // 공백 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList(); // 수
        List<Integer> newSigns = new ArrayList(); // 연산잔

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

    Map.Entry<List<Double>, List<Integer>> makePair(List<Double> newValues, List<Integer> newSigns) {
        return null;
    }

    /**
     * 연산자 중 곱셈 나눗셈을 처리하는 함수
     * @param vals
     * @param signs
     * @return
     */
    Map.Entry<List<Double>, List<Integer>> calcMulDiv(double[] vals, int[] signs) {
        // 곱셈 나눗샘 처리 후의 연산식을 나타내는 데이터
        List<Double> newValues = new ArrayList(); // 수
        List<Integer> newSigns = new ArrayList(); // 연산잔

        // 도중 경과값
        double val = vals[0];

        // 연산자를 순서대로 살펴본다.
        for(int i = 0; i < vals.length; i++){
            double add = vals[i + 1];

        }

        return null;
    }
}
