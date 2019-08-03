#include <bits/stdc++.h>

using namespace std;
    


int main(){
    queue<int> q;
    string s;
    int n;
    cin >> n;

    for(int i=0; i<n; ++i){
        cin >> s;
        if(!s.compare("push")){
            int number;
            cin >> number;
            q.push(number);
        }
        if(!s.compare("front")){
            if(q.empty()){
                cout<<"-1"<<"\n";
            }
            else cout<<q.front()<<"\n";
        }
        if(!s.compare("back")){
            if(q.empty()){
                cout<<"-1"<<"\n";
            }
            else cout<<q.back()<<"\n";
        }
        if(!s.compare("size")){
            cout<<q.size()<<"\n";
        }
        if(!s.compare("empty")){
            cout<<q.empty()<<"\n";
        }
        if(!s.compare("pop")){
            if(q.empty()){
                cout<<"-1"<<"\n";
            }
            else{
                cout<<q.front()<<"\n";
                q.pop();
            }
                        
        }

    }    
    return 0;
}
