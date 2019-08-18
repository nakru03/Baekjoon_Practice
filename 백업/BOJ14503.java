import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/*
 * 로봇청소기 NxM의 보드위
 * 청소기의 바라보는 방향이 존재 동서남북중 하나
 * 현재 위치 청소 (visited)
 * 왼쪽에 청소 안했으면 그방향을 바라보고 한칸전진.
 * 왼쪽이미 청소했으면 왼쪽으로 회전하고 2번으로 돌아간다
 * 계속왼쪽으로 회전하면서 청소. 모두청소하면 뒤로한칸 후 반복
 * 더이상 청소를 못하면서 뒤로 못가면 스탑
 * 
 * 
 */
public class BOJ14503 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[][] board;
	static boolean[][] visited;
	static int N;
	static int M;
	static int startY;
	static int startX;
	static int dir;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		startY = Integer.parseInt(st.nextToken());
		startX = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int y=0; y<N; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean();
		int count = 0;
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {
				if(visited[i][j]) count++;
			}
		}
		System.out.println(count);
	}


	private static void clean() {
		while(true) {
			if(board[startY][startX]==0) {
				visited[startY][startX] = true;
			}
			
			int count=0;
			for(int i=0; i<4; ++i) {
				int ny = startY + dy[i];
				int nx = startX + dx[i];
				if(visited[ny][nx] || board[ny][nx]==1) {
					count++;
					continue;
				}
			}
			
			if(count==4) {
				int backdir = (dir+2) % 4;
				int backX = startX-dx[backdir];
				int backY = startY-dy[backdir];
				if(board[backX][backY]==1) break;
				
				startX = backX;
				startY = backY;
				
			}
			else {
				dir = (dir+3)%4;
				int ny = startY + dy[dir];
				int nx = startX + dx[dir];				
				if(board[ny][nx] == 0) {
					startY = ny;
					startX = nx;
				}				
				
			}		
			
		}
		
		
		
	}
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y=y;
			this.x=x;
			
		}
	}
}
