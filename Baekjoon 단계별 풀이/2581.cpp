#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	vector<int> arr;	
	int M, N;
	int sum = 0;	
	cin >> M >> N;
	
	for (int i = M; i < N+1; ++i)
	{
		bool flag=true;
		if (i <= 1 || N <= 1) //2일때  생각해야한다.
		{
			flag = false;
		}
		for (int j = 2; j < i; ++j)
		{
			if (i%j == 0)
			{
				flag = false;
				break; //break를 통한 연산속도 증가.
			}				
			else
				flag = true;
		}
		if (flag)
		{
			arr.push_back(i);
			sum += i;
		}
			
	}
	if (!arr.size())
		cout << "-1"<<endl;
	else
	{
		int minimum = *min_element(arr.begin(), arr.end());
		cout << sum << endl;
		cout << minimum << endl;		
	}
	
	return 0;
}