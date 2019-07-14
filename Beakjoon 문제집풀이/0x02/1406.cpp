#include <bits/stdc++.h>

using namespace std;

list<char> link;
string s;
int tc;
list<char>::iterator cursor;
list<char>::iterator itor;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);

    
    

    cin >> s;

    for(int i=0; i<s.size(); ++i) {
        link.push_back(s[i]);
    }

    cin >> tc;

    cin.ignore(); //개행 값이 남아 이후의 getline에 영향을 미침 ignore을 통해 무시
    cursor = link.end();

    for(int i=0; i<tc; i++) {
        string comm;
        getline(cin, comm);
        if (comm[0] == 'L') {
            if(cursor == link.begin()) continue;
            else cursor--;
        }
        if (comm[0] == 'D')  {
            if(cursor == link.end()) continue;
            else cursor++;
            
        }
        if (comm[0] == 'B') {
            if(cursor==link.begin()) continue;
            else{
                cursor--;                
                cursor = link.erase(cursor);      
            }
                      
        }
        if (comm[0] == 'P') {
            if(cursor==link.begin()){
                link.push_front(comm[2]);
            }
            else if(cursor==link.end())
                link.push_back(comm[2]);
                
            else{
                link.insert(cursor, comm[2]);
            }
               
        }
    }
    
    for(itor=link.begin(); itor!=link.end(); ++itor)
    {
         cout<<*itor;
    }
       

    return 0;
}