import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ17143 {
	static ArrayList<Shark> list = new ArrayList<>();
	static int[][] board;
	static int Y;
	static int X;
	static final int[] dy = {-99,-1, 1, 0, 0};
	static final int[] dx = {-99,0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		board = new int[Y+1][X+1];
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; ++i){
			String[] tmp = br.readLine().split(" ");
			board[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = i+1; //상어에게 번호부여 1부터시작.인덱스접근시 -1해줘야됨.
			list.add(new Shark(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),
								Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4])));
		}
		
		int king = 1;
		int result = 0;
		while(true) {
			if(king==X+1)
				break;
			//상어왕의 낚시
			for(int y=1; y<=Y; ++y) {
				if(board[y][king]!=0) {
					result+=list.get(board[y][king]-1).z;
					list.get(board[y][king]-1).z = -99;//삭제 상어 인덱스.
					board[y][king]=0;
					break;
				}
			}
			//상어 이동.
			sharkMove();
//			for(int i=1; i<=Y; ++i) {
//				for(int j=1; j<=X; ++j) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("#############################################");
			king++;
		}		
		System.out.println(result);
	}
	
	
	private static void sharkMove() {
		for(int i=0; i<list.size(); ++i) {
			Shark shark = list.get(i);
			if(shark.d==1 || shark.d==2) 
				shark.s %= (2*(Y-1));
			else
				shark.s %= (2*(X-1)); //가지치기 개같다..
			
			for(int j=0; j<shark.s; ++j) {
				if(shark.d == 1 || shark.d==2) { //위 아래
					int ny = shark.y + dy[shark.d];
					if(ny<1 || ny>Y) {
						shark.d = 3-shark.d;
						
					}
					shark.y = shark.y + dy[shark.d];
				}
				else {
					int nx = shark.x + dx[shark.d];
					if(nx<1 || nx>X) {
						shark.d = 7-shark.d;
						
					}
					shark.x = shark.x + dx[shark.d];
				}
			}
			
			
		}
		for(int y=1; y<=Y; ++y) { //모든 보드를 0으로 초기화.
			for(int x=1; x<=X; ++x) {
				board[y][x] = 0;
			}
		}
		for(int i=0; i<list.size(); ++i) {
			Shark shark = list.get(i);
			if(shark.z<0) {
				continue; //넘버링 체크할것
			}
			if(board[shark.y][shark.x]!=0) {
				int o1 = board[shark.y][shark.x]-1;
				if(list.get(o1).z > shark.z){
					shark.z = -99;
				}//먼저온 샤크가 더 큰경우
				else {
					list.get(o1).z = -99;
					board[shark.y][shark.x] = i+1;
				}//새 샤크가 더 큰경우				
			}
			else {
				board[shark.y][shark.x] = i+1;
			}
		}
	}


	static class Shark {
		int y; //y좌표ㅕ
		int x; //x좌표
		int s; //속력
		int d; //방향
		int z; //크기
		Shark(int y, int x, int s, int d, int z){
			this.y=y;
			this.x=x;
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}

}
