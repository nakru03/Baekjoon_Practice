#include <bits/stdc++.h>

using namespace std;

int n, m;

void func(int *arr, bool *isused, int k){
    if(k == m){
        for(int i = 0; i<m-1; ++i){
            if(arr[i]>arr[i+1]) return ;
        }
        
        for(int i = 0; i<m; ++i){
            cout<<arr[i]+1<<' ';
        }
            
            cout<<"\n";
            return;

    }
    for(int i=0; i<n; ++i){
        if(!isused[i]){
            arr[k] = i;
            isused[i] = 1;
            func(arr, isused, k+1);
            isused[i] = 0;
        }
    }



}

int main(){
    ios::sync_with_stdio(0);
    cin >> n >> m;
    int arr[m] = {};
    bool isused[n] ={};
    func(arr, isused, 0);
}