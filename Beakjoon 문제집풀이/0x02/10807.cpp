#include <bits/stdc++.h>

using namespace std;

vector<int> arr;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int tc, searchNum;
    int res=0;

    cin >> tc;

    for(int i=0; i<tc; ++i) {
        int n;
        cin >> n;
        arr.push_back(n);
    }
    
    cin >> searchNum;

    for(int i=0; i<arr.size(); ++i) {
        if(arr[i]==searchNum)
            res++;
    }
    cout<<res<<"\n";
    return 0;
}