import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s= br.readLine();
		
		int i=0;
		int j=s.length()-1;
		boolean flag = false;
		while(true) {
			if(s.length()==1) {
				flag=true;
				break;
			}
			if(s.charAt(i)!=s.charAt(j)) {
				break;
			}
			if(i>j) {
				flag = true;
				break;
			}
			i++;
			j--;
		}
		System.out.println(flag);
	}

}
