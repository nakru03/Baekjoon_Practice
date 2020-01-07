import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static int N, sharkX, sharkY, sharkSize, countOfFish, cnt;
	public static int[][] map;
	public static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sharkX, sharkY});
		int[][] v = new int[N][N];
		int fX = N+1, fY = N+1;
		v[sharkX][sharkY] = 1;
		boolean flag = false;
		while(!q.isEmpty()) {
			int nnn = q.size();
			for(int k=0; k<nnn; k++) {
				int[] curr = q.poll();
				for(int i=0; i<dir.length; i++) {
					int xx = curr[0]+dir[i][0];
					int yy = curr[1]+dir[i][1];
					if(xx>=0 && xx<N && yy>=0 && yy<N && v[xx][yy]==0 && map[xx][yy]<=sharkSize) {
						v[xx][yy]=v[curr[0]][curr[1]]+1;
						// 먹을 수 있는 물고기를 찾음
						if(map[xx][yy]<sharkSize && map[xx][yy]!=0) {
							if(fX>xx) {
								fX=xx;
								fY=yy;
							} else if(fX==xx && fY>yy) {
								fX=xx;
								fY=yy;
							}
							flag = true;
						}
						q.offer(new int[] {xx, yy});
					}
				}
			}
			if(flag) {
				map[fX][fY] = 0;
				++countOfFish;
				if(countOfFish == sharkSize) {
					++sharkSize;
					countOfFish=0;
				}
				sharkX = fX;
				sharkY = fY;
				cnt = v[fX][fY]-1;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j*2)-'0';
				if(map[i][j]==9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
		sharkSize = 2;
		countOfFish = 0;
		int count = 0;
		while(bfs()) {
			count+=cnt;
		}
		
		System.out.println(count);
		br.close();
	}
}