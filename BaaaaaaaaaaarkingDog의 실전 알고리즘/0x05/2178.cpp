#include<bits/stdc++.h>

using namespace std;

string board[102];
int dist[102][102];
int n,m;
int dx[4]={1,0,-1,0};
int dy[4]={0,1,0,-1};

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for(int i=0; i<n; ++i){        //string 형 입력방식
        cin>> board[i];        
    }

    for(int i=0; i<n; ++i){         //dist를 -1로 초기화를 통한 중복방지
        for(int j=0; j<m; ++j){
            dist[i][j] = -1;
        }
    }
    
    queue<pair<int, int>> Q;
    dist[0][0] = 0;
    Q.push({0,0});
    while(!Q.empty()){
        for(int dir=0; dir<4; ++dir){
            int nx = Q.front().first + dx[dir];
            int ny = Q.front().second + dy[dir];
            if(nx < 0 || ny < 0 || nx>=n || ny>=m) continue;
            if(board[nx][ny]=='0' || dist[nx][ny] >= 0) continue;
            dist[nx][ny] = dist[Q.front().first][Q.front().second]+1;                 
            Q.push({nx, ny});
        }
       Q.pop();   
    }
    cout<<dist[n-1][m-1]+1;



}