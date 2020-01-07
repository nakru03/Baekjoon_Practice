import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,M,T;
	static int[][] board;
	static boolean[][] visited;
	static boolean[][] visited2;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static int answer=-1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		T = Integer.parseInt(s[2]);
		
		board = new int[N][M];
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];
		
		for(int y=0; y<N; ++y) {
			s = br.readLine().split("\\s");
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		bfs();
		if(answer==-1 || answer>T) System.out.println("Fail");
		else System.out.println(answer);
	}
	
	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		
		q.offer(new Pair(0,0,false));
		visited[0][0] = true;
		int t = 0;
		
		while(!q.isEmpty()) {
			int qs = q.size();
			for(int i=0; i<qs; ++i) {
				Pair curr = q.poll();
				if(board[curr.y][curr.x] == 2) { //그람얻음
					curr.gram = true;
				}
				if(curr.y == N-1 && curr.x == M-1) {
					answer = t;
					return;
				}
				for(int dir=0; dir<4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					
					if(ny<0 || nx <0 || ny>=N || nx>=M) continue;
					if(!curr.gram && visited[ny][nx]) continue;
					if(!curr.gram && board[ny][nx]==1) continue;
					if(curr.gram && visited2[ny][nx]) continue;
					
					if(!curr.gram)
						visited[ny][nx] = true;
					else
						visited2[ny][nx] = true;
					
					q.offer(new Pair(ny,nx,curr.gram));
				}
				
			}
			t++;
			
		}
		
	}

	static class Pair{
		int y;
		int x;
		boolean gram;
		public Pair(int y, int x, boolean gram) {
			super();
			this.y = y;
			this.x = x;
			this.gram = gram;
		}
		
		
	}
}
