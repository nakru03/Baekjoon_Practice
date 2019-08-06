import java.util.ArrayList;
import java.util.Scanner;
/*
 * 모든 순열 찾아서 계산...?
 * 
 */
public class BJO10819 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int n = sc.nextInt();
		
		
		for(int i=0; i<n; ++i) {
			arr.add(sc.nextInt());
		}
		doPerm(arr,0);
		System.out.println(max);
		

	}
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static boolean[] visited = new boolean[8];
	private static void doPerm(ArrayList<Integer> arr, int depth) {
		
		if(depth==arr.size()) {
			int sum = 0;
			for(int i=0; i<res.size()-1; ++i) {
				sum += Math.abs(res.get(i)-res.get(i+1));
			}
			max = Math.max(sum, max);
			//System.out.println(res);
			//System.out.println(sum);
		}
		
		for(int i=0; i<arr.size(); ++i) {
			if(visited[i]) continue;			
			visited[i] = true;
			res.add(arr.get(i));
			doPerm(arr, depth+1);
			visited[i] = false;
			res.remove(res.size()-1);
		}
	}

}
