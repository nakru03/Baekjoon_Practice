
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int R;
	static int[][] board;
	static int[] side4;
	static int round;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split("\\s");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		board = new int[N][M];
		for(int y=0; y<N; ++y) {
			s = br.readLine().split("\\s");
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		round = Math.min(N, M) / 2 ;
		for(int i=0; i<R; ++i) {
			for(int j=0; j<round; ++j) {
				rotate(j, j, N-j*1, M-j*1);
			}
		}
		
		for(int y=0; y<N; ++y) {
			for(int x=0; x<M; ++x) {
				sb.append(board[y][x]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static void rotate(int sy, int sx, int n, int m) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=sy; i<n; ++i) {
			q.offer(board[i][sx]);
		}
		for(int i=sx+1; i<m; ++i) {
			q.offer(board[n-1][i]);
		}
		for(int i=n-2; i>=sy; --i) {
			q.offer(board[i][m-1]);
		}
		for(int i=m-2; i>=sx+1; --i) {
			q.offer(board[sy][i]);
		}
		
		for(int i=sy+1; i<n; ++i) {
			board[i][sx] = q.poll();
		}
		for(int i=sx+1; i<m; ++i) {
			board[n-1][i] = q.poll();
		}
		for(int i=n-2; i>=sy; --i) {
			board[i][m-1] = q.poll();
		}
		for(int i=m-2; i>=sx; --i) {
			board[sy][i] = q.poll();
		}
		
		
	}

}
