////알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.단, 대문자와 소문자를 구분하지 않는다.
//
//#include <iostream>
//#include <string>
//
//
//using namespace std;
//
//int main()
//{
//	string s;
//	int arr[26]{ 0, };
//	int max = 0;
//	char res;
//
//	getline(cin, s);
//	
//
//	for (int i = 0; i < s.length(); i++)
//	{
//		if (s[i] >= 'a' && s[i] <= 'z')
//			arr[s[i] - 'a']++;
//
//		else
//			arr[s[i] - 'A' ]++;
//		
//	}
//	for (int i = 0; i < 26; i++)
//	{
//		if (arr[i] > max) {
//			max = arr[i];
//			res = i + 65;
//		}			
//		else if (arr[i] == max)
//			res = '?';
//	}
//	
//	cout << res;
//	return 0;
//}