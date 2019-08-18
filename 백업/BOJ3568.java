import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class BOJ3568 {	
	static Stack<Character> type = new Stack<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine().replaceAll(",", "").replaceAll(";", ""); //, ; 을 삭제하는 전처리.
		String[] s = tmp.split(" "); //공백간격으로 스플릿.
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<s.length; ++i) {
			String var = "";
			sb.append(s[0]); //공통된 자료형
			if(s[i].length()>1) { //추가 자료형이 존재할때
				char[] charArr = s[i].toCharArray();
				for(int j=0; j<charArr.length; ++j) {
					if(Character.isAlphabetic(charArr[j])) { //변수명이면 저장.
						var += charArr[j];
					}
					else {
						if(charArr[j] == '[') //[] 타입은 반대로 넣어야함
							type.push(']');
						else if(charArr[j] == ']')
							type.push('[');
						else type.push(charArr[j]); //스택에넣기
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
