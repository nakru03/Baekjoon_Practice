#include <bits/stdc++.h>

using namespace std;
vector<int> v;

int youngsik (vector<int> &v) {
    int total = 0;
    for(int i=0; i<v.size(); ++i){
        int tmp = 0;    
        tmp = v[i]/30;
        total += tmp*10;
        if(v[i]-tmp*10 != 0)
            total += 10;
    }
    return total;
}

int minsik (vector<int> &v) {
    int total = 0;
    for(int i=0; i<v.size(); ++i){
        int tmp = 0;    
        tmp = v[i]/60;
        total += tmp*15;
        if(v[i]-tmp*10 != 0)
            total += 15;
    }
    return total;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int y, m;

    int tc;
    cin >> tc;
    for(int i=0; i<tc; ++i) {
        int n;
        cin >> n;
        v.push_back(n);
    }
    y = youngsik(v);
    m = minsik(v);

    if(y<m)
        cout<<"Y "<<y<<"\n";
    else if(y==m)
        cout<<"Y "<<"M "<<y<<"\n";
    else
        cout<<"M "<<m<<"\n";
    
    return 0;

}
