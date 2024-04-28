package puzzleAlgorithm.basic.recursive.basic.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0 ~ 9 비밀번호
 *
 * 서로 다른 숫자
 *
 * 곱하거나 더해서 220이 되는 4개의 숫자
 *
 * 비밀번호가 되는 모든 후보를 구하시오
 */
public class AdvancedPermutation {

    final int[] N = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    final int R = 4;
    final int target = 220;
    StringBuilder candidates = new StringBuilder();

    int[] result = new int[R];
    boolean[] checkList = new boolean[N.length];

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
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] + result[1] + result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] + result[1] * result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] + result[1] * result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] * result[1] + result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] * result[1] + result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] * result[1] * result[2] + result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
        if((result[0] * result[1] * result[2] * result[3]) == target){
            candidates.append(Arrays.toString(result).replaceAll("[^0-9]", "") + "\n");
        }
    }

    void DFS(int depth, int begin){
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
            DFS(depth + 1, i + 1);
            checkList[i] = false;
        }
    }

    void solve () {
        DFS(0, 0);
        System.out.println(candidates);
    }

    public static void main(String[] args) {
        AdvancedPermutation advancedPermutation = new AdvancedPermutation();
        advancedPermutation.solve();
    }
}
