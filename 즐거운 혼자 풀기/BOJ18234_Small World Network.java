import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18234 {
	
	static int V, E;
	static int[][] graph;
	static boolean visited[];
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V][V];
		
		int v1, v2;
		for(int i=0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken())-1;
			v2 = Integer.parseInt(st.nextToken())-1;
			
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		
		for(int i=0; i<V; ++i) {
			visited = new boolean[V];
			
			if(bfs(i)>6) {
				System.out.println("Big World!");
				System.exit(0);
			}
			for(int j=0; j<visited.length; ++j) {
				if(!visited[j]) {
					System.out.println("Big World!");
					System.exit(0);
				}
			}
		}
		System.out.println("Small World!");
		
	}

	private static int bfs(int start) {
		
		visited[start] = true;
		q.offer(start);
		int level = 0;
		int qs, curr;
		while(!q.isEmpty()) {
			qs = q.size();
			for(int i=0; i<qs; ++i) {
				curr = q.poll();
				
				for(int next=0; next<V; next++) {
					if(visited[next]) continue;
					if(graph[curr][next]==1) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			level++;
		}
		return level-1;
	}
}
