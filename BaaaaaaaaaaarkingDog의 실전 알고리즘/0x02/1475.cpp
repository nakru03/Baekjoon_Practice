#include <bits/stdc++.h>

using namespace std;
int check[10];
int cnt = 1;

int main(){
    string n;
    cin >> n;
    int cnt=-1;
    for(int i=0; i<n.size(); ++i){        
        int tmp = n[i]-48;
        
        if(n[i]== '9'){
            if(check[9]>check[6])
                check[6]++; //6 = 1
            else
            {
                check[9]++;
            }
            
        }
        else if(n[i] == '6' ){
            if(check[6]>check[9])
                check[9]++; //6 = 1
            else
            {
                check[6]++;
            }
            
        }
        else{
            
             check[tmp]++;
             
        }
        cnt = max(cnt,check[tmp]);   
    }
    cout<<cnt;
}