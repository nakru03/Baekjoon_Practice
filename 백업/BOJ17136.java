import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ17136 {
	static int[][] board = new int[10][10];
	static int[] paper = new int[5];
	static int answer;
	static ArrayList<Pair> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(paper, 5);
		
		for(int y=0; y<10; ++y) {
			String[] s = br.readLine().split(" ");
			for(int x=0; x<10; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				if(board[y][x]==1) {
					list.add(new Pair(y,x));
				}
			}
		}
		
		dfs(0,0);
		
		
	}
	static int cnt;
	static int min = Integer.MAX_VALUE;
	
	private static void dfs(int idx, int depth) {
		if(depth == list.size()) {
			min = Math.min(min, cnt);
			return;
		}
		for(int)
		
	}
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
