package puzzleAlgorithm.basic.recursive.basic.permutation;

import common.utils.MathematicsUtils;

public abstract class AbstractPermutation {

    protected int length = 0;

    protected final int[] N;
    protected final int R;

    protected final int[] result;
    protected final boolean[] checkList;

    AbstractPermutation(int[] N, int R){
        this.N = N;
        this.R = R;
        this.result = new int[R];
        this.checkList = new boolean[N.length];
    }

    // nPr
    private int calculatePermutation() {
        return MathematicsUtils.factorial(N.length) / MathematicsUtils.factorial(N.length - R);
    }

    protected boolean checkIfPermutationCorrect() {
        return length == calculatePermutation();
    }

    protected abstract void DFS(int depth);

    abstract void solve();
}
