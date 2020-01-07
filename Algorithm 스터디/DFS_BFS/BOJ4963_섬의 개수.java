import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ4963 {
	static int[][] board;
	static boolean[][] visited;
	static int x;
	static int y;
	static final int[] dx = {1,1,0,-1,-1,-1, 0, 1};
	static final int[] dy = {0,1,1, 1, 0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = null;
		while(true) {
			tokenizer = new StringTokenizer(br.readLine());
			x = Integer.parseInt(tokenizer.nextToken());			
			y = Integer.parseInt(tokenizer.nextToken());
			board = new int[y][x];
			visited = new boolean[y][x];
			int count = 0;
			if(x==0 && y==0) break;
			for(int i=0; i<y; ++i) {
				tokenizer = new StringTokenizer(br.readLine());
				 for(int j=0; j<x; ++j) {
					 board[i][j] = Integer.parseInt(tokenizer.nextToken());
					 //System.out.println(board[i][j]);
				 }
			}
			for(int i=0; i<y; ++i) {
				for(int j=0; j<x; ++j) {
					//System.out.println(visited[i][j]);
					if(board[i][j] == 0 || visited[i][j]) continue;
					bfs(i, j);
					count++;
				}
			}
			System.out.println(count);
		}
	}
	private static void bfs(int i, int  j) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i,j));
		visited[i][j] =true;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();			
			for(int dir=0; dir<8; ++dir) {
				int ny = curr.y+dy[dir];
				int nx = curr.x+dx[dir];
				if(ny<0 || ny>=y || nx<0 | nx>=x) continue;
				if(board[ny][nx] == 0 || visited[ny][nx]) continue;
				visited[ny][nx] = true;
				q.offer(new Pair(ny, nx));
				
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
