////알파벳 소문자로만 이루어진 단어 S가 주어진다.각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 - 1을 출력하는 프로그램을 작성하시오.
//
//#include <iostream>
//#include <cstring>
//using namespace std;
//
//int main()
//{
//	char word[101]{ 0, };
//	int arr[26];
//	int count = 0;
//	
//	cin >> word;	
//
//	for (int i = 0; i < 26; i++)
//	{
//		arr[i] = -1;
//	}
//	int length = strlen(word);
//	for (int i = 0; i < length; i++)
//	{
//		if (arr[word[i] - 97] == -1)
//			arr[word[i] - 97] = i;
//		
//			
//	
//		
//	}
//	for (int i = 0; i < 26; i++)
//	{
//		cout << arr[i]<<" ";
//	}
//	return 0;
//}