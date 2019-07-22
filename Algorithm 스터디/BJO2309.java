import java.util.Arrays;
import java.util.Scanner;

public class BJO2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hobbit[] = new int[9];
		int sum = 0;
		int result = 0;

		for(int i=0; i<9; ++i) {
			hobbit[i] = sc.nextInt();
			sum += hobbit[i];
			
		}//init
		
		//System.out.println("гу╟Х"+sum);
		flag:for(int i=0; i<hobbit.length; ++i) {
			for(int j=0; j<hobbit.length; ++j) {
				if(i==j) continue;
					result = sum-(hobbit[i]+hobbit[j])	;
					if(result==100) {
						hobbit[i]= -999;
						hobbit[j] = -999;
						break flag;
					}	
					
			}
		}
		Arrays.sort(hobbit);
		for(int i=2; i<hobbit.length; ++i) {
			System.out.println(hobbit[i]);
		}

	}

}
