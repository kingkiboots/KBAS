package puzzleAlgorithm.basic.recursive.basic.combination;

import common.utils.MathematicsUtils;

public abstract class AbstractCombination {
    protected int length = 0;

    protected final int[] N;
    protected final int R;

    protected final int[] result;

    AbstractCombination(int[] N, int R){
        this.N = N;
        this.R = R;
        this.result = new int[R];
    }

    // nCr
    // nCr = nPr / r!
    private int calculateCombination() {
        int npr = MathematicsUtils.factorial(N.length) / MathematicsUtils.factorial(N.length - R);
        int rFactorial = MathematicsUtils.factorial(R);
        return npr / rFactorial;
    }

    protected boolean checkIfCombinationCorrect() {
        return length == calculateCombination();
    }

    protected abstract void DFS(int depth, int begin);

    abstract void solve();
}
