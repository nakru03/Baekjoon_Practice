#include <iostream>
#include <algorithm>
using namespace std;

int dp[1000001]={ 0,0 };

int main()
{
	int n;
	//dp[n]은 n까지 시행횟수 저장
	//bottom up 방식을 이용
	

	cin >> n;
	for (int i = 2; i <= n; ++i)
	{
		dp[i] = dp[i - 1] + 1; 

		if (i % 2 == 0)
		{
			dp[i] = min(dp[i], dp[i / 2] + 1);
		}
		if (i % 3 == 0)
		{
			dp[i] = min(dp[i], dp[i / 3] + 1);
		}
	}
	cout << dp[n]<<endl;
	return 0;

}