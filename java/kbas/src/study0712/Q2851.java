/**
 * 
 */
package study0712;

import java.util.Scanner;

/**
 * @packageName : study0712
 * @fileName    : Q2851.java
 * @author      : E4
 * @date        : 2023.07.12
 * @description : 
 * =====================================================
 * DATE					AUTHOR				NOTE
 * =====================================================
 * 2023.07.12			E4                
 */
public class Q2851 {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		int limit = 10;
		int[] board = new int[limit];
		for(int i = 0; i < limit; i++) {
			int mushroom = Integer.parseInt(scanner.nextLine());
			board[i] = mushroom;
		}
		// int의 범위를 초과할 수도 있으니 long도 나쁘지 않음
		int totalScore = recursive(0, board, 0);
		System.out.println(totalScore);
	}
	
	public static int recursive(int i, int[] board, int totalScore) {
		int currentGap = 100 - totalScore;
		if(i < board.length && Math.abs(currentGap) >= Math.abs(currentGap - board[i])) {
			totalScore += board[i];
			return recursive(i + 1, board, totalScore);
		}else return totalScore;
//		if(i == board.length) return totalScore;
//		else {
//			int score = board[i];
//			int currentGap = 100 - totalScore;
//			if(Math.abs(currentGap) >= Math.abs(currentGap - score)) {
//				totalScore += score;
//				return solve(i + 1, board, totalScore);
//			}else return totalScore;
//		}
	}
}
