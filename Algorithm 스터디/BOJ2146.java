import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {
	static int[][] board;
	static boolean[][] visited;
	static int[][] bridge;
	static final int[] dx = {1,0,-1,0};
	static final int[] dy = {0,1,0,-1};
	static int min = Integer.MAX_VALUE;
	static Queue<Pair> islandQ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		bridge = new int[n][n];
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//섬 네이밍.
		int idx = 1;
		for(int y=0; y<n; ++y) {
			for(int x=0; x<n; ++x) {
				namingIsland(new Pair(y,x), idx++);
			}			
		}
		//q2에 모든 섬을 넣음.
		islandQ = new LinkedList<>();
		for(int y=0; y<n; ++y) {
			for(int x=0; x<n; ++x) {
				if(board[y][x]==0) continue;
				islandQ.offer(new Pair(y,x));
			}
		}
		//q2에서 하나씩 빼면서 확장		
		makeBridge();
		System.out.println(min);
		
		
	}
	
	
	//다리만들기
	private static void makeBridge() {
		
		while(!islandQ.isEmpty()) {
			Pair curr = islandQ.poll();
			
			for(int dir=0; dir<4; ++dir) {				
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				if(ny<0 || nx<0 || ny >= board.length || nx >= board.length) continue;
				if(board[ny][nx] == board[curr.y][curr.x]) continue;
				if(board[ny][nx] != board[curr.y][curr.x] && board[ny][nx]!=0) {
					int tmp = bridge[curr.y][curr.x] + bridge[ny][nx];
					System.out.println(tmp);
					min = Math.min(min, tmp); //다리 완성
				}
				else {
					islandQ.offer(new Pair(ny, nx));
					board[ny][nx] = board[curr.y][curr.x];
					bridge[ny][nx] = bridge[curr.x][curr.y]+1;
				}
				
				
			}
		}		
	}

	//bfs 단지번호 붙이기와 동일
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
				visited[curr.y][curr.x] = true;
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
