#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
	int sum = 0;
	vector<int> arr;
	for (int i = 0; i < 9; ++i)
	{
		
		int n;

		cin >> n;
		arr.push_back(n);
		sum += arr[i];

	}

	for (int j = 0; j < 8; ++j)
	{
		
		for (int k = j+1; k < 9; ++k)
		{
			int res = sum - arr[j] - arr[k];
			if (res == 100)
			{
				arr[j] = 0;
				arr[k] = 0;
				goto flag;
			}

		}
	}

flag:

	sort(arr.begin(), arr.end());
	for (int i = 0; i < arr.size(); ++i)
	{
		if (!arr[i])
			continue;
		cout << arr[i] << endl;
	}
	return 0;
}