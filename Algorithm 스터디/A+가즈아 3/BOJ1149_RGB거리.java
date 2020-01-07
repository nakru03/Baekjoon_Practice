import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][3];
		for(int i=0; i<N; ++i) {
			String[] s = br.readLine().split("\\s");
			board[i][0] = Integer.parseInt(s[0]);
			board[i][1] = Integer.parseInt(s[1]);
			board[i][2] = Integer.parseInt(s[2]);
		}
		
		for(int i=1; i<N; ++i) {
			board[i][0] = board[i][0] + Math.min(board[i - 1][1], board[i - 1][2]);
			board[i][1] = board[i][1] + Math.min(board[i - 1][0], board[i - 1][2]);
			board[i][2] = board[i][2] + Math.min(board[i - 1][0], board[i - 1][1]);
		}
		System.out.println(Math.min(Math.min(board[N-1][0], board[N-1][1]),board[N-1][2]));
	}

}
