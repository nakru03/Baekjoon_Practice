import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static int[][] board;
	static int[][] board2; //확산값 저장을 위한 저장보드
	static int Y;
	static int X;
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		board = new int[Y][X];		
		for(int y=0; y<Y; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<X; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<T; ++i) {
			diffusion();	
			airClean();	
		}
		int result = 0;
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x]==-1) continue;
				result += board[y][x];
			}
			
		}
		System.out.println(result);
	}
	private static void airClean() {
		Pair start=null;
		Pair start2=null;
		board2 = new int[Y][X];
		//공청 시작점 찾기
		out:for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x] == -1) {
					start = new Pair(y,x);
					start2 = new Pair(y+1,x);
					break out;
				}
			}
		}
		//위쪽 공기청정기의 start 순환
		////----->
		for(int x=start.x+1; x<X; ++x) {
			board2[start.y][x] = board[start.y][x-1];
			if(board2[start.y][x]==-1)
				board2[start.y][x]=0;			
		}
		//위로
		for(int y=start.y-1; y>=0; --y) {
			board2[y][X-1] = board[y+1][X-1];
		}
		//<--------
		for(int x=X-2; x>=0; --x) {
			board2[0][x] = board[0][x+1];
		}
		//아래로
		for(int y=1; y<start.y; ++y) {
			board2[y][0] = board[y-1][0];
		}
		//복사
		for(int x=start.x+1; x<X; ++x) {
			board[start.y][x] = board2[start.y][x];
		}
		for(int y=start.y-1; y>=0; --y) {
			board[y][X-1] = board2[y][X-1];
		}
		for(int x=X-2; x>=0; --x) {
			board[0][x] = board2[0][x];
		}
		for(int y=1; y<start.y; ++y) {
			board[y][0] = board2[y][0];
		}
		//아래쪽 공기청정기..
		for(int x=start2.x+1; x<X; ++x) {
			board2[start2.y][x] = board[start2.y][x-1];
			if(board2[start2.y][x]==-1)
				board2[start2.y][x]=0;			
		}
		
		//아래로
		for(int y=start2.y+1; y<Y; ++y) {
			board2[y][X-1] = board[y-1][X-1];
		}
		//<--------
		for(int x=X-2; x>=0; --x) {
			board2[Y-1][x] = board[Y-1][x+1];
		}		
		//위로
		for(int y=Y-2; y>start2.y; --y) {
			board2[y][0] = board[y+1][0];
		}		
		//복사
		for(int x=start2.x+1; x<X; ++x) {
			board[start2.y][x] = board2[start2.y][x];
		}
		for(int y=start2.y+1; y<Y; ++y) {
			board[y][X-1] = board2[y][X-1];
		}
		for(int x=X-2; x>=0; --x) {
			board[Y-1][x] = board2[Y-1][x];
		}
		for(int y=Y-2; y>start2.y; --y) {
			board[y][0] = board2[y][0];
		}
	}
	
	
	private static void diffusion() {
		Queue<Pair> q = new LinkedList<>();
		board2 = new int[Y][X];
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x]>0) {
					q.offer(new Pair(y,x)) ;
				}
			}			
		}
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			int count = 0;
			for(int dir=0; dir<4; ++dir) {				
				int ny = curr.y+dy[dir];
				int nx = curr.x+dx[dir];
				if(ny<0 || nx<0 || ny>=Y || nx>=X) continue;
				if(board[ny][nx]==-1) continue;
				
				board2[ny][nx] += board[curr.y][curr.x] / 5;
				count++;				
			}
			board[curr.y][curr.x] -= (board[curr.y][curr.x]/5)*count;
		}
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				board[y][x] += board2[y][x];
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
