//#include <iostream>
//
//using namespace std;
//
//int main()
//{
//	int s[8];
//	int check=0;
//	for (int i = 0; i < 8; i++)
//		cin >> s[i];
//
//	for (int i = 0; i < 8; i++)
//	{
//		if (i + 1 == s[i])
//			check++;
//		else if (8-i == s[i])
//			check--;
//	}
//	if (check == 8)
//		cout << "ascending";
//	else if (check == -8)
//		cout << "descending";
//	else
//		cout << "mixed";
//}