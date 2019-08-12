import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
	static int[][] board;
	static int[][] dist;
	static int n;
	static int m;
	static final int[] dx = {1,0,-1,0};
	static final int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		dist = new int[n][m];
		
		for(int y=0; y<n; ++y) {
			String[] s = br.readLine().split("");
			for(int x=0; x<m; ++x) {				
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j) {
				dist[i][j] = -1;
			}
		}
		bfs(0,0);
		System.out.println(dist[n-1][m-1]+1);
	}
	private static void bfs(int y, int x) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(y,x));
		dist[y][x] = 0;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(nx<0 || ny<0 || ny>=n || nx>=m) continue;
				if(board[ny][nx] == 0 || dist[ny][nx]>-1) continue;
				q.offer(new Pair(ny,nx));
				dist[ny][nx] = dist[curr.y][curr.x]+1;
			}
		}
		
	}
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
