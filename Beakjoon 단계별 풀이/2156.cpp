#include <iostream>
#include <algorithm>

int arr[10001] = { 0, };
int dp[10001] = { 0, };

using namespace std;

int main()
{
	int n,tmp;
	cin >> n;
	
	for (int i = 1; i <= n; ++i)
	{
		cin >> arr[i];
	}
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	for (int i = 3; i <= n; ++i)
	{
		tmp = max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
		dp[i] = max(tmp, dp[i - 1]);
	}
	cout << dp[n] << endl;
	return 0;
}