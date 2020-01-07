import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {	
	static Stack<Character> type = new Stack<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine().replaceAll(",", "").replaceAll(";", "");
		String[] s = tmp.split(" ");
		StringBuilder sb = new StringBuilder();
		//System.out.println(Arrays.deepToString(s));
		for(int i=1; i<s.length; ++i) {
			String var = "";
			sb.append(s[0]);
			if(s[i].length()>1) {
				char[] charArr = s[i].toCharArray();
				for(int j=0; j<charArr.length; ++j) {
					if(Character.isAlphabetic(charArr[j])) {
						var += charArr[j];
					}
					else {
						if(charArr[j] == '[')
							type.push(']');
						else if(charArr[j] == ']')
							type.push('[');
						else type.push(charArr[j]);
					}
				}
				while(!type.isEmpty()) {
					sb.append(type.pop());
				}
				sb.append(" "+var+";");
			}
			else
				sb.append(" "+s[i]+";");
				
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
