import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1043 {
	static int N;
	static int M;
	static int answer;
	static int p;
	static boolean[] truth = new boolean[51];
	static ArrayList<Integer>[] party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		String[] s = br.readLine().split("\\s");
		for(int i=1; i<s.length; ++i) {
			truth[Integer.parseInt(s[i])] = true;
		}
		
		party = new ArrayList[M];
		for(int i=0; i<party.length; ++i) {
			party[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			for(int j=0; j<p; ++j) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		int partyCount = M;
		int ex;
		while(true) {
			ex = partyCount;
			for(int i=0; i<party.length; ++i) {
				for(int j=0; j<party[i].size(); ++j) {
					if(truth[party[i].get(j)]) {
						for(int k=0; k<party[i].size(); ++k) {
							truth[party[i].get(k)] = true;
						}
						party[i].clear();
						partyCount--;
						break;
					}
				}
			}
			if(partyCount==ex) {
				break;
			}
		}
		System.out.println(partyCount);
	}
}
