import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; ++i) {
			tokenizer = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(tokenizer.nextToken());
			int x = Integer.parseInt(tokenizer.nextToken());			
			graph[y][x] = graph[x][y] = 1;			
		}
		
		//입력...
		for(int i=1; i<=n; ++i) {
			bfs(i, graph);
		}		
		System.out.println(cnt);
	}
	static int cnt;
	private static void bfs(int start, int[][] graph) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next=1; next < graph.length; ++next) {
				if(graph[curr][next]!=1)continue;
				if(visited[next]) continue;
				q.offer(next);
				visited[next] = true;
				cnt++;
			}
			
		}
		
	}
}
