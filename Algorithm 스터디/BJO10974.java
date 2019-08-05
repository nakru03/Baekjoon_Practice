import java.util.Arrays;
import java.util.Scanner;

/*
 * 1부터 n까지의 수로 이루어진 순열을 사전순으로 출력해보자.
 * 첫번째 방법.. n이 8보다 작으므로 8중 포문을쓴다. 8!개 40000만번 정도의 연산이므로 에러가 안남.
 * 두번째 재귀를 통해 푼다.
 * 
 */
public class BJO10974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; ++i) {
			arr[i] = i+1;
		}
		doPermutation(arr,0);
	}

	private static void doPermutation(int[] arr, int depth) {
		if(arr.length == depth) {
			System.out.println(Arrays.toString(arr));
			return;
		}
			
		for(int i=depth; i<arr.length; ++i) {
			swap(arr,i,depth);
			if(arr[i]>arr[depth]) continue;
			doPermutation(arr,depth+1);
			swap(arr,i,depth);
		}
		
	}
	private static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	

}
