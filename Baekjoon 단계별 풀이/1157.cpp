////���ĺ� ��ҹ��ڷ� �� �ܾ �־�����, �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.��, �빮�ڿ� �ҹ��ڸ� �������� �ʴ´�.
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