import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] board = new char[12][6];
	static boolean[][] visited;
	static Queue<Pos> q = new LinkedList<>();
	
	static int y,x;
	static final int dy[] = {0,1,0,-1};
	static final int dx[] = {1,0,-1,0};
	static ArrayList<Pos> list = new ArrayList<>();
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(y=0; y<12; ++y) {
			board[y] = br.readLine().toCharArray();
		}
		boolean flag = false;
		int ret;
		
		while(true) {
			ret = 0;
			q.clear();
			visited = new boolean[12][6];
			
			for(y=11; y>=0; --y) {
				for(x=0; x<6; ++x) {
					if(visited[y][x] || board[y][x]=='.') continue;
					ret += bfs(new Pos(y,x));
				}
			}
			if(ret==0) break;
			drop();
			answer ++;
			
		}
		System.out.println(answer);
	}

	private static void drop() {
		for(y=10; y>=0; --y) {
			for(x=0; x<6; ++x) {
				if(board[y][x]=='.') continue;
				int tmp = y;
				
				while(true) {
					if(tmp==11 || board[tmp+1][x] != '.') break;
					board[tmp+1][x] = board[tmp][x];
					board[tmp][x] = '.';
					tmp++;
				}
			}
		}
	}

	private static int bfs(Pos start) {
		q.clear();
		visited[start.y][start.x] = true;
		q.offer(start);
		char word = board[start.y][start.x];
		
		
		int dir, ny, nx;
		int boom=0;

		while(!q.isEmpty()) {
			
			Pos curr = q.poll();
			
			list.add(curr);
			for(dir=0; dir<4; ++dir) {
				ny = curr.y + dy[dir];
				nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || ny>=12 || nx>=6) continue;
				if(visited[ny][nx] || board[ny][nx]!=word) continue;
				
				visited[ny][nx] = true;
				q.offer(new Pos(ny, nx));
			}
			if(list.size()>=4) {
				boom++;
				for(int i=0; i<list.size(); ++i) {
					board[list.get(i).y][list.get(i).x] = '.';
				}
			}
		}
		list.clear();
		return boom;
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
