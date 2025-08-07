package puzzleAlgorithm.basic.recursive.towerOfHanoi;

public class TowerOfHanoi {

    StringBuilder sb = new StringBuilder();

    private void move(int N, String from, String to) {
        sb.append(N)
            .append("번 원판을 ")
            .append(from)
            .append("에서 ")
            .append(to)
            .append("로 옮깁니다.")
            .append("\n");
    }

    private void hanoi(int N, String from, String to, String via) {
        if(N == 1) {
            move(1, from, to);
        }
        else {
            hanoi(N-1, from, via, to);
            move(N, from, to);
            hanoi(N-1, via, to, from);
        }
    }

    protected void solve(int N) {
        hanoi(N, "A", "C", "B");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.solve(3);
    }
}
