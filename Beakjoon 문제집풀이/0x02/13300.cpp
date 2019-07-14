#include<bits/stdc++.h>

using namespace std;

int arr[2][7];
int n, k;    
int room = 0;

int main(){
    
    cin >> n >> k;
    for(int i=0; i<n; ++i){
        int s, y;
        cin >> s >> y;
        arr[s][y] ++;
    }
    for(int i=0; i<=1; ++i){
        for(int j=1; j<=6; ++j ){
        if(arr[i][j]!=0){
            if(arr[i][j]>k){
            room+=arr[i][j]/k;
            if(arr[i][j]%k!=0)
                room++;
            }
            else{
            room++;
            }

            }
        
        
        
        }
    }
    
    cout<<room;
    return 0;


}