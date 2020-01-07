import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int L = Integer.parseInt(tmp[1]);
		board = new int[N][N];
		for(int y=0; y<N; ++y) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int result=0;
		
		int[][] board2 = new int[N][N];
		for(int y=0; y<N; ++y) {
			for(int x=0; x<N; ++x) {
				board2[y][x] = board[x][y];
			}
		}
		
		for(int y=0; y<N; ++y) {
			result += rowCheck(board[y], L); //가로첵
		
			result += rowCheck(board2[y], L); //세로첵

		}
		System.out.println(result);
		
		
	}
	
	static int rowCheck(int[] boardRow, int L) {
		boolean[] check = new boolean[boardRow.length];
		for(int x=0; x<boardRow.length-1; ++x) {
			if(Math.abs(boardRow[x]-boardRow[x+1])==1) {
				if(boardRow[x]<boardRow[x+1]) { //올라가는 경사
					for(int i=0; i<L; ++i) {
						if(x-i<0 || check[x-i] || boardRow[x]!=boardRow[x-i]) { 
							return 0;
						}
						
						check[x-i] = true;
					}
				}else {
					for(int i=1; i<=L; ++i) {
						if(x+i>=boardRow.length || check[x+i] || boardRow[x+1]!=boardRow[x+i]) {
							return 0;
						}
						check[x+i] = true;
					}
				}
			}else if(boardRow[x]-boardRow[x+1]==0) {
				continue;
			}else
				return 0;
		}
		return 1;
	}

}
