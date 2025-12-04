/**
 * 
 */
package study0712;

import java.util.Scanner;

/**
 * @packageName : study0712
 * @fileName    : CompleteSearch.java
 * @author      : E4
 * @date        : 2023.07.12
 * @description : 
 * =====================================================
 * DATE					AUTHOR				NOTE
 * =====================================================
 * 2023.07.12			E4                
 */
public class CompleteSearch1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lineLength = Integer.parseInt(scanner.nextLine());
		int[][] numbers = new int[lineLength][3];
		
		for(int i = 0; i < lineLength; i++) {
			String abc = scanner.nextLine();
			String[] abcs = abc.split(" ");
			for(int j = 0; j < 3; j++) numbers[i][j] = Integer.parseInt(abcs[j]);
		}
		solve(numbers);
	}
	// 재귀함수 : recursive
	// k 가 true.
	// k + 1이 true 
	// 이면 이거는 다 참이다
	//  이게 재귀(귀납)적인 사고법
	// 특정 지점에서는 자신을 소출하지 않아야 한다.
	// 또 k를 구했으면 2k + 1도 구할 수 있다.
	// 0 1 2가 바로 그 k k+1 k+2 
	// base condition을 정의하자
	private static void solve(int[][] numbers) {
		for(int[] row: numbers) {
			int answer = 0; 
			for(int x = 1; x <= row[0]; x++) {
				for(int y = 1; y <= row[1]; y++) {
					for(int z = 1; z <= row[2]; z++) {
						if((x % y) == (y % z) && (y % z) == (z % x)) {
							for(int a = 1; a <= row[2]; a++) {
								if((x % y) == (y % z) && (y % z) == (z % x) && (y % a) == (a % x)) {
									answer++;
								}
							}							
						}
					}
				}
			}
			System.out.println(answer);
		}
	}
	
	private static void recursive(int[] row, int k, int answer) {
		int length = row.length;
		if(k - 2 < 0) {
			System.out.println(answer);
			return;
		}
		else if(row[k] % row[k - 1] == row[k - 1] % row[k - 2]) {
			System.out.println(row[k]);
			answer++;
			recursive(row, k + 1, answer);
		}
	}
}
