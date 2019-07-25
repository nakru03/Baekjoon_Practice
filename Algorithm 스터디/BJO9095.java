import java.util.Scanner;

public class BJO9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = oneTwoThree(0,sc.nextInt());
		System.out.println(res);
	}

	private static int oneTwoThree(int start, int goal) {
		if(start>goal)
			return 0;
		if(start==goal)
			return 1;		
		int answer = 0; //°¡Áö¼ö
		for(int i=1; i<=3; ++i) {
			answer+=oneTwoThree(start+i,goal);
		}
		return answer;			
		
	}
}
