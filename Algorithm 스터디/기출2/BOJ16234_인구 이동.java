import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] board;
	static boolean[][] visited;
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static ArrayList<Pair> pos;
	static boolean flag = true;
	static int res = 0;
	static int sum = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		board = new int[N][N];
		for(int y=0; y<N; ++y) {
			s = br.readLine().split(" ");
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		while(true) {
			if(!flag) break;
			flag = false;
			
			//print();
			res++;
			//인구이동 시작.
			visited = new boolean[N][N];			
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					if(visited[y][x]) continue;					
					bfs(y,x);
					
				}
			}
		}
		
		System.out.println(res-1);
		
		 
	}


	private static void bfs(int y, int x) {
		Queue<Pair> q  = new LinkedList<>();
		pos = new ArrayList<>();
		
		q.offer(new Pair(y, x));
		pos.add(new Pair(y, x));
		visited[y][x] = true;
		int ground = 1;
		sum += board[y][x];
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
					
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(visited[ny][nx]) continue;
			
				if(L<= Math.abs(board[ny][nx]-board[curr.y][curr.x]) && Math.abs(board[ny][nx]-board[curr.y][curr.x]) <= R) { //국경 오픈
					flag = true;
					ground++;
					sum+=board[ny][nx];
					q.offer(new Pair(ny, nx));
					pos.add(new Pair(ny, nx));
					visited[ny][nx] = true;
					
				}
			}
		}
		int ingu = sum / ground;
		
		for(int i=0; i<pos.size(); ++i) {
			Pair curr = pos.get(i);
			board[curr.y][curr.x] = ingu;
		}		
		sum = 0;
	}
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}
