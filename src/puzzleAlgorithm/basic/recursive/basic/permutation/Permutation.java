package puzzleAlgorithm.basic.recursive.basic.permutation;

import java.util.Arrays;

/**
 * nPr
 * 1234 네개의 숫자로 만들 수 있는 순열을 구하세요
 */
public class Permutation extends AbstractPermutaion {

    Permutation(int[] N, int R) {
        super(N, R);
    }

    protected void DFS(int depth) {
        if(depth == R){
            System.out.println(Arrays.toString(result));
            length++;
            return;
        }
        for(int i = 0; i < N.length; i++){
            if(checkList[i]) {
                continue;
            }
            result[depth] = N[i];
            checkList[i] = true;
            DFS(depth + 1);
            checkList[i] = false;
        }
    }

    void solve(){
        DFS(0);
        if (this.checkIfPermutationCorrect()){
            System.out.println("계산이 정확합니다.");
        }
        else {
            System.out.println("계산이 정확하지 않습니다.");
        }
    }


    public static void main(String[] args) {
        int[] N = {1,2,3,4};
        int R = 2;

        Permutation permutation = new Permutation(N, R);
        permutation.solve();
    }
}
