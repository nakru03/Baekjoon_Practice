import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15683 {
	static int Y;
	static int X;
	static int[][] board;
	static ArrayList<Cctv> list;
	static ArrayList<Cctv> wall;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		Y = Integer.parseInt(s[0]);
		X = Integer.parseInt(s[1]);
		int count = 0;
		board = new int[Y][X];
		list = new ArrayList<Cctv>();
		wall = new ArrayList<Cctv>();
		for (int y = 0; y < Y; ++y) {
			s = br.readLine().split(" ");
			for (int x = 0; x < X; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				if (board[y][x] > 0 && board[y][x] < 6) {
					list.add(new Cctv(y, x, board[y][x]));
					if (board[y][x] == 5) //5는 perm에 넣지 않음.
						continue;
					count++;
				} else if (board[y][x] == 6) {
					wall.add(new Cctv(y, x, -1)); // 배열 리셋시 위치값떄문에.

				}
			}

		}
		dfs(0, count); //dfs 솔루션..
		System.out.println(min);

	}

	static int min = Integer.MAX_VALUE;
	static ArrayList<Integer> perm = new ArrayList<>();

	private static void dfs(int depth, int count) {
		if (depth == count) { //순열 완성.
			Search();
			System.out.println("######################################");
			for (int i = 0; i < Y; ++i) {
				for (int j = 0; j < X; ++j) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("######################################");
			min = Math.min(min, minCheck());
			reset();

			return;
		}
		for (int i = 1; i <= 4; ++i) {
			perm.add(i);
			dfs(depth + 1, count);
			perm.remove(perm.size() - 1);
		}
	}

	static void Search() {
		for (int i = 0; i < perm.size(); ++i) {
			switch (perm.get(i)) {
			case 1:
				if (list.get(i).num == 1) {
					left(i);
				} else if (list.get(i).num == 2) {
					left(i);
					right(i);
				} else if (list.get(i).num == 3) {
					up(i);
					right(i);
				} else if (list.get(i).num == 4) {
					left(i);
					right(i);
					up(i);
				}
				break;
			case 2:
				if (list.get(i).num == 1) {
					right(i);
				} else if (list.get(i).num == 2) {
					left(i);
					right(i);
				} else if (list.get(i).num == 3) {
					up(i);
					left(i);
				} else if (list.get(i).num == 4) {
					up(i);
					down(i);
					right(i);
				}
				break;
			case 3:
				if (list.get(i).num == 1) {
					up(i);
				} else if (list.get(i).num == 2) {
					up(i);
					down(i);
				} else if (list.get(i).num == 3) {
					down(i);
					right(i);
				} else if (list.get(i).num == 4) {
					down(i);
					right(i);
					left(i);
				}
				break;
			case 4:
				if (list.get(i).num == 1) {
					down(i);
				} else if (list.get(i).num == 2) {
					up(i);
					down(i);
				} else if (list.get(i).num == 3) {
					down(i);
					left(i);
				} else if (list.get(i).num == 4) {
					down(i);
					left(i);
					right(i);
				}
				break;
			}
		}
	}

	static int minCheck() {
		int count = 0;
		for (int y = 0; y < Y; ++y) {
			for (int x = 0; x < X; ++x) {
				if (board[y][x] == 0)
					count++;
			}
		}
		return count;
	}

	private static void up(int i) {
		int currY = list.get(i).y;
		int currX = list.get(i).x;
		while (true) {
			currY--;
			if (currY < 0 || board[currY][currX] == 6)
				break;
			else if (board[currY][currX] == 0)
				board[currY][currX] = 9;
		}
	}

	private static void down(int i) {
		int currY = list.get(i).y;
		int currX = list.get(i).x;
		while (true) {
			currY++;
			if (currY >= Y || board[currY][currX] == 6)
				break;
			else if (board[currY][currX] == 0)
				board[currY][currX] = 9;
		}
	}

	private static void left(int i) {
		int currY = list.get(i).y;
		int currX = list.get(i).x;
		while (true) {
			currX--;
			if (currX < 0 || board[currY][currX] == 6)
				break;
			else if (board[currY][currX] == 0)
				board[currY][currX] = 9;
		}
	}

	private static void right(int i) {
		int currY = list.get(i).y;
		int currX = list.get(i).x;
		while (true) {
			currX++;
			if (currX >= X || board[currY][currX] == 6)
				break;
			else if (board[currY][currX] == 0)
				board[currY][currX] = 9;
		}
	}

	static void reset() {
		for (int y = 0; y < Y; ++y) {
			for (int x = 0; x < X; ++x) {
				board[y][x] = 0;
			}
		}
		for (int i = 0; i < wall.size(); ++i) {
			Cctv tmp = wall.get(i);
			board[tmp.y][tmp.x] = 6;
		}
		for (int i = 0; i < list.size(); ++i) {
			Cctv curr = list.get(i);
			board[curr.y][curr.x] = curr.num;
			if (curr.num == 5) {
				left(i);
				right(i);
				down(i);
				up(i);
			}
		}
	}

	static class Cctv {
		int y;
		int x;
		int num;

		Cctv(int y, int x, int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}

}
