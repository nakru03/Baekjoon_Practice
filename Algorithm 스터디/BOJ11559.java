import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {
	
	static final int Y = 12;
	static final int X = 6;
	
	static int chain;
	static int answer;
	static boolean isChain = false;
	
	static String[][] board = new String[Y][X];
	static boolean[][] visited;	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	
	static ArrayList<Pair> puyoList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int y=0; y<Y; ++y) {
			board[y] = br.readLine().split("");
		}
		
		
		out : while(true) {
			visited = new boolean[Y][X];
			isChain = false;
			for(int y=0; y<Y; ++y) {
				for(int x=0; x<X; ++x) {
					if(!board[y][x].equals(".")) {
						if(visited[y][x]) continue;
						bfs(y,x);
					}
				}
			}			
			if(!isChain) break out;			
			dropPuyo();			
		}
		System.out.println(chain);
	}
	private static void dropPuyo() {
		Queue<String> q = new LinkedList<>();
		for(int x=0; x<X; ++x) {
			for(int y=Y-1; y>=0; --y) {
				if(!board[y][x].equals(".")) {
					q.offer(board[y][x]);
					board[y][x] = ".";
				}				
			}

			for(int y=Y-1; y>=0; --y) {
				if(q.isEmpty()) break;
				board[y][x] = q.poll();				
			}
		}
	}
	private static void bfs(int sy, int sx) {
		Queue<Pair> q = new LinkedList<>();
		
		q.offer(new Pair(sy, sx));
		visited[sy][sx] = true;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			puyoList.add(new Pair(curr.y, curr.x));
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || ny>=Y || nx>=X) continue;
				if(visited[ny][nx] || !board[sy][sx].equals(board[ny][nx])) continue;				
				q.offer(new Pair(ny, nx));
				visited[ny][nx] = true;				
			}
		}
		
		if(puyoList.size()>=4) {
			if(!isChain) {
				chain++;
				isChain = true;
			}
			
			for(int i=0; i<puyoList.size(); ++i) {
				Pair curr = puyoList.get(i);
				board[curr.y][curr.x] = ".";
			}			
		}
		puyoList.clear();
	}
	
	
	static void print() {
		for(int i=0; i<Y; ++i) {
			for(int j=0; j<X; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}		
	}
}
