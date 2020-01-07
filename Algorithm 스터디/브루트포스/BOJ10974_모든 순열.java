import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 1부터 n까지의 수로 이루어진 순열을 사전순으로 출력해보자.
 * 첫번째 방법.. n이 8보다 작으므로 8중 포문을쓴다. 8!개 40000만번 정도의 연산이므로 에러가 안남.
 * 두번째 재귀를 통해 푼다.??
 * 세번째 dfs.
 * 
 */
public class BJO10974 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		for(int i=0; i<arr.length; ++i) {
			arr[i] = i+1;
		}
		doPermutation(arr,visited, 0);
	}                                                                     
	static ArrayList<Integer> res = new ArrayList<Integer>();
	private static void doPermutation(int[] arr, boolean[] visited, int depth ) {
		if(arr.length == depth) {
			for(int i=0; i<res.size(); ++i) {
				System.out.print(res.get(i) + " ");
			}
			System.out.println();
			//res.clear();
			return;
		}
			
		for(int i=0; i<arr.length; ++i) {
			if(visited[i]) continue;
			res.add(i+1);
			visited[i] = true;			
			doPermutation(arr,visited,depth+1); //방문체크를 하여 가장 깊은곳부터 탐색. 저장 배열에 저장할위치 arr[depth]=i를 들고감
			visited[i] = false;
			res.remove(res.size()-1);
		}
		
	}

}
