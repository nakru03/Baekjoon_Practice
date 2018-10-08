#include <iostream>
#include <string>

using namespace std;

const int MAXSIZE = 10000;

class Stack {
private:
	int stack[MAXSIZE];
	int top;
public:
	Stack();
	void push(int elemet);
	void pop();
	void stackFull();
	void stackEmpty();
	int topcheck();
	int size();
	int topValue();
	
};
Stack::Stack()
{
	top = -1;
}


void Stack::push(int element)
{
	if (top == MAXSIZE -1)
		stackFull();
	stack[++top] = element;
}
void Stack::stackEmpty()
{
	cout << "-1" << endl;
	//exit(EXIT_FAILURE);
}
void Stack::pop()
{
	if (top<0)
		return stackEmpty();
	cout << stack[top] << endl;
	stack[top--] = 0;
}
void Stack::stackFull()
{
	cout << "stack is full" << endl;
	//exit(EXIT_FAILURE);
}
int Stack::size()
{
	return top + 1;
}
int Stack::topcheck()
{
	return top;
}
int Stack::topValue()
{
	return stack[top];
}
int main()
{
	int tc;
	cin >> tc;
	Stack st = Stack();
	for (int i = 0; i < tc; i++)
	{
		string str;
		cin >> str;
		if (str.compare("push") == 0) {
			int element;
			cin >> element;
			st.push(element);
		}

		if(str.compare("top") == 0)
		{
			if (st.topcheck()<0)
				cout << "-1" << endl;
			else
				cout << st.topValue() << endl;
		}
		if (str.compare("empty") == 0)
		{
			if (st.topcheck()<0)
				cout << "1" << endl;
			else
				cout << "0" << endl;
		}
		if (str.compare("pop") == 0)
		{
			st.pop();
		}
		if (str.compare("size") == 0)
		{
			cout<< st.size()<<endl;
		}
	}
	return 0;
}