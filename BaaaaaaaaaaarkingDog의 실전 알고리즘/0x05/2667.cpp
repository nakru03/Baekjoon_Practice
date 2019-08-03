#include <bits/stdc++.h>

using namespace std;
string board[27];
bool checker[27][27];
vector <int> v;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    for(int i=0; i<N; ++i){
        cin>>board[i];
    } // board 삽입

    queue<pair<int, int>> q;
    int danji = 0;

    for(int i=0; i<N; ++i){
        for(int j=0; j<N; ++j){
            int house = 0;
            if(board[i][j]!='1' || checker[i][j]) continue;            
            checker[i][j] = 1;
            q.push({i,j});
            danji ++;

            while(!q.empty()){
                house ++;
                int cur1 = q.front().first;
                int cur2 = q.front().second;
                q.pop();
                for(int dir=0; dir<4; ++dir){
                    int nx = cur1 + dx[dir];
                    int ny = cur2 + dy[dir];
                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(board[nx][ny]=='0' || checker[nx][ny]) continue;
                    checker[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
            v.push_back(house);
        }
    }
    cout<<danji<<"\n";
    sort(v.begin(),v.end());
    for(int i=0; i<v.size(); ++i){
        cout<<v[i]<<"\n";
    }
    return 0;
}