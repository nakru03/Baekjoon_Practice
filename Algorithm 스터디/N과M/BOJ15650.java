import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJO15650 {
	static int N;
	static ArrayList<Integer> arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		N =Integer.parseInt(tokenizer.nextToken());
		int M =Integer.parseInt(tokenizer.nextToken());
		arr = new ArrayList<>(); //정답배열
		visited = new boolean[N+1];
		doPerm(1, M, 0);

	}

	private static void doPerm(int index, int m, int start) {
		if(start == m) {
			for(int i=0; i<arr.size(); ++i) {
				System.out.print(arr.get(i) + " ");				
			}
			System.out.println();
			return;
		}
		
		for(int i=index; i<=N; i++) {			
			if(visited[i]) continue;
			visited[i] =true;
			arr.add(i);
			doPerm(i, m, start+1);
			arr.remove(arr.size()-1);
			visited[i]=false;			
		}
	}

}
