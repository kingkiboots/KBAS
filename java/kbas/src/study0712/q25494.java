/**
 * 
 */
package study0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @packageName : study0712
 * @fileName    : q25494.java
 * @author      : E4
 * @date        : 2023.07.12
 * @description : 
 * =====================================================
 * DATE					AUTHOR				NOTE
 * =====================================================
 * 2023.07.12			E4                
 */
public class q25494 {
	static int[][] s;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        s = new int[C][3];
        for(int i=0; i<C; i++) {
            for(int j=0; j<3; j++) {
                s[i][j] = Integer.parseInt(br.readLine());
            }
            System.out.println(solve(s));
        }
        System.out.println(Arrays.deepToString(s));
    }
    static int solve(int[][] s) {
        int answer = 0;
        int a = s[0][0];
        int b = s[0][1];
        int c = s[0][2];
        for(int x=1; x<=a; x++){
            for(int y=1; y<=b; y++) {
                for(int z=1; z<=c; z++) {
                    if((x%y == y%z) && (y%z == z%x) && (x%y == z%x)) answer++;
                }
            }
        }
        return answer;
    }
}
