

//"OOXXOXXOOO"�� ���� OX������ ����� �ִ�.O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�.������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�.���� ���, 10�� ������ ������ 3�� �ȴ�.
//
//"OOXXOXXOOO"�� ������ 1 + 2 + 0 + 0 + 1 + 0 + 0 + 1 + 2 + 3 = 10���̴�.
//
//OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.


#include <iostream>
#include <cstring>
using namespace std;

int main() 
{
	int n;
	char s[81];
	
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> s;
		int score = 0;
		int count = 0;
		int size = strlen(s);	

		for (int j = 0; j < size; j++)
		{
			if (s[j] == 'O')
			{
				++count;
				score += count;
			}
			else
				count = 0;
								
		}
		cout << score<<endl;
	}
}