import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ12100 {
	static int N;
	static int[][] board;
	static int[][] boardCopy;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int y=0; y<N; ++y) {
			String[] s = br.readLine().split(" ");
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		dfs(0);//중복순열
		System.out.println(max);
	}
	static ArrayList<Integer> moving = new ArrayList<>();
	private static void dfs(int depth) {
		if(depth == 5) {
			boardCopy = new int[N][N];
			copy();
			for(int i=0; i<moving.size(); ++i) {
				boardMove(moving.get(i));
			}
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					max = Math.max(max, boardCopy[i][j]);
				}
			}
			return;
		}
		for(int i=0; i<4; ++i) {
			moving.add(i);
			dfs(depth+1);
			moving.remove(moving.size()-1);
		}
	}
	private static void copy() {
		boardCopy = board.clone();
	}
	private static void boardMove(int num) {
		switch(num) {
		case 0: //위로
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					int ny = y-1;
					if(ny < 0 || (boardCopy[ny][x] > 0 && boardCopy[ny][x] != boardCopy[y][x])) continue;
					if(boardCopy[y][x] == boardCopy[ny][x] || board[ny][x]==0) {
						boardCopy[ny][x] += boardCopy[y][x];
						boardCopy[y][x] = 0;
					}		
				}
			}
			break;
		case 1: //아래로
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					int ny = y+1;
					if(ny >= N || (boardCopy[ny][x] > 0 && boardCopy[ny][x] != boardCopy[y][x])) continue;
					if(boardCopy[y][x] == boardCopy[ny][x] || board[ny][x]==0) {
						boardCopy[ny][x] += boardCopy[y][x];
						boardCopy[y][x] = 0;
					}		
				}
			}
			break;
		case 2: //왼쪽
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					int nx = x-1;
					if(nx < 0 || (boardCopy[y][nx] > 0 && boardCopy[y][nx] != boardCopy[y][x])) continue;
					if(boardCopy[y][x] == boardCopy[y][nx] || board[y][nx]==0) {
						boardCopy[y][nx] += boardCopy[y][x];
						boardCopy[y][x] = 0;
					}		
				}
			}
			break;
		case 3: //오른쪽
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					int nx = x+1;
					if(nx >= N || (boardCopy[y][nx] > 0 && boardCopy[y][nx] != boardCopy[y][x])) continue;
					if(boardCopy[y][x] == boardCopy[y][nx] || board[y][nx]==0) {
						boardCopy[y][nx] += boardCopy[y][x];
						boardCopy[y][x] = 0;
					}		
				}
			}
			break;
		}
	}
}
