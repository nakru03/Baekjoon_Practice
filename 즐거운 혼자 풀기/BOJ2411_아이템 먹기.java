import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, M, A, B;
	static int[][] board;
	static int[][] dp;
	static ArrayList<Pos> item;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {
				board[i][j] = -1;
			}
		}
		dp = new int[N][M];
		item = new ArrayList<>();
		int y, x;
		item.add(new Pos(0,0));
		for(int i=0; i<A; ++i) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
					
			item.add(new Pos(y,x));
		}
		item.add(new Pos(N-1,M-1));
		Collections.sort(item);
		for(int i=0; i<B; ++i) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			board[y][x] = -2;
		}
		int answer = 1;
		for(int i=0; i<item.size()-1; ++i) {
			answer *= dfs(item.get(i).y,item.get(i).x,item.get(i+1).y, item.get(i+1).x);
		}
		System.out.println(answer);
	}
	private static int dfs(int hy, int hx, int ty, int tx) {
		if(hy>ty || hx>tx) return 0;
		if(board[hy][hx]==-2) return 0;
		if(hy==ty && hx==tx) return 1;
		if(board[hy][hx] != -1) return board[hy][hx];
		return board[hy][hx] = dfs(hy+1, hx, ty, tx) + dfs(hy, hx+1, ty, tx);
	}
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Pos o) {
			return this.x==o.x ? this.y-o.y : this.x-o.x;
		}
		
	}
}
