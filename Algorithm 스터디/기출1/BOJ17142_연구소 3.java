import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M;
	static int[][] board;
	static int[][] board2;
	static ArrayList<Virus> list = new ArrayList<>();
	static Queue<Virus> q = new LinkedList<>();
	
	static int time;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split("\\s");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		board = new int[N][N];

		for (int y = 0; y < N; ++y) {
			s = br.readLine().split("\\s");
			for (int x = 0; x < N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				if (board[y][x] == 2) {
					list.add(new Virus(y, x));
					board[y][x] = -2;
				}else if (board[y][x] == 1) {
					board[y][x] = -1;
				}
			}
		}
		visited = new boolean[list.size()];
		dfs(0, 0);
		System.out.println(answer);
	}

	static boolean visited[];
	static ArrayList<Virus> result = new ArrayList<>();
	static int answer = -1;

	private static void dfs(int idx, int depth) {
		if (depth == M) {
			copy();
			bfs();
			q.clear();
			time=0;


		}
		for (int i = idx; i < list.size(); ++i) {
			if (visited[i])
				continue;
			visited[i] = true;
			result.add(list.get(i));
			dfs(i, depth + 1);
			visited[i] = false;
			result.remove(result.size() - 1);

		}
	}

	private static void copy() {
		board2 = new int[N][N];
		for (int y = 0; y < N; ++y) {
			for (int x = 0; x < N; ++x) {
				board2[y][x] = board[y][x];
			}
		}
	}

	private static void bfs() {
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < M; ++i) {
			q.offer(result.get(i));
			visited[result.get(i).y][result.get(i).x] = true;
			board2[result.get(i).y][result.get(i).x] = -3;
		}

		while (!q.isEmpty()) {

			int qs = q.size();
			time++;
			for (int i = 0; i < qs; ++i) {
				Virus curr = q.poll();

				for (int dir = 0; dir < 4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;
					if (visited[ny][nx] || board2[ny][nx] == -1)
						continue;
					if (board2[ny][nx] == -2) {
						visited[ny][nx] = true;
						q.offer(new Virus(ny, nx));
					} else {
						board2[ny][nx] = time;
						visited[ny][nx] = true;
						q.offer(new Virus(ny, nx));
					}

				}

			}

		}

		check();
	}

	private static void check() {
		int level = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board2[i][j] == 0) {
					return;
				}
				if (board2[i][j] > 0)
					level = Math.max(level, board2[i][j]);
			}
		}
		
		if (answer == -1)
			answer = level;
		answer = Math.min(answer, level);

	}

	static class Virus {
		int y;
		int x;

		public Virus(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
