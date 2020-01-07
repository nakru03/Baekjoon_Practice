import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] board;
	static int[][] visited;
	
	static final int[] dy = {-2, -2, 0, 0, 2, 2};
	static final int[] dx = {-1, 1, -2, 2, -1, 1};
	static Pair startPos;
	static Pair dstPos;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				visited[i][j] = -1;
			}
		}
		
		String[] s = br.readLine().split("\\s");
		startPos = new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		dstPos = new Pair(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
		
		int answer = bfs();
		System.out.println(answer);
	}
	private static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(startPos);
		visited[startPos.y][startPos.x] = 0;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			if(curr.y == dstPos.y && curr.x == dstPos.x) {
				return visited[curr.y][curr.x];
			}
			for(int dir=0; dir<6; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if(visited[ny][nx]!=-1) continue;
				
				q.offer(new Pair(ny, nx));
				visited[ny][nx] = visited[curr.y][curr.x]+1;
				
			}
		}
		return -1;
		
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
