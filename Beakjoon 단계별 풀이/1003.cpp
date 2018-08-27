////메모제이션을 이용한 피보나치 문제.//
//#include <iostream>
//
//using namespace std;
//
//int memo[41] = { 1,1, };
//
//int fibo_mem(int n)
//{	
//	if (n == 0)
//	{
//		memo[0] = 1;
//		return 0;
//	}
//	else if (n == 1)
//	{
//		memo[1] = 1;
//		return 1;
//	}
//	return memo[n] = fibo_mem(n - 1) + fibo_mem(n - 2);
//}
//
//int main()
//{
//	
//	int tc;
//
//	scanf("%d", &tc);
//	for (int i = 0; i < tc; ++i)
//	{
//		int n;
//		scanf("%d", &n);
//		if (n == 0) printf("1 0\n");
//		else if (n == 1) printf("0 1\n");
//		else {
//			fibo_mem(n);
//			printf("%d %d", memo[n - 2], memo[n - 1]);
//		}	
//		
//	}
//	return 0;
//}