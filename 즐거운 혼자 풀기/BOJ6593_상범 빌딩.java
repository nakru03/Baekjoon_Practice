import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char board[][][];
	static boolean visited[][][];
	static int L,N,M;
	static Queue<Pos> q = new LinkedList<>();
	static final int[] dy = {0,1,0,-1,0,0};
	static final int[] dx = {1,0,-1,0,0,0};
	static final int[] dz = {0,0,0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		while(true) {
			st = new  StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			q.clear();
			
			if(L==0 && N==0 && M==0) break;
			
			board = new char[L][N][M];
			visited = new boolean[L][N][M];
			for(int z=0; z<L; ++z) {
				for(int y=0; y<N; ++y) {
					String[] s = br.readLine().split("");
					for(int x=0; x<M; ++x) {
						board[z][y][x] = s[x].charAt(0);
						if(board[z][y][x]=='S') {
							q.offer(new Pos(z,y,x,0));
							visited[z][y][x] = true;
						}
					}
				}
				br.readLine();
			}
			int nz, ny, nx;
			int answer = -1;
			while(!q.isEmpty()) {
				Pos curr = q.poll();
				
				if(board[curr.z][curr.y][curr.x]=='E') {
					answer = curr.min;
				}
				for(int dir=0; dir<6; ++dir) {
					nz = curr.z + dz[dir];
					ny = curr.y + dy[dir];
					nx = curr.x + dx[dir];
					
					if(nz<0 || ny<0 || nx<0 || nz>=L || ny>=N || nx>=M) continue;
					if(visited[nz][ny][nx] || board[nz][ny][nx]=='#') continue;
					
					visited[nz][ny][nx] = true;
					q.offer(new Pos(nz, ny, nx, curr.min+1));
					
 				}
			}
			System.out.println(answer==-1 ? "Trapped!" : "Escaped in " + answer + " minute(s).");
			
		}
		
	}
	private static void print() {
		for(int z=0; z<L; ++z) {
			for(int y=0; y<N; ++y) {
				for(int x=0; x<M; ++x) {
					System.out.print(board[z][y][x]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}
	static class Pos{
		int z;
		int y;
		int x;
		int min;
		public Pos(int z, int y, int x, int min) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
			this.min = min;
		}
	}
}
