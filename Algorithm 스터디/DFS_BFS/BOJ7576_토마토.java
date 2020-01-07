import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1, 0,-1};
		
		int m = sc.nextInt();
        int n = sc.nextInt();
        
		int[][] board = new int[n][m];
		int[][] day = new int[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int y=0; y<n; ++y) {
			for(int x=0; x<m; ++x) {
				board[y][x] = sc.nextInt();		
				if(board[y][x] == 1) {
					q.offer(new Pair(y,x));
				}
			}
		}
		while(!q.isEmpty()) {
			Pair curr = q.remove();
			for(int dir=0; dir<dx.length; ++dir) {
				int ny = curr.first + dy[dir];
				int nx = curr.second + dx[dir];
				
				if(ny < 0 || nx < 0 || ny>=n || nx>=m) continue;
				if(board[ny][nx] !=0) continue; //1일거나 -1일이떄
				board[ny][nx] = 1;
				day[ny][nx] = day[curr.first][curr.second]+1;
				
				q.offer(new Pair(ny, nx));
			}
			
		}
		int max = Integer.MIN_VALUE;
		for(int y=0; y<n; ++y) {
			for(int x=0; x<m; ++x) {
				
				if(board[y][x]==0) {
					System.out.println(-1);
					return;
				}
				else {
					if(max<day[y][x])
						max = day[y][x];
				}
			}
			
		}
		System.out.println(max);
	}
	
	

}
class Pair{
	int first;
	int second;
	Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
}