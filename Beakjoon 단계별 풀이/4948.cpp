//����Ʈ�� ����..�Է°� n�� ���� n����ũ�� 2n���� ���� �Ҽ� �׻� ����.
#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	while (true)
	{
		int n;
		int count = 0;
		cin >> n;
		if (n == 0)
			break;
		if (n == 1)
		{
			cout << "1" << endl;
			continue;
		}
		for (int i = n+1; i <=2*n; ++i)
		{
			bool flag = true;
			for (int j = 2; j <= sqrt(i); ++j)
			{
				if (i%j == 0)
				{
					flag = false;
					break;
				}
			}
			if (flag)
				count++;
		}

		cout << count << endl;
	}
}