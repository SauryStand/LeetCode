#include <string>
#include <iostream>
using namespace std;
/*
��Ѷ2017����ʵϰ��
��һ���ַ����Ĵ�д��ĸ�����ַ������棬�����ַ������λ�ò��䣬�Ҳ����������ؼ�
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