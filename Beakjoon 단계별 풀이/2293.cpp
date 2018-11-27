#include <iostream>
//1->1  1가지
//2->1+1 2가지
//   0+2
//3->1+1 +1 3가지
//   0+2 +1
//   0+3
using namespace std;

int arr[100];
int dp[100001];

int main()
{ 
	int n, k;
	dp[0] = 1;
	cin >> n >> k;
	for (int i = 1; i <= n; ++i)
	{
		cin >> arr[i];
	}
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= k; ++j) //j의 가치가 arr[i]의 가치보다 클때
		{
			if (j >= arr[i])
				dp[j] = dp[j] + dp[j - arr[i]];
		}
	}
	cout << dp[k]<<endl;
	return 0;
}