import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
	static int N, M, D;	
	static int[][] board;
	
	static ArrayList<Pos> enemy;
	static ArrayList<Pos> cenemy;
	static ArrayList<Pos> archer;
	static ArrayList<Pos> carcher;
	
	static int enemyCount;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		D = Integer.parseInt(s[2]);
		
		board = new int[N+1][M]; //궁병라인까지 추가
		visited = new boolean[M];
		enemy = new ArrayList<>();
		cenemy = new ArrayList<>();
		archer = new ArrayList<>();
		carcher = new ArrayList<>();
		
		for(int y=0; y<N; ++y) {
			s = br.readLine().split("\\s");
			for(int x=0; x<M; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
				if(board[y][x] == 1) {
					enemy.add(new Pos(y,x));
				}
			}
		}
		Collections.sort(enemy); //거리순으로 정렬
		setArcher(0, 0); // 조합을 이용한 궁병 셋팅
		System.out.println(answer);			
		
	}
	
	static boolean[] visited;	
	private static void setArcher(int idx, int depth) {
		if(depth == 3) {
			copyList();
			startGame();
			
			answer = Math.max(answer, enemyCount);
			
			enemyCount = 0;
			cenemy.clear();
			carcher.clear();
			return;
		}
		for(int i=idx; i<M; ++i) {
			if(visited[i]) continue;
			visited[i] = true;
			archer.add(new Pos(N, i,true));
			setArcher(i, depth+1);
			archer.remove(archer.size()-1);
			visited[i] = false;
		}
	}
	
	
	private static void startGame() {
		while(true) {
			if(cenemy.size() == 0) break; //다죽으면
			ready();
			shot();
			if(cenemy.size()+enemyCount<=answer) return;
			move();
		}
	}


	private static void shot() {
		Iterator<Pos> it = cenemy.iterator();
		
		while(it.hasNext()) {
			Pos curr = it.next();
			if(!curr.alive) {
				it.remove();
				enemyCount++;
			}
			
		}
	}


	private static void move() {
		if(cenemy.isEmpty()) return;
		Iterator<Pos> it = cenemy.iterator();
		
		while(it.hasNext()) {
			Pos curr = it.next();
			curr.y += 1;
			if(curr.y==N) it.remove();
		}
	}


	private static void ready() {
		Iterator<Pos> it = carcher.iterator();
		
		while(it.hasNext()) {
			Pos curr = it.next();			
			curr.alive = true; //궁병의 활쏠 기회를 alive를 활용
		}
		
		for(int i=0; i<carcher.size(); ++i) {
			
			if(!carcher.get(i).alive) continue;
			
			int tmpIdx = -1;
			int tmpD = Integer.MAX_VALUE;
			for(int j=0; j<cenemy.size(); ++j) {
				int distance = Math.abs(cenemy.get(j).y - carcher.get(i).y) + Math.abs(cenemy.get(j).x - carcher.get(i).x);
				
				if(D>=distance) {
					if(tmpD > distance) {
						tmpD = distance;
						tmpIdx = j;
					}
				}
				//System.out.println("거리: " + tmpD);
			}
			if(tmpIdx!=-1) {
				cenemy.get(tmpIdx).alive = false;
				//System.out.println("타겟팅: "+cenemy.get(tmpIdx).y +" "+cenemy.get(tmpIdx).x );
				carcher.get(i).alive = false;
			}
			
		}
		return;
	}


	private static void copyList() {
		for(int i=0; i<archer.size(); ++i) {
			carcher.add(new Pos(archer.get(i).y, archer.get(i).x));
		}
		for(int i=0; i<enemy.size(); ++i) {
			cenemy.add(new Pos(enemy.get(i).y, enemy.get(i).x, true));
		}
	}



	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		boolean alive;
		
		
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}


		public Pos(int y, int x, boolean alive) {
			super();
			this.y = y;
			this.x = x;
			this.alive = alive;
		}


		@Override
		public int compareTo(Pos o) {
			return o.x == this.x ? o.y-this.y : this.x-o.x ;
		}


		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", alive=" + alive + "]";
		}
		
		
	}
}
