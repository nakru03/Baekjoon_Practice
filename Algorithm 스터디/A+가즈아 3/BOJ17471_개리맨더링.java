import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class BOJ17471 {
	static int N;
	static ArrayList<Integer> area = new ArrayList<>();
	static int[][] graph;
	static boolean[] visited;
	static int section;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split("\\s");
		
		graph = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<s.length; ++i) {
			area.add(Integer.parseInt(s[i]));
			String[] s2 = br.readLine().split("\\s");
			for(int j=1; j<=Integer.parseInt(s2[0]); ++j) {
				graph[i][Integer.parseInt(s2[j])-1] = 1;
				graph[Integer.parseInt(s2[j])-1][i] = 1;
			}
		}
		
		//조합으로 2팀을 뽑고..
		for(int i=1; i<N/2+1; ++i) {
			combi(0, 0,i);
		}
		System.out.println(answer== Integer.MAX_VALUE ? -1 : answer);
		
	}
	static ArrayList<Integer> team1 = new ArrayList<>();
	static ArrayList<Integer> team2 = new ArrayList<>();
	
	private static void combi(int idx, int depth, int M) {
		if(depth == M) {
			for(int i=0; i<N; ++i) {
				if(visited[i]) {
					team1.add(i);
				}else {
					team2.add(i);
				}			
					
			}
			boolean[] team1visited = new boolean[team1.size()];
			boolean[] team2visited = new boolean[team2.size()];
			int section = 0;
			for(int i=0; i<team1.size(); ++i) {
				if(team1visited[i]) continue;
				section += dfs(team1,i,team1visited);
			}
			for(int i=0; i<team2.size(); ++i) {
				if(team2visited[i]) continue;
				section += dfs(team2,i,team2visited);
			}
			
			
			if(section==2) {
				int sum = 0;
				int sum1 = 0;
				for(int i=0; i<team1.size(); ++i) {
					sum += area.get(team1.get(i));
				}
				for(int i=0; i<team2.size(); ++i) {
					sum1 += area.get(team2.get(i));
				}
				answer = Math.min(answer, Math.abs(sum-sum1));
			}

			team1.clear();
			team2.clear();
			return;
		}
		for(int i=idx; i<N; ++i) {
			if(visited[i]) continue;
			visited[i] = true;
			combi(i, depth+1, M);
			visited[i] = false;
		}
	}
	private static int dfs(ArrayList<Integer> team, int start, boolean[] teamvisited) {
		int cnt = 0;
		Stack<Integer> s = new Stack<>();
		s.push(start);
		teamvisited[start] = true;
				
		while(!s.isEmpty()) {
			int curr = s.pop();
			
			for(int next=1; next<team.size(); ++next) {
				if(teamvisited[next]) continue;
				if(graph[team.get(curr)][team.get(next)]==1) {
					s.push(next);
					teamvisited[next] = true;
				}
			}
		}
		cnt++;
		return cnt;
	}
	
}
