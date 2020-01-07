import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int count = 0;
		
		int flag = -1;
		while(true) {
			flag = count;
			if(s.contains("c=")) {
				s = s.replaceFirst("c=", "0");
				count++;
			}
			else if(s.contains("c-")) {
				s = s.replaceFirst("c-", "0");
				count++;
			}
			else if(s.contains("dz=")) {
				s = s.replaceFirst("dz=", "0");
				count++;
			}			
			else if(s.contains("d-")) {
				s = s.replaceFirst("d-", "0");
				count++;
			}
			else if(s.contains("lj")) {
				s = s.replaceFirst("lj", "0");
				count++;
			}			
			else if(s.contains("nj")) {
				s = s.replaceFirst("nj", "0");
				count++;
			}
			else if(s.contains("s=")) {
				s = s.replaceFirst("s=", "0");
				count++;
			}
			else if(s.contains("z=")) {
				s = s.replaceFirst("z=", "0");
				count++;
			}
			if(count == flag ) break;
		}
		
		for(int i=0; i<s.length(); ++i) {
			if(s.charAt(i)!='0') count++;
		}
		System.out.println(count);
	}

}
