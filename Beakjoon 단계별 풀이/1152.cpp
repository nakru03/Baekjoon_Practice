//영어 대소문자와 띄어쓰기만으로 이루어진 문장이 주어진다.이 문장에는 몇 개의 단어가 있을까 ? 이를 구하는 프로그램을 작성하시오.


#include <iostream>
#include <cstring>
#define N 1000001


using namespace std;

int main()
{
	char s[N];
	cin.getline(s, N, '\n'); //스페이스 포함 문자열을 입력받을 때 getline을 사용한다.
	int count = 0;

	int size = strlen(s);

	for (int i = 0; i < size; i++)
	{
		if (s[i] == 32)
			count++;
	}
	if (s[0] == 32)
	{
		count--;
	}
	if (s[size - 1] == 32)
	{
		count--;
	}
	cout << count+1;
}