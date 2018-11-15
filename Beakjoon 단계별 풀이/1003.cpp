#include <iostream>

using namespace std;


int arr[41] = { 0,1 };
int fibonacci(int n)
{
	if (n == 0) return 0;

	else if (n == 1) return 1;

	if (arr[n] != 0) //메모제이션 활용.
		return arr[n];
	else {
		return arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}
	
}
int main()
{
	cin.sync_with_stdio(false);
	int tc;
	cin >> tc;
	for (int i = 0; i < tc; ++i)
	{
		int n;
		cin >> n;
		if (n == 0) {
			printf("1 0\n");
		}
		else if (n == 1) {
			printf("0 1\n");
		}
		else {
			fibonacci(n);
			printf("%d %d\n", arr[n - 1], arr[n]);
		}
		
	}
}