package puzzleAlgorithm.bruteForce.makeTen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MakeTen {

    private final Poland poland = new Poland();

    double EPS = 1e-9; // 충분히 작은 값
    char[] OPS = {'+', '-', '*', '/'}; // 4개의 연산자

    // 답을 나타내는 계산기를 저장한 배열
    Set<String> res = new HashSet<>();

    int target;

    /**
     * 배열에서 두 개 요소의 자리를 바꿔주는 메소드
     * @param arr 배열
     * @param f 1번 자리
     * @param r 2번 자리
     */
    private void swap(char[] arr, int f, int r){
        char temp;
        temp = arr[f];
        arr[f] = arr[r];
        arr[r] = temp;
    }

    /**
     * 역폴란드 표기법 계산식 exp가 목표했던 숫자 target이 되는 지 알아보는 메소드
     * @param exp 역폴란드 표기법 계산식
     */
    private void check(String exp){
        // 계산 결과와 만들고자 하는 수의 값의 차가 충분히 작을 때 일치한다고 가정한다.
        double calcRes = poland.calcPoland(exp);
        if(Math.abs(calcRes - target) < EPS){
            String decodedPoland = poland.decodePoland(exp);
            res.add(decodedPoland);
        }
    }

    /**
     * 텐퍼즐 프로그램
     * @param val 4개 수를 저장한 배열
     * @return 4개의 수를 이용하여 target을 만들 수 있는 계산식의 배열
     */
    private void solve (int[] val){

        // 4개의 수 val 의 정렬을 순서대로 시험한다.
        // ?? 12개의 경우의 수 구하는건 어디갔음? 어딜 가긴 만들어야지
//        Collections.sort(val); // val을 사전순으로 정렬 및 최소화 한다.
        String[] everyCases = getEveryCasesFromNumbers(val).toArray(new String[0]); // 0으로 하면 배열 크기 자동 지정
        int len = everyCases.length;
        int i = 0;
        do {
            // 4개의 문자를 연결해 가능한 문자열 fours를 만든다.
            String fours = everyCases[i];
//            for(int v : val) fours += String.valueOf(v);
            // 4의 3제곱 = 64가지의 연산자 조합을 알아본다
            for (char op1 : OPS){
                for (char op2 : OPS){
                    for (char op3 : OPS){
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

    /**
     * 4개의 수를 조합하여 12개의 경우의 수를 만들어내는 메소드
     * @param val 입력받은 4개의 숫자
     * @return 4개의 수를 조합하여 만든 12개의 경우의 수 문자열
     */
    private Set<String> getEveryCasesFromNumbers(int[] val){
        int len = val.length;
        Set<String> everyCases = new HashSet<>();
        for(int i = 0; i < len; i++){
            String str = "";
            str += String.valueOf(val[i]);
            for(int j = 0; j < len; j++){
                if(j != i) {
                    str += String.valueOf(val[j]);
                    for (int k = 0; k < len; k++) {
                        if(k != j && k != i){
                            str += String.valueOf(val[k]);
                            for(int l = 0; l < len; l++){
                                if(l != k && l != j && l != i) {
                                    str += String.valueOf(val[l]);
                                    everyCases.add(str);
                                    str = str.substring(0, 3);
                                }
                            }
                            str = str.substring(0, 2);
                        }
                    }
                    str = str.substring(0, 1);
                }
            }
        }
        return everyCases;
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

        for(String exp : makeTen.res){
            System.out.println(exp + "=" + makeTen.target);
        }
    }
}
