//���� N���� �̷���� ���� A�� ���� X�� �־�����.�� ��, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

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