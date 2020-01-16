import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[1000002];
		Arrays.fill(visited, 987654321);
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		visited[N] = 0;
		int next = 0;
		int answer = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr==K) {
				answer = visited[curr];
				break;
			}
			if(curr+1<=100000) {
				if(visited[curr+1]>visited[curr]+1) {
					visited[curr+1] = visited[curr]+1;
					q.offer(curr+1);
				}
			}
			if(curr-1>=0) {
				if(visited[curr-1]>visited[curr]+1) {
					visited[curr-1] = visited[curr]+1;
					q.offer(curr-1);
				}
			}
			if(curr*2<=100000) {
				if(visited[curr*2]>visited[curr]+1) {
					visited[curr*2] = visited[curr]+1;
					q.offer(curr*2);
				}
			}
		}
		System.out.println(answer);
	}
}
