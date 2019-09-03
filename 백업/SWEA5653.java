import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5653 {
	static int N;
	static int M;
	static int K;
	static int[][] board = new int [1000][1000];
	static ArrayList<Pair> activeList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			
			for(int y=500; y<N; ++y) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x=500; x<M; ++x) {
					board[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<=K; ++i) {				
				active();				
			}			
		}
		
	}
	private static void active() {
		for(int y=0; y<N; ++y) {
			for(int x=0; x<N; ++x) {
				if(board[y][x]==1) {
					activeList.add(new Pair(y,x));
				}
				else if(board[y][x]>1) {
					board[y][x] -= 1;
				}
			}
		}
	}
	
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}		
	}

}
