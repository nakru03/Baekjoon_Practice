#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int tc;	
	cin >> tc;
	int arr[1000][3];
	
	for (int i = 0; i < tc; ++i)
	{
		for (int j = 0; j < 3; ++j)
			cin >> arr[i][j];
	}
	
	for (int i = 1; i < tc; ++i)
	{		
		arr[i][0] = arr[i][0] + min(arr[i - 1][1], arr[i - 1][2]);
		arr[i][1] = arr[i][1] + min(arr[i - 1][0], arr[i - 1][2]);
		arr[i][2] = arr[i][2] + min(arr[i - 1][0], arr[i - 1][1]);
	}
	cout<<min(arr[tc-1][0],min(arr[tc-1][1],arr[tc-1][2]))<<endl;
	return 0;
}