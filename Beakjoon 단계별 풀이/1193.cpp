//이와 같이 나열된 분수들을 1 / 1 -> 1 / 2 -> 2 / 1 -> 3 / 1 -> 2 / 2->… 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
//
//X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
//
//첫째 줄에 X(1 ≤ X ≤ 10, 000, 000)가 주어진다.
//
//#include <iostream>
//
//using namespace std;
//
//int main()
//{
//	int X;
//	cin >> X;
//	int i;
//	for (i = 1; X > 0; i++)
//		X = X - i;
//	
//	if (i % 2 == 1)
//		cout << i + X - 1 << "/" << 1 - X;
//	else
//		cout << 1 - X << "/" << i + X - 1;
//}