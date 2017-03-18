#include <iostream>
using namespace std;
//it means 
int main(){
	char a[]="hello_world";//this line can not compile
	a[0] = 'x';
	char* q = a;
	q[0] = 'b';
	char *p = "hello";//这个也是错的，不是吧整个字符串转入指针变量，而是把存放在该字符串的首地址装入指针变量
	p[0] = 'y';
	cout<<"first str:"<<q<<endl;
	cout<<"second str:"<<p<<endl;
}
