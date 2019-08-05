#include <bits/stdc++.h>

using namespace std;

void swap(int& a, int& b) {
    int tmp = a;
    a = b;
    b = tmp;

}
int arr[3];
int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    for(int i=0; i<3; ++i) {
        
        cin >> arr[i];
    }
    if(arr[0]>arr[1])
        swap(arr[0],arr[1]);
    if(arr[1]>arr[2])
        swap(arr[1], arr[2]);
    if(arr[0]>arr[1])
        swap(arr[0], arr[1]);
    
    for(int i=0; i<3; ++i)
        cout<<arr[i]<<"\n";  

}