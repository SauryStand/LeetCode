#include<stdio.h>
#include<iostream>
//volatile������
int main(int argc, char *argv[])
{
	int i = 10;
	int a = i;
	printf("i=%d", a);
	//�������������þ��Ǹı��ڴ���i��ֵ�������ֲ��ñ�����֪��
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