import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] board;
	static int[][] visited;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static final int INF = 987654321;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new int[N][N];
		
		
		for(int y=0; y<N; ++y) {
			String[] s = br.readLine().split("");
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				visited[y][x] = INF;
			}
		}
		
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0));
		visited[0][0] = 0;
		
		int ny, nx;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			if(curr.y==N-1 && curr.x==N-1) {
				answer = visited[curr.y][curr.x];
			}
			for(int dir = 0; dir<4; ++dir) {
				ny = curr.y + dy[dir];
				nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if(visited[ny][nx] <= visited[curr.y][curr.x]) continue;
				
				if(board[ny][nx]==0) {
					q.offer(new Pos(ny, nx));
					visited[ny][nx] = visited[curr.y][curr.x]+1;
				}
				else {
					q.offer(new Pos(ny, nx));
					visited[ny][nx] = visited[curr.y][curr.x];
				}
			}
		}
	}
	
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
