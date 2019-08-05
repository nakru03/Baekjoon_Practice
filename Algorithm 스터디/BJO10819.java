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
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; ++i) {
			arr.add(sc.nextInt());
		}
		max = Math.max(max, doPerm(arr,0));
		System.out.println(max);
		

	}
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static boolean[] visited = new boolean[8];
	private static int doPerm(ArrayList<Integer> arr, int depth) {
		
		if(depth==arr.size()) {
			int sum = 0;
			for(int i=0; i<res.size()-1; ++i) {
				sum += Math.abs(res.get(i)-res.get(i+1));
			}
			System.out.println(res);
			System.out.println(sum);
			return sum;
		}
		
		for(int i=0; i<arr.size(); ++i) {
			if(visited[i]) continue;			
			visited[i] = true;
			res.add(arr.get(i));
			doPerm(arr, depth+1);
			visited[i] = false;
			res.remove(res.size()-1);
		}
		return 0;
	}

}
