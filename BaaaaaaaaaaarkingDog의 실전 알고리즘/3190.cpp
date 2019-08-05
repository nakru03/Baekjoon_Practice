#include <bits/stdc++.h>

using namespace std;
vector<int> appleX;
vector<int> appleY;
vector<int> turntime;
vector<char> dir;
int board[102][102];
int dx[]={1,0,-1,0};
int dy[]={0,1,0,-1};
vector<pair<int,int> > snake;

int n;
int main(){
    ios::sync_with_stdio(0);
    
    cin >> n;
    int k;
    cin >> k;
    for(int i=0; i<k; ++i){
        int x;
        int y;
        cin >> x >> y;
        appleX.push_back(x);
        appleY.push_back(y);
    }
    int l;
    for(int i=0; i<l; ++i){
        int t;
        char d;
        cin >> t >> d;
        turntime.push_back(t);
        dir.push_back(d);
    }
    int di = 1;
    board[0][0] = 1;
    timetmp =0;
    while(1){
        int nx =snake[snake.size()-1].first+dx[di];
        int ny =snake[snake.size()-1].second+dy[di];
        count ++;
        if(count == turntime[timetmp]){
            if()
        }
        if(nx>=n || ny>=n || nx<0 || ny<0){            
            break;
        }           
        if(board[nx][xy]==1)
            break;
        if(){
            curX=curX+1;
        }
    }
}