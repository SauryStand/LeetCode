#include <iostream>
#include <pthread.h>
using namespace std;
#define NUM_PTHREAD 5//pthread
void* say_hi(void* args){
	cout<<"hello world,mutil phread"<<endl;//<<endl;
}
int main(){
	pthread_t tids[NUM_PTHREAD];
	for(int i = 0 ; i < NUM_PTHREAD-1 ; i++){

		int ret = pthread_create(&tids[i],NULL,say_hi,NULL);
		if(ret != 0)
			//create thread
			cout<<"pthread_create error:error_code="<<ret<<endl;
	}
	pthread_exit(NULL);
}
