import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int dist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dist = new int[100002];
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new LinkedList<>();
		dist[N] = 0;
		q.offer(N);
		int answer=0;
		int count=0;
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr==K) {
				answer = dist[curr];
				count++;
			}
			if(curr+1<=100001 && (dist[curr+1]==-1 || (dist[curr+1] == dist[curr]+1))) {
				dist[curr+1] = dist[curr]+1;
				q.offer(curr+1);
			}
			if(curr-1>=0 && (dist[curr-1]==-1 || (dist[curr-1] == dist[curr]+1))) {
				dist[curr-1] = dist[curr]+1;
				q.offer(curr-1);
			}
			if(curr*2<=100001 && (dist[curr*2]==-1 || (dist[curr*2] == dist[curr]+1))) {
				dist[curr*2] = dist[curr]+1;
				q.offer(curr*2);
			}
			
		}
		System.out.println(answer);
		System.out.println(count);
		
	}
}
