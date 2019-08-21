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
		board2 = new int[Y][X];
		for(int y=0; y<Y; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<X; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		//출력
//		for(int y=0; y<Y; ++y) {
//			for(int x=0; x<X; ++x) {
//				System.out.print(board[y][x] +" ");
//			}
//			System.out.println();
//			
//		}
//		System.out.println();
		diffusion();
		System.out.println();

		System.out.println();
		
		airClean();
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				System.out.print(board2[y][x] +" ");
			}
			System.out.println();			
		}
	}
	private static void airClean() {
		Pair start=null;
		Pair start2=null;
		//공청 시작점 찾기
		out:for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x] == -1) {
					start = new Pair(y,x);
					start2 = new Pair(y-1,x);
					break out;
				}
			}
		}
		
		int tmp = 0;
		//------->
		for(int x = start.x+1; x<X; ++x) {
			int curr = board[start.y][x];
			int before = board[start.y][x-1];
			if(before==-1) {
				curr = 0;
			}else if(x==x-1) {
				tmp = curr;
				curr = before;
			}
			else {
				curr = before;
			}
		}
		//위로 
		for(int y = start.y+1; y>=0; --y) {
			int curr = board[y][start.x];
			int before = board[y+1][start.x];
			if(y==start.y+1) {				
				curr = tmp;
			}else if(y== 0) {
				tmp = curr;
				curr = before;
			}else {
				curr = before;
			}						
		}
		for(int x = X-1; x>=0; --x) {
			int curr = board[0][x];
			int before = board[0][x-1];
			if(x==X-1) {				
				curr = tmp;
			}else if(x==0) {
				tmp = curr;
				curr = before;
			}else {
				curr = before;
			}						
		}
		
		for(int y=0; y<start.y; y++) {
			int curr = board[y][0];
			int before = board[y-1][0];
			if(y==0) {
				curr = tmp;
			}else
				curr = before;
		}
	
		
	}
	private static void diffusion() {
		Queue<Pair> q = new LinkedList<>();
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
