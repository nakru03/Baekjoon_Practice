import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static int[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		dp = new int[N+1][1<<N+1][10]; //아티스트 넘버, 상태, 비용
		for(int y=0; y<N; ++y) {
			String[] s = br.readLine().split("");
			for(int x=0; x<N; ++x) {
				graph[y][x] = Integer.parseInt(s[x]);
			}
		}	
		for(int i=0; i<N+1; ++i) {
			for(int j=0; j<1<<N+1; ++j) {
				for(int k=0; k<10; ++k) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(dfs(0,1,0,1));
	}
	private static int dfs(int here, int state, int c, int depth) {
		
		if(dp[here][state][c] != -1)
			return dp[here][state][c];
		
		dp[here][state][c] = depth;
		
		for(int there=0; there<N; ++there) {
			if((state & (1<< there)) != 0 || graph[here][there] < c ) continue;
			dp[here][state][c] = Math.max(dp[here][state][c], dfs(there, (state | (1<<there)), graph[here][there], depth+1));
		}
		
		return dp[here][state][c];
	}
}
	