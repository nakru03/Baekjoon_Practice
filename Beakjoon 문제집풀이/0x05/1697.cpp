#include <bits/stdc++.h>

using namespace std;

int arr[100002];
bool vist[100002];
int N, K;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;

    queue<pair<int, int>> Q;
    vist[N]=1;
    Q.push({N,0});    
    
    while(!Q.empty()){
        int cur = Q.front().first;
        int time = Q.front().second;
        Q.pop();

        if(cur == K){
            cout<<time;            
        }
          
        if(cur+1<100001 && !vist[cur+1]){
            vist[cur+1] = 1;
            Q.push({cur+1,time+1});
        }
        if(cur-1>=0 && !vist[cur-1]){
            vist[cur-1] = 1;
            Q.push({cur-1,time+1});
        }
        if(cur*2<100001 && !vist[cur*2]){
            vist[cur*2] = 1;
            Q.push({cur*2,time+1});
        }
            
    }
    return 0;
    
}
    
    
