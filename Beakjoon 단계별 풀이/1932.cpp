#include <iostream>
#include <algorithm>

using namespace std;
int dp[500][500];
int memo[500][500];
int main()
{
	int tc;
	int sum = 0;
	cin >> tc;
	for (int i = 0; i < tc; ++i)
	{
		for (int j = 0; j <= i; ++j)
		{
			int n;
			cin >> n;
			dp[i][j] = n;
			
		}
	}
	memo[0][0] = dp[0][0];
	for (int i = 1; i < tc; ++i)
	{
		for (int j = 0; j <= i; ++j)
		{

			memo[i][j] = max(memo[i - 1][j] + dp[i][j], memo[i - 1][j - 1] + dp[i][j]);
			sum = memo[i][j];
			
		}
		
	}
	for (int i = 0; i < tc; ++i)
	{
		sum = max(memo[tc - 1][i], sum);
	}
	cout << sum << endl;
}