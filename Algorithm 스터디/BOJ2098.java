import java.util.Scanner;

/*
 * 
 * 외판원순회
 * 단방향 가중치 그래프
 * 가장 적은 비용을 구하라.
 * dfs?
 * 햄버거 문제랑 비슷.
 */
public class BJO2098 {
	static int[][] costBoard;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		costBoard = new int[n][n];
		visited = new boolean[n];
		for(int y=0; y<n; ++y) {
			for(int x=0; x<n; ++x) {
				costBoard[y][x] = sc.nextInt();
			}
		}
		int lowest = tsp(n,0 ,0);
	}
	private static int  tsp(int start, int y, int depth, int sum) {
		boolean flag = true;
		int sum =0;
		for(int i=0; i<visited.length; ++i) {
			if(!visited[i]) flag=false;
		}
		
		if(flag) {//마지막 자기자신으로 돌아와야됨 !
			System.out.println(cost+costBoard[depth][i]);
			return cost;
		}
		
		for(int i=0; i<visited.length; ++i) {
			if(visited[i]) continue;
			visited[i] = true;			
			tsp(n, depth+1, cost);		
			visited[i] = false;
		}
		return n;
		
	}

}
