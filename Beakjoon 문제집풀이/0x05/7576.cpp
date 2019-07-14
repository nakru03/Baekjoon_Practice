#include <bits/stdc++.h>

using namespace std;
int board[1002][1002];
bool vist[1002][1002];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int m,n;
bool flag;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    queue<pair<int, int>> Q;
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            cin>>board[i][j];

            if(board[i][j]==1){
                vist[i][j]=1;
                Q.push({i,j});                      
            }
        }
    }    

    int day =0;
    while(!Q.empty()){
        day = day+1;         
        int cur1 = Q.front().first;
        int cur2 = Q.front().second;
        
        Q.pop();
        for(int dir=0; dir<4; ++dir){
                int nx = cur1 + dx[dir];
                int ny = cur2 + dy[dir];
                if(nx<0 || nx>=n || ny <0 || ny>=m) continue;
                if(board[nx][ny] == -1 || board[nx][ny]) continue;
                board[nx][ny] = 1;
                Q.push({nx,ny});
                
        }
            
    }
    cout<<day;
    return 0;
}