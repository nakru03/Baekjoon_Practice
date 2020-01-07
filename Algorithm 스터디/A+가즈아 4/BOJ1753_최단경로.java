import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int E;
	
	static int start;
	
	static int[] dist;
	static ArrayList<Edge>[] graph;
	static final int INF = 987654321;
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		graph = new ArrayList[V+1];

		for(int i=1; i<=V; ++i) {
			dist[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		int here;
		int there;
		int weight;
		
		for(int i=0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			here = Integer.parseInt(st.nextToken());
			there = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			graph[here].add(new Edge(there, weight));
		}
		
		dist[start] = 0;
		pq.offer(new Edge(start, dist[start]));
		dijk(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<dist.length; ++i) {
			if(dist[i]==INF) sb.append("INF"+"\n");
			else sb.append(dist[i]+"\n");
		}
		System.out.println(sb);
	}

	private static void dijk(int start) {
		while(!pq.isEmpty()) {
			
			Edge curr = pq.poll();
			
			if(curr.weight > dist[curr.here]) continue; //그래프를 링크드리스트로 그리면 중복처리 여기서 해야됨.
			
			for(Edge e : graph[curr.here]) {
				int there = e.here;
				if(dist[there]> curr.weight + e.weight) {
					dist[there] = curr.weight + e.weight;
					pq.offer(new Edge(there, dist[there]));
				}
			}
			
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int here;
		int weight;
		
		public Edge(int here, int weight) {
			super();
			this.here = here;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight==o.weight ? this.here-o.here : this.weight-o.weight;
		}
		
	}
}
