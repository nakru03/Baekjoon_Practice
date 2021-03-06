import java.util.*;

public class BJO7569 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx= {1,-1,0,0,0,0};
		int[] dy= {0,0,1,-1,0,0};
		int[] dz= {0,0,0,0,1,-1};
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		int[][][] boxes = new int[h][n][m];
		int[][][] day = new int[h][n][m];

		Queue<Triple> q = new LinkedList<Triple>();
		
		for(int z=0; z<h; ++z) {
			for(int y=0; y<n; ++y) {
				for(int x=0; x<m; ++x) {
					boxes[z][y][x] = sc.nextInt();
					if(boxes[z][y][x]==1)
						q.offer(new Triple(z,y,x));
				}
			}
		}
		while(!q.isEmpty()) {
			Triple curr = q.poll();
			for(int dir=0; dir<6; ++dir ) {
				int nz = curr.first+dz[dir];
				int ny = curr.second+dy[dir];
				int nx = curr.third+dx[dir];
				if(nz<0 || ny <0 || nx < 0 || nz>=h || ny >= n || nx>= m) continue;
				if(boxes[nz][ny][nx]!=0) continue;
				boxes[nz][ny][nx] = 1;
				day[nz][ny][nx] = day[curr.first][curr.second][curr.third] +1;
				q.offer(new Triple(nz,ny,nx));
			}
		}

//		for(int z=0; z<h; ++z) {
//			for(int y=0; y<n; ++y) {
//				for(int x=0; x<m; ++x) {
//					System.out.println(day[z][y][x]);					
//						
//					
//				}
//			}
//		}
		int result = Integer.MIN_VALUE;
		for(int z=0; z<h; ++z) {
			for(int y=0; y<n; ++y) {
				for(int x=0; x<m; ++x) {
					if(boxes[z][y][x]==0){
						System.out.println(-1);
						return;
					}
					if(result<day[z][y][x])
						result=day[z][y][x];
						
					
				}
			}
		}
		System.out.println(result);
	}
	

}
class Triple {
	int first;
	int second;
	int third;
	
	Triple(int first, int second,int third){
		this.first = first;
		this.second =second;
		this.third = third;
	}
	
}