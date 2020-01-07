import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] board;
	static boolean[][][][] visited;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	static Pos blue, red;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for(int y=0; y<N; ++y) {
			board[y] = br.readLine().toCharArray();
			for(int x=0; x<M; ++x) {
				if(board[y][x]=='B') {
					blue = new Pos(y,x);
				}else if(board[y][x]=='R') {
					red = new Pos(y,x);
				}
			}
		}
		
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Bid> q = new LinkedList<>();
		visited[blue.y][blue.x][red.y][red.x] = true;
		q.offer(new Bid(red.y, red.x, blue.y, blue.x, 0));
		
		int ry, rx, by, bx;
		while(!q.isEmpty()) {
			Bid curr = q.poll();
			if(curr.dist>10) return -1;
			if(board[curr.ry][curr.rx]=='O') return curr.dist;
			for(int dir=0; dir<4; ++dir) {
				ry = curr.ry;
				rx = curr.rx;
				by = curr.by;
				bx = curr.bx;
				
				while(true) {
					ry += dy[dir];
					rx += dx[dir];
					
					if(board[ry][rx]=='#') {
						ry -= dy[dir];
						rx -= dx[dir];
						break;
					}
					if(board[ry][rx]=='O') {
						break;
					}
				}
				
				while(true) {
					by += dy[dir];
					bx += dx[dir];
					
					if(board[by][bx]=='#') {
						by -= dy[dir];
						bx -= dx[dir];
						break;
					}
					if(board[by][bx]=='O') {
						break;
					}
				}
				
				if(board[by][bx]=='O') continue;
				if(by==ry && bx==rx) {
					if(dir==0) {
						if(curr.rx < curr.bx) rx--;
						else bx--;
					}else if(dir==1) {
						if(curr.ry < curr.by) ry--;
						else by--;
					}
					else if(dir==2) {
						if(curr.rx < curr.bx) bx++;
						else rx++;
					}
					else if(dir==3) {
						if(curr.ry < curr.by) by++;
						else ry++;
					}
				}
				if(visited[by][bx][ry][rx]) continue;
				visited[by][bx][ry][rx] = true;
				q.offer(new Bid(ry, rx, by, bx, curr.dist+1));
			}
		}
		return -1;
	}
	
	static class Bid{
		int ry;
		int rx;
		int by;
		int bx;
		int dist;
		public Bid(int ry, int rx, int by, int bx, int dist) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.dist = dist;
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
