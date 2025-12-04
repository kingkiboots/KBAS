package puzzleAlgorithm.basic.recursive.basic.combination;

import java.util.Arrays;

/**
 * nCr
 * 1,2,3,4 이 숫자들로 2개를 뽑아 만들 수 있는 조합을 구하시오.
 * */
public class Combination extends AbstractCombination {
    Combination(int[] N, int R){
        super(N, R);
    }

    protected void DFS (int depth, int begin) {
        if(depth == R){
            System.out.println(Arrays.toString(result));
            length++;
            return;
        }

        for (int i = begin; i < N.length; i++) {
            result[depth] = N[i];
            DFS(depth + 1, i + 1);
        }
    }

    void solve () {
        DFS(0, 0);
        if (this.checkIfCombinationCorrect()){
            System.out.println("계산이 정확합니다.");
        }
        else {
            System.out.println("계산이 정확하지 않습니다.");
        }
    }

    public static void main(String[] args) {
        int[] N = {1,2,3,4};
        int R = 2;
        Combination combination = new Combination(N, R);
        combination.solve();
    }
}
