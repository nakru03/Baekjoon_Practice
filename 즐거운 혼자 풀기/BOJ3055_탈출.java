import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3055 {
	static int N;
	static int M;
	static char[][] board;
	static Pair start;
	static Pair dst;
	
	static Queue<Pair> hedgehog = new LinkedList<>();
	static Queue<Pair> water = new LinkedList<>();
	static boolean[][] visited;
	
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		board = new char[N][M];
		for(int y=0; y<N; ++y) {
			char[] c = br.readLine().toCharArray();
			for(int x=0; x<M; ++x) {
				board[y][x] = c[x];
				if(board[y][x]=='D') {
					dst = new Pair(y,x);
				}
				if(board[y][x]=='S') {
					hedgehog.offer(new Pair(y,x));
					board[y][x] = '@';
				}
				if(board[y][x]=='*') {
					water.offer(new Pair(y,x));
				}
			}
		}
		
		int level = 0;
		boolean flag = false;
		out :while(!hedgehog.isEmpty()) {
			int qs1 = hedgehog.size();
			int qs2 = water.size();
			
			for(int i=0; i<qs2; ++i) {
				Pair curr = water.poll();
				
				for(int dir=0; dir<4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					
					if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
					if(board[ny][nx]=='*' || board[ny][nx] == 'X' || board[ny][nx] == 'D') continue;
					water.offer(new Pair(ny,nx));
					board[ny][nx]='*';
					
				}
			}
			
			for(int i=0; i<qs1; ++i) {
				Pair curr = hedgehog.poll();
				
				if(curr.y==dst.y && curr.x==dst.x) {
					flag = true;
					break out;
				}
				for(int dir=0; dir<4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					
					if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
					if(board[ny][nx]=='*' || board[ny][nx] == 'X' || board[ny][nx] == '@') continue;
					hedgehog.offer(new Pair(ny,nx));
					board[ny][nx] = '@';
					
				}
			}
			
			level++;
		}
		
	
		if(flag){
			System.out.println(level);
		}else {
			System.out.println("KAKTUS");
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
