import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int Y;
	static int X;
	static int[][] board;
	static ArrayList<Cctv> list;
	static ArrayList<Cctv> wall;
	static ArrayList<Cctv> only5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		Y = Integer.parseInt(s[0]);
		X = Integer.parseInt(s[1]);
		int count = 0;
		board = new int[Y][X];
		list = new ArrayList<Cctv>();
		wall = new ArrayList<Cctv>();
		only5 = new ArrayList<Cctv>();
		
		for (int y = 0; y < Y; ++y) {
			s = br.readLine().split(" ");
			for (int x = 0; x < X; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				if (board[y][x] > 0 && board[y][x] < 6) {					
					if (board[y][x] == 5) { //5를 따로관리
						only5.add(new Cctv(y,x,board[y][x]));
						continue;
					}						
					list.add(new Cctv(y, x, board[y][x]));
					count++;
				} else if (board[y][x] == 6) {
					wall.add(new Cctv(y, x, -1)); // 배열 리셋시 위치값떄문에.

				}
			}

		}
		reset();
		dfs(0, count); //dfs 솔루션..
		System.out.println(min);

	}

	static int min = Integer.MAX_VALUE;
	static ArrayList<Integer> perm = new ArrayList<>();

	private static void dfs(int depth, int count) {
		if (depth == count) { //순열 완성.
			Search();
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
					left(i, list);
				} else if (list.get(i).num == 2) {
					left(i, list);
					right(i, list);
				} else if (list.get(i).num == 3) {
					up(i, list);
					right(i, list);
				} else if (list.get(i).num == 4) {
					left(i, list);
					right(i, list);
					up(i, list);
				}
				break;
			case 2:
				if (list.get(i).num == 1) {
					right(i, list);
				} else if (list.get(i).num == 2) {
					left(i, list);
					right(i, list);
				} else if (list.get(i).num == 3) {
					up(i, list);
					left(i, list);
				} else if (list.get(i).num == 4) {
					up(i, list);
					down(i, list);
					right(i, list);
				}
				break;
			case 3:
				if (list.get(i).num == 1) {
					up(i, list);
				} else if (list.get(i).num == 2) {
					up(i, list);
					down(i, list);
				} else if (list.get(i).num == 3) {
					down(i, list);
					right(i, list);
				} else if (list.get(i).num == 4) {
					down(i, list);
					right(i, list);
					left(i, list);
				}
				break;
			case 4:
				if (list.get(i).num == 1) {
					down(i, list);
				} else if (list.get(i).num == 2) {
					up(i, list);
					down(i, list);
				} else if (list.get(i).num == 3) {
					down(i, list);
					left(i, list);
				} else if (list.get(i).num == 4) {
					down(i, list);
					left(i, list);
					up(i, list);
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

	private static void up(int i, ArrayList<Cctv> list) {
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

	private static void down(int i, ArrayList<Cctv> list) {
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

	private static void left(int i, ArrayList<Cctv> list) {
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

	private static void right(int i, ArrayList<Cctv> list) {
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
		}
		for(int i = 0; i<only5.size(); ++i) {
			Cctv curr = only5.get(i);
			board[curr.y][curr.x] = curr.num;
			
			left(i, only5);
			right(i, only5);
			up(i, only5);
			down(i, only5);
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
