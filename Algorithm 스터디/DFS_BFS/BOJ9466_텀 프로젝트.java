import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] board;
	static int[] visited;
	static int[] cycle;
	static int n;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; ++t) {
			n = Integer.parseInt(br.readLine());
			
			board = new int[n+1];
			visited = new int[n+1];
			cycle = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=n; ++i) {
				board[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n; ++i) {
				if(visited[i]!=0) continue;
				int cnt = dfs(i,i,1);
				answer += cnt;
			}
			System.out.println(n-answer);
			answer = 0;
		}
	}

	private static int dfs(int depth, int start, int cnt) {
		
		if(visited[depth]!=0) {
			
			if(cycle[depth]!=start) {
				return 0;
			}
			
			return cnt - visited[depth];
		}
		
		cycle[depth] = start;
		visited[depth] = cnt;
		return dfs(board[depth], start, cnt+1);
	}
}
