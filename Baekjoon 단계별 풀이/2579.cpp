#include <iostream>
#include <algorithm>

using namespace std;

int dp[300];
int memo[300];
int main()
{
	int tc;
	cin >> tc;
	for (int i = 0; i < tc; ++i)
	{		
		cin >> dp[i];
	}
	memo[0] = dp[0];
	memo[1] = dp[0] + dp[1];
	memo[2] = max(dp[0] + dp[2], dp[1] + dp[2]);

	for (int i = 3; i < tc; ++i)
	{
		
		memo[i] = max(memo[i - 2] + dp[i], memo[i - 3] + dp[i - 1] + dp[i]);
		
	}
	cout << memo[tc - 1] << endl;
	return 0;
}