#include <bits/stdc++.h>

using namespace std;

int board [52][52];
bool vist [52][52];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int n, m, tc, k; //가로 세로 테스트케이스 배추 위치
int p1, p2; // 배추 좌표

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin>> tc;

    for(int i=0; i<tc; ++i){
        cin >> n >> m >> k;

        

        for(int j=0; j<k; ++j){
            cin >> p1 >> p2;
            board[p1][p2] = 1;
        }
   

        queue<pair<int,int>> Q;
        int bug = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(board[i][j] == 0 || vist[i][j]) continue;
            
                bug++;
                vist[i][j] = 1;
                Q.push({i,j});
            
            
                while(!Q.empty()){
                
                    for(int dir=0; dir<4; ++dir){
                        int nx = Q.front().first + dx[dir];
                        int ny = Q.front().second + dy[dir];
                        if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                        if(board[nx][ny] != 1 || vist[nx][ny]) continue;
                        vist[nx][ny] = 1;
                        Q.push({nx,ny});

                    }
                    Q.pop();
                }
            }
        }
        cout<<bug<<"\n";
        for(int i=0; i<52; ++i){
            fill(board[i], board[i]+52, 0);
            fill(vist[i], vist[i]+52, 0);
        }
    }
    return 0;
}