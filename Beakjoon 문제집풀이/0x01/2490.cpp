#include <bits/stdc++.h>

using namespace std;

int arr[4];
int main() {
    for(int i = 0; i<3; ++i) {
        int cnt = 0;
        for(int j=0; j<4; ++j) {
            cin >> arr[j];
            cnt +=arr[j];
        }
        if(cnt==3)
            cout<<"A"<<"\n";
        else if(cnt==2)
            cout<<"B"<<"\n";
        else if(cnt==1)
            cout<<"C"<<"\n";
        else if(cnt==4)
            cout<<"E"<<"\n";
        else
            cout<<"D"<<"\n";
    }
   
    return 0;
}