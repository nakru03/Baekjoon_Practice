#include <bits/stdc++.h>

using namespace std;

int main() {
    int sum = 0;
    int min = 101;
    for(int i=0; i<7; ++i) {
        int n;
        cin >> n;
        if( n%2 == 1) {
            
            sum+=n;
            if(min>n)
                min = n;
        }
            
    }
    
    
    if(sum!=0){
        cout<<sum<<"\n";
        cout<<min<<"\n";
    }
    else
        cout<<-1<<"\n";

}