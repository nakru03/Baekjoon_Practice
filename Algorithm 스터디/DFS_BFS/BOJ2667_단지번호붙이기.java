import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
	static int[][] board;
	static boolean[][] visited;
	static final int[] dx = {1,0,-1,0};
	static final int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; ++i) {
			String[] s = br.readLine().split("");
			for(int j=0; j<s.length; ++j) {
				board[i][j] = Integer.parseInt(s[j]);
			}
		}
		int danji = 0;
		ArrayList<Integer> result = new ArrayList<>();
		for(int y=0; y<n; ++y) {
			for(int x=0; x<n; ++x) {
				if(board[y][x] == 0 || visited[y][x]) continue;			
				result.add(bfs(new Pair(y, x)));
				danji++;
			}
		}
		System.out.println(danji);
		Collections.sort(result);
		for(int i=0; i<result.size(); ++i) {
			System.out.println(result.get(i));
		}
	}
	
	private static int bfs(Pair pair) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(pair);
		visited[pair.y][pair.x] = true;
		int count = 0;
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			count++;
			for(int dir=0; dir<4; ++dir) {
				int nx = curr.x + dx[dir];
				int ny = curr.y + dy[dir];
				
				if(nx<0 || ny <0 || nx>=board.length || ny>=board.length) continue;
				if(board[ny][nx] == 0 || visited[ny][nx] ) continue;
				q.offer(new Pair(ny,nx));
				visited[ny][nx] = true;
				
			}
		}
		return count;
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
