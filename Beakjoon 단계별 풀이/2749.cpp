//피사노 주기 문제.
//피보나치는 k로 나눈 나머지는 항상 주기를 가지게 된다.
//주기 길이가 p이면 N번째 피보나치수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같다.
//M=10^K일떄 K>2 주기는 항상 15x10^(k-1)을 가진다.
#include <iostream>

using namespace std;

const int m = 1000000;
const int p = 15 * m / 10;
int fibo[p] = { 0,1 };
int main()
{
	long long n;
	cin >> n;
	for (int i = 2; i < p; ++i)
	{
		fibo[i] = fibo[i - 1] + fibo[i - 2];
		fibo[i] %= m;
	}
	cout << fibo[n%p] << endl;

	return 0;
}