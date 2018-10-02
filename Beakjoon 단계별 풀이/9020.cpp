/*아이디어. 입력값 n/2에서 가장 근접한 소수값을 찾는다 n-소수= 소수가 맞는지 판별한다.*/


#include <iostream>
#include <cmath>
using namespace std;

bool primeChecker(int number)
{
	bool flag = true;
	for (int i = 2; i <= sqrt(number); ++i)
	{
		if (number%i == 0)
		{
			flag = false;
			break;
		}
	}
	return flag;
}
int main()
{
	int tc;
	cin >> tc;
	for (int i = 0; i < tc; ++i)
	{
		int n;
		cin >> n;
		for (int i = n / 2; i > 1; --i)
		{
			bool check = true;
			check = primeChecker(i);
			if (check)
			{
				int second = n - i;// n-소수 = 소수(판별) 필요
				check = primeChecker(second);
				if (check)
				{
					cout << i << " " << second << "\n";
					break;
				}
					
			}
				

		}
	}
	return 0;
}