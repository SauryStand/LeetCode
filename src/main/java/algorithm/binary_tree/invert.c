#include "stdafx.h"
#include<stdio.h>
#include<string.h>

//���ַ�����ch��n���ַ�����
void invert(char *ch,int n)
{
	int i;
	char temp;
	for(i=0;i<n/2;i++)
	{
		temp=ch[i];
		ch[i]=ch[n-1-i];
		ch[n-1-i]=temp;
	}
}

//�ֽ��ַ���ȫ�����ã������ú���ַ��������ַ��������á������ַ����Ļ�������Ϊ�Ƿ��пո�
void wordInvertInSentence(char*ch)
{
	int i=0;
	int len;
	len=strlen(ch);
	invert(ch,len);//���ַ���ȫ������
	while(ch[i]!='\0')//���ַ�����ʼλ�ÿ�ʼ������ֱ�����ʵ�������
	{
		i=0;
		while(ch[i]!=' '&&ch[i]!='\0'){i++;}//�����ǰ���ַ���Ϊ�ո���û�з��ʵ�������־����ָ����ƣ�ֱ����ǰ�ַ�Ϊ�ո�
	    invert(ch,i);//�ַ���ch��i���ַ���������
		if(ch[i]!='\0')//���û�з��ʵ�������־��Ҫ�����ո��ַ������������¸�����
	        ch=ch+i+1;
		else           //�����ǰ�ַ��Ѿ��ǽ�����־�ˣ�����Ҫ�������ո��ַ�����ѭ��������
			ch=ch+i;
	}
}

void main()
{
    char str[]="i am Sundy, i come from tianjin.,";//
    printf("***********************\n");//
    printf(" ��һ�仰��ĵ��ʽ��е����㷨 \n");//
    printf("***********************\n");
    printf("%s\n\n",str);wordInvertInSentence(str);
    printf("%s",str);
    printf("\n");
}