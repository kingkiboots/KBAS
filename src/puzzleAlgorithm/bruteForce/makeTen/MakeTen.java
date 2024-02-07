package puzzleAlgorithm.bruteForce.makeTen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeTen {

    private final Poland poland = new Poland();
    private final StringBuilder sb = new StringBuilder();

    private final char[] OPS = {'+', '-', '*', '/'}; // 4개의 연산자

    // 답을 나타내는 계산식를 저장한 배열
    Set<String> res = new HashSet<>();

    // 만들숫자
    int target;

    /**
     * 배열에서 두 개 요소의 자리를 바꿔주는 메소드
     * @param arr 배열
     * @param f 1번 자리
     * @param r 2번 자리
     */
    private void swap(char[] arr, int f, int r){
        if(f == r) return;
        char temp;
        temp = arr[f];
        arr[f] = arr[r];
        arr[r] = temp;
    }
    /**
     * 배열에서 두 개 요소의 자리를 바꿔주는 메소드
     * @param arr 배열
     * @param f 1번 자리
     * @param r 2번 자리
     */
    private void swap(int[] arr, int f, int r){
        if(f == r) return;
        int temp;
        temp = arr[f];
        arr[f] = arr[r];
        arr[r] = temp;
    }
    /**
     * 4개의 수를 조합하여 24개의 경우의 수를 만들어내는 메소드
     * @param val 입력받은 4개의 숫자
     */
    private Set<String> generatePermutation(int[] val){
        Set<String> everyCases = new HashSet<>();
        permute(val, 0, everyCases);
        return everyCases;
    }

    /**
     * 재귀 함수를 이용하여 입력받은 4개의 숫자를 이용해 조합할 수 있는 모든 경우의 수를 만들어낸다.
     * @param val 입력받은 4개의 숫자
     * @param start 여기 인덱스의 요소에 i 인덱스의 숫자가 들어가서 만들 수 있는 모든 경우의 수를 계산한다.
     *              start + 1로 permute 함수를 재귀적으로 호출하여, start 다음 위치부터 나머지 배열에 대한 모든 순열을 생성
     * @param everyCases 모든 경우의 수가 담길 Set
     */
    private void permute(int[] val, int start, Set<String> everyCases){
        if(start >= val.length){
            for(int num : val) sb.append(num);
            everyCases.add(sb.toString());
            sb.setLength(0); // StringBuilder 초기화

//            System.out.println("******************************");
//            System.out.println("enlist");
//            System.out.println("******************************");
        } else {
            for (int i = start; i < val.length; i++){
                swap(val, start, i);
//                System.out.println("=================================================");
//                System.out.println("start : " + start);
//                System.out.println("i : " + i);
//                System.out.println("{"+val[0]+","+val[1]+","+val[2]+","+val[3]+"}");
//                System.out.println("=================================================");
                permute(val, start + 1, everyCases);
                swap(val, start, i);
            }
        }
    }

    /**
     * 역폴란드 표기법 계산식 exp가 목표했던 숫자 target이 되는 지 알아보는 메소드
     * @param exp 역폴란드 표기법 계산식
     */
    private void check(String exp){
        // 계산 결과와 만들고자 하는 수의 값의 차가 충분히 작을 때 일치한다고 가정한다.
        double calcRes = poland.calcPoland(exp);
        double EPS = 1e-9; // 충분히 작은 값
        if(Math.abs(calcRes - target) < EPS){
            String decodedPoland = poland.decodePoland(exp);
            res.add(decodedPoland);
        }
    }

    /**
     * 텐퍼즐 프로그램
     * @param val 4개 수를 저장한 배열
     */
    private void solve (int[] val){

        // 4개 숫자 배열의 모든 경우의 수 4*3*2*1 = 24
        String[] everyCases = generatePermutation(val).toArray(new String[0]); // 0으로 하면 배열 크기 자동 지정
        // 4개의 수 val 의 정렬을 순서대로 시험한다. 는 제거
//        Collections.sort(val); // val을 사전순으로 정렬 및 최소화 한다. 는 제거
        int len = everyCases.length;
        int i = 0;
        do {
            // 4개의 문자를 연결해 가능한 문자열 fours를 만든다.
            String fours = everyCases[i];
            // 4의 3제곱 = 64가지의 연산자 조합을 알아본다
            for (char op1 : OPS){
                for (char op2 : OPS){
                    for (char op3 : OPS){

                        // 5가지 패턴을 모두 탐색한다.
                        // 우선 패턴 xxxxooo을 만든다.
                        char[] exp = (fours + op1 + op2 + op3).toCharArray();

                        // 패턴 "xxxxooo"를 시험해본다.
                        check(String.valueOf(exp));

                        // 패턴 "xxxoxoo"를 시험해본다.
                        swap(exp, 3, 4);
                        check(String.valueOf(exp));

                        // 패턴 "xxxooxo"를 시험해본다.
                        swap(exp, 4, 5);
                        check(String.valueOf(exp));

                        // 패턴 "xxoxoxo"를 시험해본다.
                        swap(exp, 2, 3);
                        check(String.valueOf(exp));

                        // 패턴 "xxoxxoo"를 시험해본다.
                        swap(exp, 4, 5);
                        check(String.valueOf(exp));
                    }
                }
            }
            i++;
        } while (i < len);
    }

    public static void main(String[] args) throws IOException {
        MakeTen makeTen = new MakeTen();
        int[] val = new int[4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++){
            System.out.print((i + 1)+" th number : ");
            val[i] = Integer.parseInt(br.readLine());
        }
        System.out.print("target number : ");
        makeTen.target = Integer.parseInt(br.readLine());

        // 텐퍼즐을 푼다.
        makeTen.solve(val);
        Set<String> res = makeTen.res;
        if(res.size() < 1) {
            System.out.println("주어진 숫자들로는 "+ makeTen.target+"을 만들 수 없습니다.");
            return;
        }
        for(String exp : makeTen.res){
            System.out.println(exp + "=" + makeTen.target);
        }
    }
}
