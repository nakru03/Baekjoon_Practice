import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int M;
	static int start;
	static int dst;
	static int[] dist;
	static int[][] board;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
		dist = new int[N];
		board = new int[N][N];
		
		for(int i=0; i<N; ++i) {
			dist[i] = INF;
			for(int j=0; j<N; ++j) {
				board[i][j] = INF;
			}
		}
		
		int here;
		int there;
		int weight;
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			here = Integer.parseInt(st.nextToken())-1;
			there = Integer.parseInt(st.nextToken())-1;
			weight = Integer.parseInt(st.nextToken());
			
			if(board[here][there]>weight) {
				board[here][there] = weight;
			}//같은 경로에 다른 가중치가 존재한다!
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		dst = Integer.parseInt(st.nextToken())-1;
		dijkstra();
		System.out.println(dist[dst]);
		
		
	}

		private static void dijkstra() {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.offer(start);
			board[start][start] = 0;
			dist[start] = 0;
			
			while(!pq.isEmpty()) {
				int curr = pq.poll();
				for(int i=0; i<N; ++i) {
					if(dist[i]>board[curr][i]+dist[curr]) {
						dist[i] = board[curr][i]+dist[curr];
						pq.offer(i);
					}
				}
			}
		}
		
	
}
