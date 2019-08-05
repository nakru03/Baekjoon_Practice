#include <bits/stdc++.h>

using namespace std;
int board[102][102];
bool visit[102][102];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
vector<int> v;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m,n,k;
    int p1, p2, p3, p4;

    cin >> m >> n >> k;
    for(int i=0; i<k; ++i){
        cin >> p1 >> p2 >> p3 >> p4;
        for(int j = p1; j<p3; ++j){
            for(int l = p2; l<p4; ++l){
                board[l][j] = 1;                
            }
        }
    }

    queue<pair<int,int>> q;
    int area=0;
    for(int i=0; i<m; ++i){
        for(int j=0; j<n; ++j){
            if(board[i][j]==1 || visit[i][j]) continue;
            area++;
            int bi = 0;
            visit[i][j] = 1;
            q.push({i,j});

            while(!q.empty()){
                bi++;
                int cur1 = q.front().first;
                int cur2 = q.front().second;
                q.pop();
                for(int dir=0; dir<4; ++dir){
                    int nx = cur1 + dx[dir];
                    int ny = cur2 + dy[dir];
                    if(nx<0 || nx>=m || ny < 0 || ny>=n)continue;
                    if(board[nx][ny]==1 || visit[nx][ny]) continue;
                    visit[nx][ny] = 1;
                    q.push({nx,ny});
                }
                
            }
            v.push_back(bi);
        }
    }
    sort(v.begin(), v.end());
    cout<<area<<"\n";
    for(int i=0; i<v.size(); ++i){
        cout<<v[i]<<"\n";
    }

    return 0;
}