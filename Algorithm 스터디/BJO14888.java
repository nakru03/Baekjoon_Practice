import java.util.ArrayList;
import java.util.Scanner;

public class BJO14888 {
	static boolean[] visited;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		visited = new boolean[n];
		int[] oper = new int[4];
		ArrayList<Integer> operArr = new ArrayList<>();
		
		for(int i=0; i<arr.length; ++i) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<oper.length; ++i) {
			oper[i] = sc.nextInt();
		}
		
		operArr = makeOperArr(oper);
		//System.out.println(operArr);	
		dfs(arr, operArr, 0);
		System.out.println(max);
		System.out.println(min);
	}


	static ArrayList<Integer> permOper = new ArrayList<Integer>();
	private static ArrayList<Integer> makeOperArr(int[] oper) {
		ArrayList<Integer> operArr = new ArrayList<>();
		for(int i=0; i<oper.length; ++i) {
			for(int j=0; j<oper[i]; ++j) {
				operArr.add(i);
			}
		}
		return operArr;
	}

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	private static void dfs(int[] arr, ArrayList<Integer> operArr, int depth ) {
		
		if(depth == operArr.size()) {
			//System.out.println(permOper);
			int sum = arr[0];
			
			for(int i=0; i<arr.length-1; ++i) {
				switch(permOper.get(i)) {				
				case 0:					
					sum = sum + arr[i+1];
					break;
				case 1:					
					sum = sum - arr[i+1];
					break;
				case 2:					
					sum = sum * arr[i+1];
					break;
				case 3:
					sum = sum / arr[i+1];
					break;
				}
			}
			
			max = Math.max(sum, max);	
			//System.out.println(max);
			min = Math.min(sum, min);
		}
		
		
		//순열
		for(int i=0; i<operArr.size(); ++i) {
			if(visited[i]) continue;
			visited[i] = true;
			permOper.add(operArr.get(i));
			dfs(arr, operArr, depth+1);
			visited[i] = false;
			permOper.remove(permOper.size()-1);
			
		}
	}
	

}
