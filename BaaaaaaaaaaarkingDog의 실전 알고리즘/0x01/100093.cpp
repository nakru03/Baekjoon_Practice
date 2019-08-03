#include<bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    long long a,b;
    cin >> a >> b;
    if(a-b>1) {
        cout<<a-b-1<<"\n";
        for(long long i=b+1; i<a-1; ++i) {
            cout<<i<<" ";
        }
        cout<<a-1<<"\n";
    }
    else if(b-a > 1) {
        cout<<b-a-1<<"\n";
        for(long long i=a+1; i<b-1; ++i) {
            cout<<i<<" ";
        }
        cout<<b-1<<"\n";

    }
    else {
        cout<<0<<"\n";
    }
    

    return 0;
}