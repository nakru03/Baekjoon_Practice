import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 백준 2151
 * 거울 설치 
 * @author nakru03
 * 
 * 빛의 속성 직진만함.
 * 거울 만나면 ㄴ  모양으로 이동
 * 거울은 2개방향(양면) 으로 설치가 가능
 *
 */
public class Main {
	static int N;
	static char[][] board;
	static int[][][] dist;
	static Queue<Light> q = new LinkedList<>();
	
	static Light start;
	static Light dst;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		

		for(int y=0; y<N; ++y) {
			char[] s = br.readLine().toCharArray();
			for(int x=0; x<N; ++x) {
				board[y][x] = s[x];
				if(board[y][x]=='#' && start==null) {
					start = new Light(y,x,-1); //시작점
				}else if(board[y][x]=='#' && start!=null) {
					dst = new Light(y,x,-1); //도착점
				}
			}
			
		}//입력 end
		dist = new int[N][N][4];
		//System.out.println(start);
		//System.out.println(dst);
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				for(int k=0; k<4; ++k) {
					dist[i][j][k] = 987654321;
				}
			}
		}
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		q.offer(start);
		
		for(int i=0; i<4; ++i) {
			dist[start.y][start.x][i] = 0;
		}
		//초기 큐 상황
		
		
		while(!q.isEmpty()) {
			
			Light curr = q.poll();
			
			//System.out.println("y 좌표 : " + curr.y + " x 좌표 : " + curr.x + " dst : " + curr.dir);
			/*if(curr.dir != -1) {
				for(int i=0; i<N; ++i) {
					for(int j=0; j<N; ++j) {
					
						System.out.print(dist[i][j][curr.dir] + " ");
					}
					System.out.println();
				}
			}*/
			
			
			if(curr.y == dst.y && curr.x == dst.x) {
				answer = Math.min(answer, dist[curr.y][curr.x][curr.dir]);
			}//base case			
				
			if(curr.dir==-1) {
				for(int dir=0; dir<4; ++dir) {
					
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					
					if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
					if(board[ny][nx]=='*') continue;
					
					dist[ny][nx][dir] = 0;
					q.offer(new Light(ny,nx,dir));
					
					if(board[ny][nx]=='!') {
						if(dir==0 || dir == 2) { // 현재 빛의 이동방향이 <- ->일때
							
							dist[ny][nx][1] = dist[curr.y][curr.x][dir]+1;
							q.offer(new Light(ny, nx, 1));
							
							
							dist[ny][nx][3] = dist[curr.y][curr.x][dir]+1;
							q.offer(new Light(ny, nx, 3));												
							
						}
						else {
							
							dist[ny][nx][0] = dist[curr.y][curr.x][dir]+1;
							q.offer(new Light(ny, nx, 0));
						
						
						
							dist[ny][nx][2] = dist[curr.y][curr.x][dir]+1;
							q.offer(new Light(ny, nx, 2));
							
						}
					}
				}
			}//처음 시작때만 함 이때도 !가 바로있을 수 있다.
			
			else if(curr.dir != -1) {
				
				int ny = curr.y + dy[curr.dir];
				int nx = curr.x + dx[curr.dir];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if(board[ny][nx]=='*') continue;
				//다음 도착 보다 현재 거울 갯수가 작으면 방문가능..
				if(dist[ny][nx][curr.dir] > dist[curr.y][curr.x][curr.dir]) {
					dist[ny][nx][curr.dir] = dist[curr.y][curr.x][curr.dir];
					q.offer(new Light(ny, nx, curr.dir));
				}
				
				
				if(board[ny][nx]=='!') {
					if(curr.dir==0 || curr.dir == 2) { // 현재 빛의 이동방향이 <- ->일때
						
						if(dist[ny][nx][1] > dist[curr.y][curr.x][curr.dir]+1) {
							dist[ny][nx][1] = dist[curr.y][curr.x][curr.dir]+1;
							q.offer(new Light(ny, nx, 1));
						}
						
						if(dist[ny][nx][3] > dist[curr.y][curr.x][curr.dir]+1) {
							dist[ny][nx][3] = dist[curr.y][curr.x][curr.dir]+1;
							q.offer(new Light(ny, nx, 3));
						}					
						
					}
					else {
						if(dist[ny][nx][0] > dist[curr.y][curr.x][curr.dir]+1) {
							dist[ny][nx][0] = dist[curr.y][curr.x][curr.dir]+1;
							q.offer(new Light(ny, nx, 0));
						}
						
						if(dist[ny][nx][2] > dist[curr.y][curr.x][curr.dir]+1) {
							dist[ny][nx][2] = dist[curr.y][curr.x][curr.dir]+1;
							q.offer(new Light(ny, nx, 2));
						}	
					}
				}
			}
			
		}
		
	}
	
	static class Light{
		int y;
		int x;
		int dir;
		
		public Light(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;			
		}

		
	}
}
