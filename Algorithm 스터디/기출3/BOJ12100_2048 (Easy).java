import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
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
				for(int y=0; y<N; ++y) {
					for(int x=0; x<N; ++x) {
						max = Math.max(max, boardCopy[y][x]);
					}
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
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				boardCopy[i][j] = board[i][j];
			}
		}
	}
	private static void boardMove(int num) {
		switch(num) {
		case 0: //위로
			Queue<Integer> q = new LinkedList<>();			
			for(int x=0; x<N; ++x) {
				for(int y=0; y<N; ++y) {
					if(boardCopy[y][x]!=0) {
						q.offer(boardCopy[y][x]);
						
					}			
					boardCopy[y][x]=0;
				}
				int idx = 0;
				
				while(!q.isEmpty()) {
					int pollValue = q.poll();
					if(boardCopy[idx][x] == 0) {
						boardCopy[idx][x] = pollValue;
					}
					else if(pollValue == boardCopy[idx][x]) {
						boardCopy[idx][x] += pollValue;
						idx++;
					}
					else {
						idx++;
						boardCopy[idx][x] = pollValue;						
					}
				}
			}
			
			break;
		case 1: //아래로
			q = new LinkedList<>();
			
			for(int x=0; x<N; ++x) {
				for(int y=N-1; y>=0; --y) {
					if(boardCopy[y][x]!=0) {
						q.offer(boardCopy[y][x]);
						
					}			
					boardCopy[y][x]=0;
				}
				int idx = N-1;
				while(!q.isEmpty()) {
					int pollValue = q.poll();
					if(boardCopy[idx][x] == 0) {
						boardCopy[idx][x] = pollValue;
					}
					else if(pollValue == boardCopy[idx][x]) {
						boardCopy[idx][x] += pollValue;
						idx--;
					}
					else {
						idx--;
						boardCopy[idx][x] = pollValue;						
					}
				}
			}
			break;
		case 2: //왼쪽
			q = new LinkedList<>();
			
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					if(boardCopy[y][x]!=0) {
						q.offer(boardCopy[y][x]);
						
					}
					boardCopy[y][x]=0;
				}
				int idx = 0;
				while(!q.isEmpty()) {
					int pollValue = q.poll();
					if(boardCopy[y][idx] == 0) {
						boardCopy[y][idx] = pollValue;
					}
					else if(pollValue == boardCopy[y][idx]) {
						boardCopy[y][idx] += pollValue;
						idx++;
					}
					else {
						idx++;
						boardCopy[y][idx] = pollValue;						
					}
				}
			}
			break;
		case 3: //오른쪽
			q = new LinkedList<>();
			
			for(int y=0; y<N; ++y) {
				for(int x=N-1; x>=0; --x) {
					if(boardCopy[y][x]!=0) {
						q.offer(boardCopy[y][x]);
						
					}
					boardCopy[y][x]=0;
				}
				int idx = N-1;
				while(!q.isEmpty()) {
					int pollValue = q.poll();
					if(boardCopy[y][idx] == 0) {
						boardCopy[y][idx] = pollValue;
					}
					else if(pollValue == boardCopy[y][idx]) {
						boardCopy[y][idx] += pollValue;
						idx--;
					}
					else {
						idx--;
						boardCopy[y][idx] = pollValue;						
					}
				}
			}
			break;
		}
	}
}
