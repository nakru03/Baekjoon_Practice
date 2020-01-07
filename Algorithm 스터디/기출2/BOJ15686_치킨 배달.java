import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited2;
	
	static ArrayList<Pos> house = new ArrayList<>();
	static ArrayList<Pos> chicken = new ArrayList<>();
	static ArrayList<Pos> pickCh = new ArrayList<>();
	
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int tmp;
		
		for(int y=0; y<N; ++y) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0; x<N; ++x) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp==1)
					house.add(new Pos(y,x));
				if(tmp==2) {
					chicken.add(new Pos(y,x));
				}
			}
		}
		visited2 = new boolean[chicken.size()];
		for(int i=1; i<=M; ++i) {
			dfs(0, i, 0);
		}
		System.out.println(answer);
	}
	private static void dfs(int depth, int pick, int num) {
		int dist;
		if(depth==pick) {
			dist = 0;
			
			for(int i=0; i<house.size(); ++i) {
				dist += calc(house.get(i));
			}
			answer = Math.min(answer, dist);
			return;
		}
		
		for(int i=num; i<chicken.size(); ++i) {
			if(visited2[i]) continue;
			visited2[i] = true;
			pickCh.add(chicken.get(i));
			dfs(depth+1, pick, i+1);
			pickCh.remove(pickCh.size()-1);
			visited2[i] = false;
			
		}
	}
	
	private static int calc(Pos pos) {
		int dist = Integer.MAX_VALUE;
		for(int i=0; i<pickCh.size(); ++i) {
			dist = Math.min(dist, Math.abs(pickCh.get(i).y-pos.y) + Math.abs(pickCh.get(i).x-pos.x));
		}
		return dist;
	}

	static class Pos{
		int y;
		int x;
		
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
