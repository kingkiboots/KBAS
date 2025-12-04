package puzzleAlgorithm.basic.recursive.basic.permutation;

import java.util.Arrays;

/**
 * 0 ~ 9 비밀번호
 * 서로 다른 숫자
 * 곱하거나 더해서 220이 되는 4개의 숫자
 * 비밀번호가 되는 모든 후보를 구하시오
 */
public class AdvancedPermutation extends AbstractPermutation {
    final int target;
    StringBuilder candidates = new StringBuilder();

    AdvancedPermutation(int[] N, int R, int target) {
        super(N, R);
        this.target = target;
    }

    /**
     * +++
     * ++*
     * +*+
     * +**
     * *++
     * *+*
     * **+
     * ***
     */
    void calculate(){
        if((result[0] + result[1] + result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] + result[1] + result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] + result[1] * result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] + result[1] * result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] * result[1] + result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] * result[1] + result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] * result[1] * result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
        if((result[0] * result[1] * result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "")).append("\n");
        }
    }

    protected void DFS(int depth){
        if(depth == R){
            calculate();
            return;
        }
        for (int i = 0; i < N.length; i++){
            if(checkList[i]){
                continue;
            }
            result[depth] = N[i];
            checkList[i] = true;
            DFS(depth + 1);
            checkList[i] = false;
        }
    }

    void solve () {
        DFS(0);
        System.out.println(candidates.toString());
    }

    public static void main(String[] args) {
        int[] N = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int R = 4;
        int target = 220;

        AdvancedPermutation advancedPermutation = new AdvancedPermutation(N, R, target);
        advancedPermutation.solve();
    }
}
