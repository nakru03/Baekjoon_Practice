////�� ���� A, B, C�� �־�����. �� ��, �� ��°�� ū ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
//// Ǯ�� - if else �� �̿��� �밡��
////		  sort�� �̿��� ����
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main()
{
	vector<int> arr;
	int A, B, C;

	cin >> A;
	cin >> B;
	cin >> C;

	arr.push_back(A);
	arr.push_back(B);
	arr.push_back(C);

	sort(arr.begin(), arr.end());

	cout << arr[arr.size() - 2];
}