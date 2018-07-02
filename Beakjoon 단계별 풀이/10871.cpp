//정수 N개로 이루어진 수열 A와 정수 X가 주어진다.이 때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int N, X;
	int n;
	vector<int> arr;

	cin >> N;
	cin >> X;
	
	for (int i = 0; i < N; i++)
	{
		cin >> n;
		arr.push_back(n);		
	}

	for (int i = 0; i < N; i++)
	{
		if (arr[i] < X)
			cout << arr[i]<<" ";
	}
}