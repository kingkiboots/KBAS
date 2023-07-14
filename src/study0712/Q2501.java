/**
 * 
 */
package study0712;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @packageName : study0712
 * @fileName    : Q2501.java
 * @author      : E4
 * @date        : 2023.07.12
 * @description : 
 * =====================================================
 * DATE					AUTHOR				NOTE
 * =====================================================
 * 2023.07.12			E4                
 */
public class Q2501 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] nk = str.split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		ArrayList<Integer> arr = new ArrayList<>();
		arr = recursive(n, 1, arr);
		int answer = 0;
		if(arr.size() >= k) answer = arr.get(k - 1);
		System.out.println(answer);
	}
	
	private static ArrayList<Integer> recursive(int n, int i, ArrayList<Integer> arr){
		if(i > n) return arr;
		else if (n % i == 0) arr.add(i);
		return recursive(n, i + 1, arr);		
	}
}
