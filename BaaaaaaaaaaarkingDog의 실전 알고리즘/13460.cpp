#include <bits/stdc++.h>

using namespace std;
string board[12];
bool visit[12][12][12][12];
int d1, d2;
int r1, r2;
int b1, b2;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,m;
    cin >> n >> m;
    for(int i=0; i<n; ++i){
        cin >> board[i];    
    }
    queue<pair<pair<int,int>,pair<int,int>>> q;
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            if(board[i][j] == 'O'){
                d1 = i;
                d2 = j;
            }            
            if(board[i][j] == 'R'){
                r1=i;
                r2=j;

            }
            if(board[i][j]=='B'){
                b1=i;
                b2=j;
            }
            
        }
    }
    int count = 0;
   
    visit[r1][r2][b1][b2]=1;
    q.push({{r1,r2},{b1,b2}});
    
    
    while(!q.empty()){
        count++;
        int cur_R1 = q.front().first.first;
		int cur_R2 = q.front().first.second;
		int cur_B1 = q.front().second.first;
		int cur_B2 = q.front().second.second;
        q.pop();
        if(board[cur_R1][cur_R2] == 'O' && board[cur_R1][cur_R2] != board[cur_B1][cur_B2]){
            cout<<count;
        }
            
        
        for(int dir=0; dir<4; ++dir){
            int nR1 = cur_R1;
            int nR2 = cur_R2;
            int nB1 = cur_B1;
            int nB2 = cur_B2;     
                
            while(board[nR1][nR2]!='#' && board[cur_R1][cur_R2] != 'O'){
                nR1 = nR1 + dx[dir];
                nR2 = nR2 + dy[dir];
            }
            while(board[nB1][nB2]!='#' && board[cur_B1][cur_B2] != 'O'){
                nB1 = nB1 + dx[dir];
                nB2 = nB2 + dy[dir];
            }

            if(board[nB1][nB2]==board[nR1][nR2]){
                if(board[nR1][nR2]=='O'){
                    continue;
                }

                if(abs(nR1-cur_R1)+abs(nR2-cur_R2) > abs(nB1-cur_B1)+abs(nB2-cur_B2)){
                    nR1 = nR1-dx[dir];
                    nR2 = nR2-dy[dir];
                }
                else{
                    nB1 = nB1-dx[dir];
                    nB2 = nB2-dy[dir];
                }
                
            }            
            //if(nR1 < 0 || nR1>=n || nR2 < 0 || nR2 >= m || nB1 < 0 || nB1>=n || nB2 < 0 || nB2 >= m) continue;
            if(visit[nR1][nR2][nB1][nB2]) continue;
            visit[nR1][nR2][nB1][nB2] = 1;
            q.push({{nR1,nR2},{nB1,nB2}});
        }

    }
    
    //cout<< count ;

    return 0;
}