import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJO15663 {
	static int N;
	static ArrayList<Integer> nArray;
	static ArrayList<Integer> result;
	static boolean[] visited;
	static LinkedHashSet<ArrayList<Integer>> set;
	
	public static void main(String[] args) throws IOException {
		nArray = new ArrayList<>();
		result=new ArrayList<>(); //정답배열
		//중복제거를 위한 셋.
		set = new LinkedHashSet<ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String line2 = br.readLine();
		StringTokenizer tokenizer1 = new StringTokenizer(line1);
		StringTokenizer tokenizer2 = new StringTokenizer(line2);			
		N =Integer.parseInt(tokenizer1.nextToken());
		int M =Integer.parseInt(tokenizer1.nextToken());		
		for(int i=0; i<N; ++i) {
			nArray.add(Integer.parseInt(tokenizer2.nextToken()));
		}
		
		Collections.sort(nArray);
		visited = new boolean[N+1];
		
		doPerm(M, 0, set);
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//System.out.println(sb);
	}
	static StringBuilder sb = new StringBuilder();
	
	private static void doPerm(int m, int start, LinkedHashSet<ArrayList<Integer>> set) {
		
		if(start == m) {
			ArrayList<Integer>tmp = result;
			System.out.println(tmp.toString());
			set.add(tmp);
			//System.out.println(set.toString());
			//sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; ++i) {			
			if(visited[i]) continue;
			visited[i] =true;
			result.add(nArray.get(i));
			doPerm(m, start+1, set);
			visited[i]=false;
			result.remove(result.size()-1);
		}
	}

}
