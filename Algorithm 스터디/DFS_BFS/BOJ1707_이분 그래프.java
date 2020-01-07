import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] color;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int v = Integer.parseInt(st.nextToken());
			graph = new ArrayList[v+1];
			for(int i=1; i<v+1; ++i) {
				graph[i] = new ArrayList<>();
			}
			color = new int[v+1];
			
			int e = Integer.parseInt(st.nextToken());
			for(int i=0; i<e; ++i) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				graph[y].add(x);
				graph[x].add(y);
			}

			
			boolean flag = true;
			for(int i=1; i<v+1; ++i) {
				if(color[i]!=0 || flag==false) continue; //이거 처리해줘야함. 빈큐일떄
				flag = BipartiteCheck(i);
				
			}
			
			System.out.println(flag ? "YES" : "NO");
		}
	}
	private static boolean BipartiteCheck(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		color[start] = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i = 0; i <graph[curr].size(); ++i) {
				int next = graph[curr].get(i);
				if(color[curr] + color[next] != 0 && color[next]!=0) return false;
				if(color[next]==0) {
					color[next] = color[curr] * -1;
					q.offer(next);
				}	
				
			}
		}
		return true;
		
	}
	

}
