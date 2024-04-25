package puzzleAlgorithm.basic.recursive.basic.permutation;

import java.util.Arrays;

/**
 * nPr
 *
 * 1234 네개의 숫자로 만들 수 있는 순열을 구하세요
 */
public class Permutation {

    private final int[] N = {1, 2, 3, 4};
    private final int R = 2;

    private final int[] result = new int[R];
    private final boolean[] checkList = new boolean[N.length];

    private void DFS(int depth, int begin) {
        if(depth == R){
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i = 0; i < N.length; i++){
            if(checkList[i]) {
                continue;
            }
            result[depth] = N[i];
            checkList[i] = true;
            DFS(depth + 1, begin + 1);
            checkList[i] = false;
        }
    }

    void solve(){
        DFS(0, 0);
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.solve();
    }
}
