#include <bits/stdc++.h>

using namespace std;


int dx[8] = {1, 2, 2, -1, 1, -2, -2,-1};
int dy[8] = {2, 1, -1, -2, -2, 1, -1, 2};

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int tc;
    cin >> tc;
    for(int i=0; i<tc; ++i){
        int board[302][302]={0,};
        bool visit[302][302]={0,};
        int l;
        cin >>l;
        int x1, y1;
        cin >> x1 >> y1;
        int x2, y2;
        cin >> x2 >> y2;
    
        queue<pair<int, int>> q;
        visit[x1][y1] = 1;
        q.push({x1, y1});

        while(!q.empty()){
            int cur_X = q.front().first;
            int cur_Y = q.front().second;
            q.pop();
            if(cur_X == x2 && cur_Y == y2)
                break;

            for(int dir=0; dir<8; dir++){
                int nx = cur_X + dx[dir];
                int ny = cur_Y + dy[dir];
                if(nx<0 || nx>=l || ny<0 || ny>=l) continue;
                if(visit[nx][ny])continue;
                visit[nx][ny] = 1;
                board[nx][ny] = board[cur_X][cur_Y]+1;
                q.push({nx,ny});                

            }

        }
        cout<<board[x2][y2]<<"\n";
        fill(&board[0][0], &board[303][303],0);
    }

}