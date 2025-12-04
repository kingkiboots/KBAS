/**
 * 
 */
package study0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729 {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2, n) - 1);
		recursive(n, 1, 3);
		System.out.println(sb.toString());
	}
	
	private static void recursive(int n, int start, int dest) {
		String str = String.valueOf(start) + " " + String.valueOf(dest) + "\n";
		if(n == 1) {
			sb.append(str);
			return;
		}
		recursive(n - 1, start, 6 - start - dest);
		sb.append(str);
		recursive(n - 1, 6 - start - dest, dest);
	}
}
