#include<stdio.h>
#include<iostream>
//volatile的作用
int main(int argc, char *argv[])
{
	int i = 10;
	int a = i;
	printf("i=%d", a);
	//下面汇编语句的作用就是改变内存中i的值，但是又不让编译器知道
	__asm
	{
		mov dword ptr[ebp - 4], 20h
	}
	int b = i;
	printf("i=%d", b);
	system("pause");
}


/*

#include<stdio.h>
void main(int argc,char *argv[])
{
volatile int i = 10;
int a = i;
printf("i=%d",a);
__asm
{
`    mov dword ptr[ebp-4],20h
}
int b = i;
printf("i=%d",b);
}


*/