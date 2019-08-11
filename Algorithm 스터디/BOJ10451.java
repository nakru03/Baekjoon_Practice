import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 순열 그래프이므로 그래프가 한 개 이상 존재하나 모든 정점이 서로 연결된 사이클.
 * 연결요소가 사이클의 개수와 동일.
 */
public class BOJ10451 {
	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			int n = Integer.parseInt(br.readLine());			
			graph = new int[n+1][n+1];
			visited = new boolean[n+1];
			int cnt = 0;
			StringTokenizer tokenizer = null;
			tokenizer = new StringTokenizer(br.readLine());
			for(int y =1; y<=n; ++y) {				
				int x = Integer.parseInt(tokenizer.nextToken());
				graph[y][x] = 1;				
			}
			for(int i=1; i<graph.length; ++i) {
				if(visited[i]) continue;
				dfs(i);
				cnt++;
			}
			System.out.println(cnt);
		}
		
		
	}
	private static void dfs(int start) {
		visited[start] = true;
		for(int next=1; next<graph.length; ++next) {
			if(graph[start][next]!=1) continue;
			if(visited[next]) continue;
			dfs(next);
		}
		
	}
}
