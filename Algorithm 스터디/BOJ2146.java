import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 1;
		for(int y=0; y<n; ++y) {
			for(int x=0; x<n; ++x) {
				namingIsland(new Pair(y,x), idx++);
			}			
		}
		
	}
	
	static final int[] dx = {1,0,-1,0};
	static final int[] dy = {0,1,0,-1};
	private static void namingIsland(Pair pair, int idx) {
		Queue<Pair> q = new LinkedList<>();
		board[pair.y][pair.x] = idx;
		q.offer(pair);
		visited[pair.y][pair.x] = true;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y+dy[dir];
				int nx = curr.x+dx[dir];
				if(ny<0 || nx<0 || ny >= board.length || nx >= board.length) continue;
				if(board[ny][nx] == 0 || visited[ny][nx]) continue;
				board[ny][nx] = idx;
				q.offer(new Pair(ny, nx));
				visited[pair.y][pair.x] = true;
			}
		}		
	}
	static class Pair {
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
		
	}
}
