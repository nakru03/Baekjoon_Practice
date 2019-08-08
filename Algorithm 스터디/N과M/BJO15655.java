import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJO15655 {
	static int N;
	static ArrayList<Integer> nArray;
	static ArrayList<Integer> result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		nArray = new ArrayList<>();
		result=new ArrayList<>(); //정답배열
		
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
		doPerm(0, M, 0);
		System.out.println(sb);
	}
	static StringBuilder sb = new StringBuilder();
	private static void doPerm(int index, int m, int start) {
		if(start == m) {
			for(int i=0; i<m; ++i) {
				sb.append(result.get(i)+" ");		
			}
			sb.append("\n");
			return;
		}
		
		for(int i=index; i<N; ++i) {			
			if(visited[i]) continue;
			visited[i] =true;
			result.add(nArray.get(i));
			doPerm(i, m, start+1);
			visited[i]=false;
			result.remove(result.size()-1);
		}
	}

}
