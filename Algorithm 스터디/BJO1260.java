package solve;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 인접정점 찾는 그래프 순회는 링크드 리스트로 푸는게 메모리초과가 덜난다.
 */
public class BJO1260 {
	static int[][] graph;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line1);
		N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int V = Integer.parseInt(tokenizer.nextToken());
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=M; ++i) {
			StringTokenizer tokenizer2 = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(tokenizer2.nextToken());
			int x = Integer.parseInt(tokenizer2.nextToken());
			graph[y][x] = graph[x][y] = 1;
		}
		
		dfs(V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(V);
		
	}
	private static void dfs(int V) {
		System.out.print(V+" ");
		for(int nextV = 1; nextV<= N; ++nextV) {
			visited[V] = true;
			if(graph[V][nextV]!=1 || visited[nextV]) continue;
			dfs(nextV);
		}
		
	}
	private static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		visited[V] = true;		
		q.offer(V);
		while(!q.isEmpty()) {
			int currV = q.poll();
			System.out.print(currV+" ");

			for(int nextV=1; nextV<=N; ++nextV) {
				if(graph[currV][nextV]!=1 || visited[nextV]) continue;
				q.offer(nextV);
				visited[nextV]=true;
			}
		}
	}
	
}

