#include <iostream>

using namespace std;

int main()
{
	int N;
	int count = 0;
	
	cin >> N;
	for (int i = 0; i < N; ++i)
	{
		int n;
		cin >> n;
		bool flag = true;
		if (n == 2)
			flag = true;
		else if (n == 1)
			flag = false;
		else {
			for (int i = 2; i < n; ++i)
			{
				if (n%i == 0)
					flag = false;
									
			}
		}
		if (flag == true)
			count++;
		
	}
	cout << count << endl;
	return 0;
}