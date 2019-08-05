include <iostream>
#include <cstring>
using namespace std;
#define MAX 101

int main()
{
	string str;
	int tc;
	cin>>tc;

	int count = tc;
	for (int i = 0; i < tc; ++i)
	{
		char str[MAX];
		bool flag=true;
		cin>>str;
		for (int i = 0; i<strlen(str); ++i)
		{
			//현재와 이전 문자가 다름
			if (i != 0 && str[i] != str[i - 1])
			{
				for (int j = 0; j < i; ++j)
				{
					if (str[i] == str[j]) //현재 문자와 같은 문자가 이전에 나왔을때
					{
						count--;
						flag = false;
						break;
					}
				}

			}
			if (!flag)
				break;
		}
	}
	cout << count<<endl;
}