//
//
//�� ���� �ڿ��� A, B, C�� �־��� �� A��B��C�� ����� ����� 0���� 9���� ������ ���ڰ� �� ���� ���������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//���� ��� A = 150, B = 266, C = 427 �̶��
//
//A �� B �� C = 150 �� 266 �� 427 = 17037300 �� �ǰ�,
//
//����� ��� 17037300 ���� 0�� 3��, 1�� 1��, 3�� 2��, 7�� 2�� ������.
//

#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
	int A, B, C;
	int result;
	int count[10] = {0,};
	
	cin >> A >> B >> C;
	result = A * B*C;

	while (result != 0)
	{
		int tmp;
		tmp = result % 10;
		count[tmp]++;
		result /= 10;
	}
	for (int i = 0; i < 10; i++)
	{
		cout << count[i] << endl;;
	}
}