#include <string>
#include <iostream>
using namespace std;
/*
腾讯2017暑期实习生
把一个字符串的大写字母放在字符串后面，各个字符的相对位置不变，且不能申请额外控件
*/
int main(){

	string s;
	while(cin >> s){
		int l = s.size;
		int up=0;
		int low=0;
		for (int i = 0; i < l; ++i){
			if (s[i] >= 'a' && s[i] <= 'z')
				++low;
			else if (s[i] >= 'A' && s[i] <= 'Z')
				++up;
		}
		for (int i = l - 1; i >= low; --i){
			for (int j = 0; j <= i; ++j){
				if (s[j] >= 'A'&&s[j] <= 'Z' &&s[j] >= 'a'&&s[j] <= 'z'){
					char t = s[j];
					s[j] = s[j + 1];
					s[j + 1] = t;
				}
			}
		}
		cout << s << endl;
	}
	//system("pause");
	return 0;
}