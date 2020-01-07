import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static int[][] mem;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		mem = new int[N][M];
		
		for(int i=0; i<N; ++i) {
			for(int[] m : mem) {
				Arrays.fill(m, -1);
			}
		}
		for(int y=0; y<N; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int answer = dfs(0,0);
		System.out.println(answer);
	}
	static int ny, nx;
	private static int dfs(int y, int x) {
		
		if(y==N-1 && x==M-1) return 1;
		
		if(mem[y][x]!=-1) return mem[y][x];
	
		if(mem[y][x]==-1) mem[y][x] = 0;
		
		for(int dir=0; dir<4; ++dir) {
			ny = y + dy[dir];
			nx = x + dx[dir];
			
			if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
			if(board[y][x]>board[ny][nx]) {
				mem[y][x] += dfs(ny, nx);
			}
			
		}
		return mem[y][x];
	}
}
