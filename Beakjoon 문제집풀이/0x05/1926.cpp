#include <bits/stdc++.h>

using namespace std;

int board[502][502];
bool checker[502][502];

int dx[4]={1,0,-1,0};
int dy[4]={0,1,0,-1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,m;
    int picture=0;
    int mx=0;
    

    cin >> n >> m;
    for(int i=0; i<n; ++i) {
        for(int j=0; j<m; ++j) {
            cin >> board[i][j];
        }
    }

    
       
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            if(board[i][j]==0 || checker[i][j]) continue;

            picture++;
            queue<pair<int, int>> q;
            checker[i][j] = 1;
            q.push({i,j});
            int area = 0;
            while(!q.empty()){
                area++;                     
                  
                
                for(int dir=0; dir<4; dir++){
                        int nx = q.front().first + dx[dir];
                        int ny = q.front().second+ dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(checker[nx][ny] || board[nx][ny] != '1') continue;
                        checker[nx][ny] = 1;
                        q.push({nx,ny});
                    }
                    q.pop();
                }
                mx = max(mx, area);
        }
    }
 
        cout<<picture<<"\n"<<mx;
        return 0;
}