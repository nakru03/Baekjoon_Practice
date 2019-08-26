import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static LinkedList<Tree> deadlist = new LinkedList<Tree>();
	static ArrayList<Tree> newList;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		
		board = new int[N][N];
		for(int i=0; i<N; ++i) {
			Arrays.fill(board[i], 5);
		}
		
		nourishment = new int[N][N];
		for(int y=0; y<N; ++y) {
			s = br.readLine().split(" ");
			for(int x=0; x<N; ++x) {
				nourishment[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		for(int i=0; i<M; ++i) {
			s = br.readLine().split(" ");
			list.add(new Tree(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, Integer.parseInt(s[2])));
		}
		sorting();
		for(int i=0; i<K; ++i) {
			if(list.size() ==0 ) break;
			spring();
			summer();
			autumm();
			winter();
		}
		
		
		System.out.println(list.size());
	}
	

	private static void sorting() {
		Collections.sort(list, new Comparator<Tree>(){

			@Override
			public int compare(Tree o1, Tree o2) {
				return o1.age-o2.age;
			}	
		});
	}

	private static void spring() {
		for(Iterator<Tree> it = list.iterator(); it.hasNext();) {
			Tree curr = it.next();
			if(board[curr.y][curr.x] - curr.age < 0) {
				deadlist.add(curr);
				it.remove();
			}
			else {
				board[curr.y][curr.x] -= curr.age;
				curr.age++;
				
			}
		}
		
		
	}
	
	private static void summer() {
		for(int i=0; i<deadlist.size(); ++i) {
			Tree curr = deadlist.get(i);
			board[curr.y][curr.x] += curr.age/2;
		}
		deadlist.clear();
	}
	
	private static void autumm() {
		newList = new ArrayList<Tree>();
		for(int i=0; i<list.size(); ++i) {
			Tree curr = list.get(i);
			if(curr.age % 5 == 0) {
				for(int dir=0; dir<8; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];					
					if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
					newList.add(new Tree (ny, nx, 1));
				}
			}
		}
		for(int i=0; i<newList.size(); ++i) {
			list.addFirst(newList.get(i));
		}
		
	}
	
	private static void winter() {
		for(int y=0; y<N; ++y) {
			for(int x=0; x<N; ++x) {
				board[y][x] += nourishment[y][x];
			}
		}
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

