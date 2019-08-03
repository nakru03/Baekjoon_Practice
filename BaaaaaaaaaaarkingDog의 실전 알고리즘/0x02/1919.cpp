#include<bits/stdc++.h>

using namespace std;
int alpha[26];
int alpha2[26];

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    string word1;
    string word2;
    int res = 0;

    cin >> word1;
    cin >> word2;

    for(int i=0; i<word1.size(); ++i){
        alpha[word1[i]-'a']++;
    }
    for(int i=0; i<word2.size(); ++i){
        alpha2[word2[i]-'a']++;
    }
    for(int i=0; i<26; ++i){
        if(alpha[i]!=alpha2[i])
            res += max(alpha[i],alpha2[i])-min(alpha[i],alpha2[i]);        
        
    }
    cout<<res;
}