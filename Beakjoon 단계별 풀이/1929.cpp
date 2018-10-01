#include <iostream>

#define MaxValue 1000001
using namespace std;
bool arr[MaxValue] = { true, true };

int main()
{
	cout.sync_with_stdio(false);
	int M, N;
	cin >> M >> N;
	for (int i = 2; i*i <= N; ++i)
	{
		if (!arr[i])
		{
			for (int j = i*i; j <= N; j=j+i)
			{
				arr[j] = true;
			}
		}
	}

	for (int i = M; i <= N; ++i)
	{
		if (!arr[i])
			cout << i << '\n';
	}
	return 0;
}