#include <bits/stdc++.h>

using namespace std;



int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int tc;
	cin >> tc;

	for (int i = 0; i<tc; ++i) {
		list<char> l;
		list<char>::iterator cursor = l.begin();
		string s;
		cin >> s;
		for (int j = 0; j<s.size(); ++j) {
			if (s[j] == '<') {
				if (cursor == l.begin())
					continue;
				else
					cursor--;
			}
			else if (s[j] == '>') {
				if (cursor == l.end())
					continue;
				else
					cursor++;
			}
			else if (s[j] == '-') {
				if (cursor == l.begin()) //begin일 때 erase 하면 runtime error
					continue;
				cursor--;
				cursor = l.erase(cursor);
			}
			else {
				if (cursor == l.begin())
					l.push_front(s[j]);
				else if (cursor == l.end())
					l.push_back(s[j]);
				else {
					l.insert(cursor, s[j]);
				}

			}
		}
		list<char>::iterator itor;
		for (itor = l.begin(); itor != l.end(); ++itor) {
			cout << *itor;
		}
		cout << "\n";
	}

	return 0;

}