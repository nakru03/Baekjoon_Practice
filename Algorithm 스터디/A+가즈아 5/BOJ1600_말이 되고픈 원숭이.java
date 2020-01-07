import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1600 {

	static int K;
	static int N;
	static int M;
	static int[][] board;
	static boolean[][][] visited;
	static int nowTime;

	static int[] hy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		String[] s = br.readLine().split("\\s");

		M = Integer.parseInt(s[0]);

		N = Integer.parseInt(s[1]);

		board = new int[N][M];

		visited = new boolean[N][M][K + 1];

		for (int y = 0; y < N; ++y) {

			s = br.readLine().split("\\s");

			for (int x = 0; x < M; ++x) {

				board[y][x] = Integer.parseInt(s[x]);

			}

		}

		if (bfs()) {
			System.out.println(nowTime);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean bfs() {
		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(0, 0, K));
		visited[0][0][K] = true;

		while (!q.isEmpty()) {

			int qs = q.size();

			for (int i = 0; i < qs; ++i) {
				Pair curr = q.poll();
				
				if (curr.y == N - 1 && curr.x == M - 1) {
					return true;
				}
				
				if (curr.k > 0) {
					for (int dir = 0; dir < 8; ++dir) {
						int ny = curr.y + hy[dir];
						int nx = curr.x + hx[dir];

						if (ny < 0 || nx < 0 || ny >= N || nx >= M)
							continue;
						if (visited[ny][nx][curr.k - 1] || board[ny][nx] == 1)
							continue;
						q.offer(new Pair(ny, nx, curr.k - 1));
						visited[ny][nx][curr.k - 1] = true;
					}
				}
				for (int dir = 0; dir < 4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (visited[ny][nx][curr.k] || board[ny][nx] == 1)
						continue;
					q.offer(new Pair(ny, nx, curr.k));
					visited[ny][nx][curr.k] = true;
				}
			}
			nowTime++;
		}

		return false;
	}

	static class Pair {
		int y;
		int x;
		int k;

		public Pair(int y, int x, int k) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
		}

	}
}
