import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int Y;
	static int X;
	static int N;
	
	static char[][] board;
	static char[][] copyBoard;
	
	static final int[] dy = {0,-1,0,1};
	static final int[] dx = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("\\s");
		
		Y = Integer.parseInt(s[0]);
		X = Integer.parseInt(s[1]);
		N = Integer.parseInt(s[2]);
		
		board = new char[Y][X];
		copyBoard = new char[Y][X];
		
		for(int y=0; y<Y; ++y) {
			board[y] = br.readLine().toCharArray();
		}
		
		//print();
		int time = 1;
		while(time != N) {
			if(time%2==1) {
				setBomb();
				//print(copyBoard);
			}
			else{
				kaboom();
				//print(board);
			}
			time ++;
		}
		
		if(N%2==0) {
			print(copyBoard);
		}else
			print(board);
		
	}
	
	private static void kaboom() {
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x]=='O') {
					copyBoard[y][x] ='.';
					for(int dir=0; dir<4; ++dir) {
						int ny = y+dy[dir];
						int nx = x+dx[dir];
						if(ny<0 || nx <0 || ny>=Y || nx>= X) continue;
						copyBoard[ny][nx] = '.';
					}
				}
			}
		}
		copy(board, copyBoard);
	}

	private static void setBomb() {
		copy(copyBoard, board);
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(copyBoard[y][x]=='.') {
					copyBoard[y][x] = 'O';
				}
			}
		}
	}

	static void print(char[][] board1) {
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				System.out.print(board1[y][x]);
			}
			System.out.println();
		}
	}
	
	static void copy(char[][] board1, char[][] board2) {
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				board1[y][x]=board2[y][x];
			}
		}
	}
}