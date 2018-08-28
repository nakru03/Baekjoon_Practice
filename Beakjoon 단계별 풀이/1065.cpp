
#include <iostream>
#include <vector>
using namespace std;

bool hansoo(int n)
{
	int tmp = n;
	vector<int> arr;
	while (tmp != 0)// 배열 각 방에 자릿수를 나누어 담음
	{
		arr.push_back(tmp % 10);
		tmp = tmp/10;
	}
	
	if (arr[1] * 2 == arr[0] + arr[2]) //등차중항을 이용한 등차 증명
		return true;
	else
		return false;
}
int main()
{
	int n;
	int cnt = 0;
	cin >> n;
	if (n < 1 || n>1000)
		exit(1);
	for (int i = 1; i < n+1; ++i)
	{
		if (i < 100) //100미만의 수는 항상 등차수열임
			cnt++;
		else if (i < 1000)//그외 한수 함수를 사용
			if (hansoo(i))
				cnt++;
		
	}
	cout << cnt << endl;
	return 0;
}