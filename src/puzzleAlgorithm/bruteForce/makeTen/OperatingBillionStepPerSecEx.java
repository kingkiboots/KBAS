package puzzleAlgorithm.bruteForce.makeTen;

public class OperatingBillionStepPerSecEx {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 1000000000; i++){
        }
        long endTime = System.currentTimeMillis();
        long secDiffTime = endTime - startTime;
        // it won't take more than 10 milliseconds to operate two billion steps
        System.out.println("secDiffTime : " + secDiffTime);
    }
}
