#include <bits/stdc++.h>

using namespace std;
queue<int> q;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,k;
    cin >> n >> k;
    for(int i=1; i<=n; ++i){
        q.push(i);
    }
    int flag = 0;
    cout<<"<";
    while(true){
        if(flag==n){
            break;
        }
            
        for(int i=1; i<k; ++i){
            q.push(q.front());
            q.pop();            
        }
        cout<<q.front();        
        if(flag!=n-1)      
            cout<<","<<" ";
        flag++;
        q.pop();
    }
    cout<<">";
    return 0;
}