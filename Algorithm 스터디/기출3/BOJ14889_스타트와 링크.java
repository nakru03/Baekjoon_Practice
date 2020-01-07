import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ14889 {
	
	static int N;
	static int[][] board;
	static int min = Integer.MAX_VALUE;
	
	static boolean[] teamSplit;
	static ArrayList<Integer> startTeam;
	static ArrayList<Integer> linkTeam;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int y=0; y<N; ++y) {
			String[] s = br.readLine().split("\\s");
			for(int x=0; x<N; ++x) {
				board[y][x] = Integer.parseInt(s[x]);
			}
		}
		
		teamSplit = new boolean[N];
		startTeam = new ArrayList<>();
		linkTeam = new ArrayList<>();
		combi(0,0);
		System.out.println(min);
	}

	private static void combi(int idx, int depth) {
		if(depth == N/2) {
			
			for(int i=0; i<teamSplit.length; ++i) {
				if(teamSplit[i])
					startTeam.add(i);
				else
					linkTeam.add(i);
			}
			
			int startSum = scoreCalc(startTeam);
			int linkSum = scoreCalc(linkTeam);
			
			min = Math.min(min, Math.abs(startSum-linkSum));
			startTeam.clear();
			linkTeam.clear();
			
		}
		for(int i=idx; i<N; ++i) {
			teamSplit[i] = true;
			combi(i+1, depth+1);
			teamSplit[i] = false;			
		}
	}

	private static int scoreCalc(ArrayList<Integer> team) {
		int sum = 0;
		for(int i=0; i<team.size(); ++i) {
			for(int j=0; j<team.size(); ++j) {
				sum += board[team.get(i)][team.get(j)];
			}
		}
		return sum;
	}

}
