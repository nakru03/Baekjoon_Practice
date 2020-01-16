import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17136 {
	static int N, M;
	static int[][] board;
	
	static int answer = Integer.MAX_VALUE;
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static int[] paper = new int[5+1];
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		board = new int[10][10];
		
		for(int y=0; y<10; ++y) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0; x<10; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
				if(board[y][x]==1) {
					count++;
				}
			}
		}
		
		for(int i=1; i<=5; ++i) {
			paper[i] = 5;
		}
		dfs(0,0);//기저용 sum
		System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
		
	}
	
	private static void dfs(int sum, int psum) { //좌표, 1의개수 sum 종이 갯수 psum
		if(psum>=answer) return;
		if(sum==count) {
			answer = Math.min(answer, psum);
			return;
		}
		
		int curry=0, currx=0;
		
		out :for(int y=0; y<10; ++y) {
			for(int x=0; x<10; ++x) {
				if(board[y][x]==1) {
					curry=y;
					currx=x;
					break out;
				}
			}
		}
		
		for(int i=5; i>0; --i) {
			
			if(paper[i]<=0) continue; //이 종이 못씀
			if(curry+i-1>=10 || currx+i-1>=10) continue; //아웃오브바운드
			if(check(curry, currx, i)) continue; //0체크
			for(int y=curry; y<curry+i; ++y) {
				for(int x=currx; x<currx+i; ++x) {
					if(board[y][x]==1) sum++;
					board[y][x] = 0;
				}
			}
			paper[i]--;
			dfs(sum, psum+1);
			for(int y=curry; y<curry+i; ++y) {
				for(int x=currx; x<currx+i; ++x) {
					if(board[y][x]==0) sum--;
					board[y][x] = 1;
				}
			}
			paper[i]++;
		}
	}

	private static boolean check(int curry, int currx, int i) {
		for(int y=curry; y<curry+i; ++y) {
			for(int x=currx; x<currx+i; ++x) {
				if(board[y][x]==0) return true;
			}
		}
		return false;
	}
}
