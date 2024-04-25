package puzzleAlgorithm.basic.recursive.basic.combination;

import java.util.Arrays;

/**
 * 조합 응용문제
 * 백설공주와 9난장이가 되었다.
 *
 * 원년 멤버인 7명을 추리려고 하는데 7명 합쳐서 키가 100이었던 게 기억난다.
 *
 * 다들 키를 측정해보니깐 아래와 같다.
 *
 * 20 7 23 19 10 15 25 8 13
 *
 * 자, 원년 멤버 7명을 맞추자
 * =====================================================
 * 더하기는 순서가 상관이 없으므로 조합
 *
 * nCr이다.
 */
public class AdvancedCombination {

    final int[] N = {20, 7, 23, 19, 10, 15, 25, 8, 13};
    final int R = 7;
    final int TARGET = 100;

    int sum = 0;
    int[] result = new int[R];

    void DFS(int depth, int begin){
        if(depth == R){
            if(sum == TARGET) {
                System.out.println(Arrays.toString(result));
                // 알아냈으면 더 할 필요가 없으므로 프로그램 종료
                System.exit(0);
            }
            return;
        }
        if(sum > TARGET){
            return;
        }
        for(int i = begin; i < N.length; i++){
            int curr = N[i];
            result[depth] = curr;
            // 백트래킹을 해주어야지비
            sum += curr;
            DFS(depth + 1, i + 1);
            sum -= curr;
        }
    }

    void solve() { DFS(0, 0); }

    public static void main(String[] args) {
        AdvancedCombination ac = new AdvancedCombination();
        ac.solve();
    }
}
