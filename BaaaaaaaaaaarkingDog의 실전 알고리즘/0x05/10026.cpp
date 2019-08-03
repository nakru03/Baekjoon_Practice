#include <bits/stdc++.h>

using namespace std;

string board[102];
bool visit[102][102];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n;


int BFS(queue<pair<int, int>> &q, char colorCheck, bool colorBlind){
    while(!q.empty()){
        int cur_X = q.front().first;
        int cur_Y = q.front().second;
        q.pop();
        for(int dir=0; dir<4; ++dir){
            int nx = cur_X + dx[dir];
            int ny = cur_Y + dy[dir];
            if(nx<0 || nx>=n || ny < 0 || ny >= n) continue;
            if(colorCheck == 'R' && !colorBlind){
                if(board[nx][ny] != 'R' || visit[nx][ny]) continue;
                visit[nx][ny] = 1;
                q.push({nx, ny});
            }
            if(colorCheck == 'G' && !colorBlind){
                if(board[nx][ny] != 'G' || visit[nx][ny]) continue;
                visit[nx][ny] = 1;
                q.push({nx, ny});
            }
            if(colorCheck == 'B'){
                if(board[nx][ny] != 'B' || visit[nx][ny]) continue;
                visit[nx][ny] = 1;
                q.push({nx, ny});
            }
            if(colorCheck =='R' && colorBlind){
                if(board[nx][ny] == 'B' || visit[nx][ny]) continue;
                visit[nx][ny] = 1;
                q.push({nx, ny});
            }
            if(colorCheck =='G' && colorBlind){
                if(board[nx][ny] == 'B' || visit[nx][ny]) continue;
                visit[nx][ny] = 1;
                q.push({nx, ny});
            }
        }
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    bool colorBlind=0;
    cin >> n;
    for(int i=0; i<n; ++i){
        cin>>board[i];
    }
    queue<pair<int, int>> q;
    int area = 0;
    int blindArea = 0;

    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(visit[i][j]) continue;
            
            area ++;

            visit[i][j] = 1;
            q.push({i,j});
            BFS(q, board[i][j], false);
        }
    }
    fill(&visit[0][0], &visit[101][102], 0);
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(visit[i][j]) continue;
            
            blindArea ++;
            visit[i][j] = 1;
            q.push({i,j});
            BFS(q, board[i][j], true);
        }
    }
    cout<<area<<" "<<blindArea<<"\n";
    
    return 0;
}