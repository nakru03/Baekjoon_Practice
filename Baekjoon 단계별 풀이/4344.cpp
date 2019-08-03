//첫째 줄에는 테스트케이스의 개수 C가 주어진다.
//
//둘째 줄부터 각 테스트케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
//

//#include <iostream>
//#include <vector>
//using namespace std;
//
//int main()
//{
//	int N;
//	float n;	
//	float res,avg;
//	int cnt = 0;
//	float sum = 0;
//	vector<int> arr;
//
//	cin >> N;
//
//	for (int i = 0; i < N; i++)
//	{
//		cin>> n;
//		arr.push_back(n);
//		sum += n;
//	}
//
//	avg = sum / (float)N;
//	
//	for (int i = 0; i < arr.size(); i++)
//	{
//		if (arr[i] > avg)
//			cnt++;
//	}
//	
//	res = (float)((float)cnt*100.0)/n;
//	printf("%.3f%%", res);
//}