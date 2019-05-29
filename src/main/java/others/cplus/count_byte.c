#include <stdio.h>
/*
count a byte contain how many bit was set in 1
*/
int comb(const int c){
	int count = 0;
	int i = 0;
	int cc = c;
	while(i++ < 8){
		if((cc&1) == 1){
			count++;
		}
		cc == cc >> 1;
	}
	return count;
}

int main()[
	const int c= 0xcf;
	printf("%d\n",comb(c));
	return 1;
}
