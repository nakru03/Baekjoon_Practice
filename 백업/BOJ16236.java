import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N*N칸 공간 물고기 M 아기상어 1마리
 * 아기상어 물고기 모두 크기를 가짐.
 * 아기상어 초기 2, 1초에 상하좌우로 인접한칸이동
 * 아기상어는 자신크기보다 큰 물고기 지나갈수 없음
 * 작은 물고기칸은 먹고 지나감.
 * 
 *  조건
 *  더이상 먹을 수 있는 물고기가 없다면 아기 상어는 엄마상어에게 도움
 *  먹을수있는 물고기가 1마리라면 그물고기 먹으로간다
 *  먹을수있는 물고기가 1마리 보다 많으면 가장가까운 물고기
 *  	거리는 서로 칸의 거리의  최소값
 *  	거리가 가까운 물고기 많으면 가장 위.. 그마저도 여러마리면 가장 왼쪽.
 *  	
 *  아기 상어의 이동은 1초 걸림. 물고기를 먹는데 걸리는 시간X 
 *  자신의 크기와 같은 수의 물고기를 먹으면 크기가 1증가.(ex 크기 2일때 2마리먹으면 3으로 증가)
 *  엄마 호출하면 탐색끝.. 몇초동안 잡아먹을지.
 *  
 *  
 *  입력 N
 *  0 빈칸
 *  
 *  1 2 3 4 5 6 물고기의 크기
 *  
 *  아기상어 위치 9
 *  bfs 
 */
public class BOJ16236 {
	static int N;
	static int[][] board;
	static int[][] dist;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static Shark bs;
	static LinkedList<Shark> fish = new LinkedList<Shark>(); // 어레이가 비면 엄마호출.
	static Queue<Shark> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int y = 0; y < N; ++y) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; ++x) {
				board[y][x] = Integer.parseInt(st.nextToken());
				if (board[y][x] == 9) {
					bs = new Shark(y, x, 2);
				}
			}
		}

		int time = 0;
		int eat = 0;

		while (true) {
			q = new LinkedList<>();
			q.offer(bs);
			dist = new int[N][N];
			
			sharkMove();
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					System.out.print(dist[i][j] +" ");

				}
				System.out.println();
			}
			if (fish.size() == 0) {
				break;
			}
			sort();
			
			Shark eattingFish = fish.get(0);
			time += eattingFish.dist;
			eat++;
			board[eattingFish.y][eattingFish.x] = 0;
			if(eat == bs.dist) {
				bs.dist++;
				eat = 0;
			}
			q.add(new Shark(eattingFish.y, eattingFish.x, bs.dist));
			

		}
		System.out.println(time);
	}

	private static void sort() {
		Collections.sort(fish, new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				if (o1.y < o2.y) {
					return o2.y - o1.y;
				} else if (o1.y == o2.y) {
					if (o1.x < o2.x) {
						return o2.x - o1.x;
					} else if (o1.x == o2.x) {
						return 0;
					}
					return o1.x - o2.x;
				} else {
					return o1.y - o2.y;
				}
			}

		});
	}

	private static void sharkMove() {
		while (!q.isEmpty()) {
			
			Shark curr = q.poll();
			
			for (int dir = 0; dir < 4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N)	continue;
				if (board[ny][nx] > bs.dist || dist[ny][nx] > 0 || board[ny][nx] > bs.dist)continue;
				
				dist[ny][nx] = dist[curr.y][curr.x] + 1;
				//먹이찾음..
				if (0 < board[ny][nx] && board[ny][nx] < 7 && board[ny][nx] < bs.dist) {
					fish.add(new Shark(ny, nx, dist[ny][nx]));
					q.offer(new Shark(ny, nx, dist[ny][nx]));
					
				}
				else{
					//먹이 못찾음..지나갈순있다.
					q.offer(new Shark(ny, nx, dist[ny][nx]));
				}
				
			}
		}
	}

	static class Shark {
		int y;
		int x;
		int dist;

		Shark(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

}
