#include <iostream>
using namespace std;

void quick_sort(int *nums , int p , int r);
int partition(int *nums,int p,int r);//���η�
void show(int *str , int size);

int main(){
	int size , *str;
	while(1){
		cout<<"please enter string nums size:"<<endl;
		cin>>size;
		if(size > 0){
			cout<<"enter numbers: "<<size<<" waiting for sort"<<endl;
			str = (int*)malloc(size + sizeof(int));//a = new int[size];
			for(int i = 0 ; i < size ; i++){
				cin>>str[i];
			}
			quick_sort(str,0,size-1);

		}else{
			cout<<"wrong input!"<<endl;
		}

		show(str,size);
	}
	return 0;
}


void quick_sort(int *nums , int p , int r){
	int q;//����
	if(p < r){
		q = partition(nums,p,r);
		quick_sort(nums,p,q-1);
		quick_sort(nums,q+1,r);
	}
}
//���η������þ��ǽ������ΪA[p..q-1] ��A[q+1..r]
int partition(int *nums , int p , int r){
	int x, i , j , temp;
	x = nums[r];//��ֵ
	//��ʼ��ʱ��i �ƶ������������
	i = p - 1;
	for(j = p ; j <= r-1 ; j++){
		if(nums[j] <= x){
			i += 1;
			temp = nums[i];//exchange
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
	temp = nums[i+1];
	nums[i+1] = nums[r];
	nums[r] = temp;

	return i+1;//����qֵ
}

void show(int* nums,int size){
	cout<<"after sort:"<<endl;
	for(int i = 0 ; i < size ; i++){
		cout<<nums[i]<<" ";
	}
	cout<<endl;
}

