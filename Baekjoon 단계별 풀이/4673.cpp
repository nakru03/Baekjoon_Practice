#include <iostream>
using namespace std;

bool mem[10001];
int selfNumber(int n) {
	int sum = n;
	while (n != 0)
	{
		sum += n % 10; //1의 자리수가 나머지로 나옴
		n = n / 10; //10 씩 나누어줌으로 자리수를 낮춤
	}
	return sum;
}
int main()
{
	for (int i = 1; i < 10001; ++i)
	{
		int res;
		res = selfNumber(i);
		if(res<=10000)//1만을 넘는 경우 입력범위 초과
			mem[res] = true;
	}
	for (int i = 1; i < 10001; ++i)
		if (mem[i] == false)
			cout << i << endl;
	
	return 0;
}