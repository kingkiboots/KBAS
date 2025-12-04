package puzzleAlgorithm.basic.recursive.basic.combination;

import java.util.Arrays;

/**
 * 조합 응용문제
 * 백설공주와 9난장이가 되었다.
 * 원년 멤버인 7명을 추리려고 하는데 7명 합쳐서 키가 100이었던 게 기억난다.
 * 다들 키를 측정해보니깐 아래와 같다.
 * 20 7 23 19 10 15 25 8 13
 * 자, 원년 멤버 7명을 맞추자
 * =====================================================
 * 더하기는 순서가 상관이 없으므로 조합을 사용해야 한다.
 */
public class AdvancedCombination extends AbstractCombination {
    final int TARGET;
    int sum = 0;

    AdvancedCombination(int[] N, int R, int TARGET){
        super(N, R);
        this.TARGET = TARGET;
    }

    protected void DFS(int depth, int begin){
        if(depth == R){
            if(sum == TARGET) {
                System.out.println(Arrays.toString(result));
                // 알아냈으면 더 할 필요가 없으므로 프로그램 종료
                System.exit(0);
            }
            return;
        }
        // 7명 채우기도 전에 TARGET 초과했으면 백트래킹
        if(sum > TARGET){
            return;
        }
        for(int i = begin; i < N.length; i++){
            int currentHeight = N[i];
            result[depth] = currentHeight;
            // 재귀 종료하면 값 원복하여 백트래킹
            sum += currentHeight;
            DFS(depth + 1, i + 1);
            sum -= currentHeight;
        }
    }

    void solve() { DFS(0, 0); }

    public static void main(String[] args) {
        final int[] N = {20, 7, 23, 19, 10, 15, 25, 8, 13};
        final int R = 7;
        int TARGET = 100;

        AdvancedCombination ac = new AdvancedCombination(N, R, TARGET);
        ac.solve();
    }
}
