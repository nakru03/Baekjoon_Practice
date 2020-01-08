import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] board;
	static boolean[][] visited;
	static Queue<Pos> q = new LinkedList<>(); //백조
	static Queue<Pos> q2 = new LinkedList<>(); //다음 큐
	static Queue<Pos> q3 = new LinkedList<>();
	static boolean flag;
	static Pos swan1, swan2;
	static int answer;
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		visited = new boolean[N][M];
		
		for(int y=0; y<N; ++y) {
			board[y] = br.readLine().toCharArray();
			for(int x=0; x<M; ++x) {
				if(board[y][x]=='L' && swan1==null) {
					swan1 = new Pos(y,x);
					q3.offer(swan1);
				}else if(board[y][x]=='L' && swan1!=null) {
					swan2 = new Pos(y,x);
					q3.offer(swan2);
				}else if(board[y][x]=='.') {
					q3.offer(new Pos(y,x));
				}
			}
		}
		visited[swan1.y][swan1.x] = true;
		q.offer(swan1);
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		int day = 0;
		while(true) {
			q2.clear();
			
			int ny, nx;
			
			while(!q.isEmpty()) {
				
				Pos curr = q.poll();
				if(curr.y == swan2.y && curr.x == swan2.x) {
					answer = day;
					return;
				}
				for(int dir=0; dir<4; ++dir) {
					ny = curr.y + dy[dir];
					nx = curr.x + dx[dir];
					
					if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
					if(visited[ny][nx]) continue;
					visited[ny][nx] = true;
					if(board[ny][nx]=='X') {
						q2.offer(new Pos(ny, nx));
						continue;
					}
					
					q.offer(new Pos(ny, nx));
					
				}
			}
			
			while(!q2.isEmpty()) {
				q.offer(q2.poll());
			}
			
			int qs = q3.size();
			
			for(int i=0; i<qs; ++i) {
				Pos curr = q3.poll();
				
				for(int dir=0; dir<4; ++dir) {
					ny = curr.y + dy[dir];
					nx = curr.x + dx[dir];
					
					if(ny<0 || nx<0 || ny>=N || nx>=M || board[ny][nx]=='.') continue;
					if(board[ny][nx]=='X') {
						board[ny][nx]='.';
						q3.offer(new Pos(ny, nx));
					}
				}
			}
			day++;
		}
	}


	static class Pos{
		int y, x, dist;
		
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
