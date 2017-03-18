#include <iostream>
using namespace std;
#define DEBUG
#ifdef DEBUG
	inline void msg(){
		cout<<"Iam testing"<<endl;
	}
#else
inline void msg(){}
#endif
int main(){
	msg();
	system("pause");
	return 0;
}