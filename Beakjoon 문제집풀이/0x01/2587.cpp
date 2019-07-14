#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);   

    vector<int> arr;
    int sum=0;

    for(int i=0; i<5; ++i) {
        int n;
        cin >> n;
        sum += n;
        arr.push_back(n);
    }
    sort(arr.begin(), arr.end());

    
    cout<<sum/5<<"\n";
    cout<<arr[2]<<"\n";

}