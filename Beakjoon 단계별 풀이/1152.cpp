//���� ��ҹ��ڿ� ���⸸���� �̷���� ������ �־�����.�� ���忡�� �� ���� �ܾ ������ ? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.


#include <iostream>
#include <cstring>
#define N 1000001


using namespace std;

int main()
{
	char s[N];
	cin.getline(s, N, '\n'); //�����̽� ���� ���ڿ��� �Է¹��� �� getline�� ����Ѵ�.
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