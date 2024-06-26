package puzzleAlgorithm.basic.recursive.basic.combination;

import java.util.Arrays;

/**
 * 1,2,3,4 이 숫자들로 2개의 숫자를 만들 수 있는 조합을 구하시오.
 * n개의 카드 중에 r개를 뽑아 나열할 수 있는 경우의 수, 단 중복은 불가능하다.
 * 조합은 순서가 상관이 없다.
 * [1,2] 나 [2,1]이나 같기 때문이다.
 * 그럼 이전 값을 기억할 필요 없이 [1,2], [1,3], [1,4], [2,3], [2,4], [3,4] 이렇게 계속 앞으로 나아가기만 하면 된다.
 * DFS(depth-first-search)를 이용할 것인데 dfs는 루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법
 * 이라고만 설명하고 나중에 더 다루기로 하겠다.
 *
 * 조합을 구하는 공식은 이것이다.
 * nCr=nPr/r!
 * nPr = n!/(n-r)!
 *
 * 이게 그림을 보면 더 이해하기가 쉬운데 아래 그림을 보면
 * 1. 다음 단계로 넘어갈 때마다 depth는 한 단계 더 깊어지고 branch는 다음 브랜치로 하나씩 넘어간다.
 *
 * 2. 더이상 갈 곳이 없는 곳에 이르면(이 경우에는 조합된 숫자의 총개수인 2) 다음 depth로 가는 것을 종료하고 재귀호출을 끝낸다.
 *
 * 3. 그 상태로 백트래킹이 되는 것이다.
 * */
public class Combination {
    private final int[] N = {1, 2, 3, 4};
    private final int R = 2;

    private final int[] result = new int[R];

    private void DFS (int depth, int begin) {
        if(depth == R){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = begin; i < N.length; i++) {
            result[depth] = N[i];
            DFS(depth + 1, i + 1);
        }
    }

    void solve () {
        DFS(0, 0);
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        combination.solve();
    }
}
