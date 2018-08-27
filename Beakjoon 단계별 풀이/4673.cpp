#include <iostream>
using namespace std;

bool mem[10001];
int selfNumber(int n) {
	int sum = n;
	while (n != 0)
	{
		sum += n % 10; //1�� �ڸ����� �������� ����
		n = n / 10; //10 �� ������������ �ڸ����� ����
	}
	return sum;
}
int main()
{
	for (int i = 1; i < 10001; ++i)
	{
		int res;
		res = selfNumber(i);
		if(res<=10000)//1���� �Ѵ� ��� �Է¹��� �ʰ�
			mem[res] = true;
	}
	for (int i = 1; i < 10001; ++i)
		if (mem[i] == false)
			cout << i << endl;
	
	return 0;
}