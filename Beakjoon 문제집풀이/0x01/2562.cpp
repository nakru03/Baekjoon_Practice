#include <bits/stdc++.h>
#include <vector>
using namespace std;

int main() {
    vector<int> arr;
    for(int i=0; i<9; ++i) {
        int n;
        cin >> n;
        arr.push_back(n);
    }
    cout<<*max_element(arr.begin(), arr.end())<<"\n";
    int index = max_element(arr.begin(), arr.end()) - arr.begin();
    cout << index+1<<"\n";

}