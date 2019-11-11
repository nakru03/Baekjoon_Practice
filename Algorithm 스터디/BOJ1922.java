import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1922 {
	static int N;
	static int M;
	static ArrayList<Edge> list = new ArrayList<>();
	static int[] p;
	static int unionCount;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		p= new int[N+1];
		
		for (int i = 0; i < M; ++i) {
			String[] s = br.readLine().split("\\s");
			int v1 = Integer.parseInt(s[0]);
			int v2 = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);

			list.add(new Edge(v1, v2, cost));
		}
		
		Collections.sort(list);
		make();
		
		for(int i=0; i<list.size(); ++i) {
			if(unionCount == N-1) break;
			union(list.get(i));
		}
		System.out.println(answer);

	}

	private static void union(Edge edge) {
		int v1 = find(edge.v1);
		int v2 = find(edge.v2);
		
		if(v1!=v2) {
			p[v2] = v1;
			unionCount++;
			answer += edge.cost;
		}
	}

	private static int find(int v1) {
		if(p[v1] == v1) return v1;
		return p[v1] = find(p[v1]);
	}

	private static void make() {
		for(int i=1; i<N+1; ++i) {
			p[i] = i;
		}
	}

	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int cost;

		public Edge(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost == o.cost ? this.v1 - o.v1 : this.cost - o.cost;
		}

	}

}
