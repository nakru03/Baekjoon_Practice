import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2607 {
	static int[] alphabet;
	static String fixWord;
	static int differentWord = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		char[] fixWordArr = br.readLine().toCharArray();
		int result = 0;
		for(int t=1; t<tc; ++t) {			
			int differCount = 0;
			alphabet = new int[26];
			char[] word = br.readLine().toCharArray();
			
			for(int i=0; i<fixWordArr.length; ++i) {
				
				alphabet[(int)(fixWordArr[i] - 'A')]++;
								
			}
			
			for(int i=0; i<word.length; ++i) {					
				
				alphabet[(int)(word[i]-'A')]--;
								
			}		
			
//			for(int i=0; i<alphabet.length; ++i) {
//				System.out.print(alphabet[i] + " ");
//			}
			
			for(int i=0; i<alphabet.length; ++i) {
				differCount += Math.abs(alphabet[i]);
			}
			if(differCount<=2 && word.length==fixWordArr.length) result++;
			else if(differCount<2) result++;
			
		}
		System.out.println(result);
	}
	
}
