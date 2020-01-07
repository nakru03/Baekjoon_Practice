import java.util.Scanner;

public class BJO1476 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int e1 = 1;
		int s1 = 1;
		int m1 = 1;
		int count = 1;
		
		while(true) {
			if(e==e1&&s==s1&&m==m1)
				break;
			e1 += 1;
			s1 += 1;
			m1 += 1;
			
			if(e1>15) 
				e1 = 1;
			if(s1>28)
				s1 = 1;
			if(m1>19)
				m1 = 1;
			count++;	
		}
		System.out.println(count);
	}

}
