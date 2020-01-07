import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static int[][] board;
	
	static int[] dy = {0,1,1};
	static int[] dx = {1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];		
		
		for(int y=0; y<N; ++y) {
			String[] s = br.readLine().split("\\s");
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		dfs();
		System.out.println(count);
	}
	static int count;
	private static void dfs() {
		Stack<Pair> s = new Stack<>();
		s.push(new Pair(0,1,0));
		
		while(!s.isEmpty()) {
			Pair curr = s.pop();
			if(curr.y==N-1 && curr.x==N-1) {
				count++;
			}
			
			else if(curr.state == 0) {//가로
				
				int ny = curr.y+dy[0];
				int nx = curr.x+dx[0];
				
				if(nx<N && board[ny][nx]==0) {
					s.push(new Pair(ny, nx, 0));
				}
				
				////////////////////////////////////
				ny = curr.y + dy[2];
				nx = curr.x + dx[2];
				
				if(nx<N && ny<N && board[ny][nx]==0 && board[ny-1][nx]==0 && board[ny][nx-1]==0) {
					s.push(new Pair(ny, nx, 2));
				}
				
			}else if(curr.state == 1) {//세로
				int ny = curr.y+dy[1];
				int nx = curr.x+dx[1];
				
				if(ny<N && board[ny][nx]==0) {
					s.push(new Pair(ny, nx, 1));
				}
				////////////////////////////////////
				ny = curr.y + dy[2];
				nx = curr.x + dx[2];
				
				if(nx<N && ny<N && board[ny][nx]==0 && board[ny-1][nx]==0 && board[ny][nx-1]==0) {
					s.push(new Pair(ny, nx, 2));
				}
			}else {//대각
				int ny = curr.y+dy[0];
				int nx = curr.x+dx[0];
				
				if(nx<N && board[ny][nx]==0) {
					s.push(new Pair(ny, nx, 0));
				}
				///////////////////////////////
				ny = curr.y+dy[1];
				nx = curr.x+dx[1];
				
				if(ny<N && board[ny][nx]==0) {
					s.push(new Pair(ny, nx, 1));
				}
				////////////////////////////////////
				ny = curr.y + dy[2];
				nx = curr.x + dx[2];
				
				if(nx<N && ny<N && board[ny][nx]==0 && board[ny-1][nx]==0 && board[ny][nx-1]==0) {
					s.push(new Pair(ny, nx, 2));
				}
			}
		}
	}
	static class Pair{
		int y;
		int x;
		int state;
		public Pair(int y, int x, int state) {
			super();
			this.y = y;
			this.x = x;
			this.state = state;
		}
		
	}
}
