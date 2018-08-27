////N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//#include <iostream>
//#include <vector>
//using namespace std;
//
//void bubble_sort(int len, vector<int>& arr);
//int main()
//{
//	int N;
//	vector<int> arr;
//
//	cin >> N;
//
//	for (int i = 0; i < N; i++)
//	{
//		int n;
//		cin >> n;
//		arr.push_back(n);
//	}
//	bubble_sort(N, arr);
//	for (int i = 0; i < N; i++)
//	{
//		cout << arr[i] << endl;
//	}
//	return 0;
//}
//
//void bubble_sort(int len, vector<int>& arr)
//{
//	for (int i = 0; i < len; i++)
//	{
//		for (int j = 0; j < len - i - 1; j++)
//		{
//			if (arr[j] > arr[j + 1])
//			{
//				int tmp = arr[j];
//				arr[j] = arr[j + 1];
//				arr[j + 1] = tmp;
//			}
//		}
//	}
//}