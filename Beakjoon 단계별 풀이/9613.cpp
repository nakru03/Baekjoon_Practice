#include <iostream>

using namespace std;
int arr[1000001];
int gcd(int large, int small)
{
	if (large % small == 0)
		return small;
	else
		return gcd(small, large%small);
}

int main()
{
	int tc;
	
	cin >> tc;
	
	for (int i = 0; i < tc; ++i)
	{
		int n;
		long long res = 0; // int로 쓰면 최대일때 int를 초과한다.
		cin >> n;

		for (int j = 0; j < n; ++j)		
			cin >> arr[j];
		
		
		for (int j = 0; j < n-1; ++j)
		{
			for (int k = j + 1; k < n; ++k)
				res += gcd(arr[j], arr[k]);
		}
		cout << res << endl;
	}

	
}