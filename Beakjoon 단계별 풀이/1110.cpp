//0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�.���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�.�� ����, �־��� ���� ���� ������ �ڸ� ���ڿ� �տ��� ���� ���� ���� ������ �ڸ� ���ڸ� �̾� ���̸� ���ο� ���� ���� �� �ִ�.���� ���� ����.
//
//26���� �����Ѵ�. 2 + 6 = 8�̴�.���ο� ���ڴ� 68�̴�. 6 + 8 = 14�̴�.���ο� ���ڴ� 84�̴�. 8 + 4 = 12�̴�.���ο� ���ڴ� 42�̴�. 4 + 2 = 6�̴�.���ο� ���ڴ� 26�̴�.
//
//���� ���� 4������ ���� ���ڷ� ���ƿ� �� �ִ�.���� 26�� ����Ŭ�� ���̴� 4�̴�.
//
//N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

//#include<iostream>
//
//using namespace std;
//
//int main()
//{
//	int N;
//	int count = 0;
//	
//	cin >> N;
//	if (N < 0 || N>100)
//		return 1;
//	int originalTensPlace = N / 10; //2
//	int originalUnitPlace = N % 10; //6	
//
//	int tensPlace = N / 10; //10�� �ڸ� �� //2
//	int unitPlace = N % 10; // 1�� �ڸ� �� //6
//
//	while (1)
//	{
//		int tmp;
//				
//		tmp = tensPlace; //tmp = 2
//		tensPlace = unitPlace; //6		
//		unitPlace = tmp + unitPlace; //8
//		if (unitPlace >= 10)
//			unitPlace = unitPlace % 10;
//
//		count++;
//		if (originalTensPlace == tensPlace&&originalUnitPlace == unitPlace)			
//			break;
//		
//		
//	}
//	cout << count;
//
//}