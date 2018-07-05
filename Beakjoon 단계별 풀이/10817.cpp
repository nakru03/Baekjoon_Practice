////세 정수 A, B, C가 주어진다. 이 때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오. 
//// 풀이 - if else 를 이용한 노가다
////		  sort를 이용한 정렬
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