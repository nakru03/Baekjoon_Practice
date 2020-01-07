import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


public class BOJ16235 {
	
	
	static int[][] board;
	static int[][] nourishment;
	static int N;
	static int M;
	static int K;
	static final int[] dy = {-1,-1,-1,0,0,1,1,1};
	static final int[] dx = {-1,0,1,-1,1,-1,0,1};
	
	static LinkedList<Tree> list = new LinkedList<Tree>();
	static ArrayList<Tree> deadlist;
	static ArrayList<Tree> newList;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split("\\s");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		//배열 방 초기화..
		board = new int[N][N];
		for(int i=0; i<N; ++i) {
			Arrays.fill(board[i], 5);
		}		
		nourishment = new int[N][N];
		//양분
		for(int y=0; y<N; ++y) {
			s = br.readLine().split("\\s");
			for(int x=0; x<N; ++x) {
				nourishment[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		for(int i=0; i<M; ++i) {
			s = br.readLine().split("\\s");
			list.add(new Tree(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, Integer.parseInt(s[2])));
		}//나무에 삽입.
		
		sorting(); //나무 리스트를 최초 1회 정렬.
		
		for(int i=0; i<K; ++i) {
			///봄
			if(list.size() ==0 ) break;
			deadlist = new ArrayList<Tree>();
			Iterator<Tree> it = list.iterator();
			while(it.hasNext()) {
					Tree curr = it.next();
					//죽은 나무.
					if(board[curr.y][curr.x] - curr.age < 0) {
						deadlist.add(curr);
						it.remove();
					}
					//안죽으면
					else {
						board[curr.y][curr.x] -= curr.age;
						curr.age++;
						
					}
			}
				
			//여름
			int size = deadlist.size();
			for(int j=0; j<size; ++j) {
				Tree curr = deadlist.get(j);
				board[curr.y][curr.x] += curr.age/2;
			}
			
			//가을
			newList = new ArrayList<Tree>();
			it = list.iterator();
			while(it.hasNext()) {
				
				Tree curr = it.next();
				
				if(curr.age % 5 == 0) {
					for(int dir=0; dir<8; ++dir) {
						
						int ny = curr.y + dy[dir];
						int nx = curr.x + dx[dir];					
						if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
						
						
						newList.add(new Tree (ny, nx, 1));
						
					}
				}
			}
			size = newList.size();
			for(int j=0; j<size; ++j) {
				list.addFirst(newList.get(j));
			}
			//겨울..
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					board[y][x] += nourishment[y][x];
				}
			}			
			
		}		
		bw.write(list.size()+"");
		bw.flush();
	}
	

	private static void sorting() {
		Collections.sort(list, new Comparator<Tree>(){

			@Override
			public int compare(Tree o1, Tree o2) {
				return o1.age-o2.age;
			}	
		});
	}

	static class Tree{
		int y;
		int x;
		int age;
		boolean live;
		Tree(int y, int x, int age){
			this.y = y;
			this.x = x;
			this.age = age;
			
		}
		
	}

}

