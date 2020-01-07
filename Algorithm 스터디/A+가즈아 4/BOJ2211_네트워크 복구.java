import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static int dist[];
	static int[][] graph;
	static int[] result;
	static PriorityQueue<Pos> pq = new PriorityQueue<>();
	
	static final int MAX = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		graph = new int[N+1][N+1];
		result = new int[N+1];
		
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
			graph[b][a] = c;
		}
		
		for(int i=1; i<dist.length; ++i) {
			dist[i] = MAX;
		}
		
		
		dist[1] = 0; 
		dijk(new Pos(1, dist[1]));
		
		System.out.println(N-1);
		
		for(int i=2; i<=N; ++i) {
			System.out.println(i + " " + result[i]);
		}
	}
	
	private static void dijk(Pos pos) {
		pq.offer(pos);
		
		while(!pq.isEmpty()) {
			Pos curr = pq.poll();
			
			if(dist[curr.v] < curr.cost) continue;
				 
			for(int i=1; i<=N; ++i) {
				if(graph[curr.v][i]==0) continue;
					int nv = i;
					int ncost = graph[curr.v][i];
					
					if(dist[nv] > ncost+dist[curr.v]) {
						
						dist[nv] = ncost + dist[curr.v];
						pq.offer(new Pos( nv, ncost ));
						result[nv] = curr.v;
						
					}
				}
			}
		}
	

	static class Pos implements Comparable<Pos>{
		int v;
		int cost;
		
		public Pos(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost-o.cost;
		}
	}
}
