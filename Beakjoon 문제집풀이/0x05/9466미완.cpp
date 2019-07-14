#include <bits/stdc++.h>

using namespace std;

int arr[1000002];
bool vist[1000002];

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int tc;
    cin >> tc;
    for(int i=0; i<tc; ++i){
        int n;
        cin >> n;
        for(int j=1; j<=n; ++j){
            cin>> arr[j];
        }
    }
    stack<int> s;
    vist[1] = 0;
    s.push(1);
}