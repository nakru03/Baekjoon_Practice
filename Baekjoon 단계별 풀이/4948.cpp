//베르트랑 공준..입력값 n에 대해 n보다크고 2n보다 작은 소수 항상 존재.
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