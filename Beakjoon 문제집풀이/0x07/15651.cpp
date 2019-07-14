#include <bits/stdc++.h>

using namespace std;
int m,n;
void func(int arr[], int k){
    if(k==m){
        for(int i=0; i<m; ++i)
            cout<<arr[i]+1<<" ";
        cout<<"\n";
        return;
    }
    for(int i=0; i<n; ++i){
        arr[k] = i;
        func(arr, k+1);
    }
}

int main(){
    cin >> n >> m;
    int arr[m]={};
   // bool isused[n]={};
    func(arr, 0);

}