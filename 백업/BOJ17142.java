import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142 {
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static int[][] board;
	static boolean[][] visited;
	static boolean[] backTrack;
	static int N;
	static int M;
	static ArrayList<Virus> list;
	static Queue<Virus> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		backTrack = new boolean[N];
		list = new ArrayList<>();
		for(int y=0; y<N; ++y) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; ++x) {
				board[y][x] = -Integer.parseInt(st.nextToken());
				if(board[y][x] == -2) {
					list.add(new Virus(y, x, false)); //모든 바이러스 리스트에..
				}
			}
		}
		selectStart(0,0);
		print();
		
		
	}

	static void selectStart(int idx, int depth) {
		if (depth == M) {
			q = new LinkedList<>();
			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i).onOff) {
					q.add(list.get(i)); // 큐에 시작바이러스 삽입.
					visited[list.get(i).y][list.get(i).x] = true;
					board[list.get(i).y][list.get(i).x] = -3; // 활성바이러스.
				}
			}
			bfs();
			// 초기화 해야할것,. 비짓배열..
		}
		for (int i = idx; i < list.size(); ++i) {
			backTrack[i] = true;
			list.get(i).onOff = true;
			selectStart(idx, depth + 1);
			list.get(i).onOff = false;
			backTrack[i] = true;
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int qSize = q.size();
			int level = 1; 
			for(int i=0; i<qSize; ++i){
				Virus curr = q.poll();
				for (int dir = 0; dir < 4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
					if(board[ny][nx] == -1 || visited[ny][nx]) continue;
					if(board[ny][nx]==-2) {
						board[ny][nx] = -3;
						q.offer(new Virus(ny, nx, true));
					}
				}
			}
			level++;
		}
	}

	static void print() {
		System.out.println("##################################################");
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("###################################################");

	}

	static class Virus {
		int y;
		int x;
		boolean onOff;

		Virus(int y, int x, boolean onOff) {
			this.y = y;
			this.x = x;
		}
	}

}
