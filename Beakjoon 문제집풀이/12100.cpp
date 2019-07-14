#include <bits/stdc++.h>

using namespace std;
int board[22][22];
int tmp[22][22];
int n;

void shitf(int type){
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            tmp[i][j] = board[i][j];
        }
    }
void dir(int num){
    for(int i=0; i<n; ++i){
        for(int j=0; j<n-1; j++){
            if(board[j][i] == 0)continue;

            for(int k = i+1; k<n; ++k){
                if(board[k][i]==0)continue;

                else{
                    if(board[j][i]==board[k][i]){
                        board[]
                    }

            }
        }

    }

}
    
}
int main(){
    ios::sync_with_stdio(0);
    
    cin >> n;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> board[i][j];
        }
    }

}