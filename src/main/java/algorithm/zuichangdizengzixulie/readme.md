最长递增子序列问题---动态规划
https://www.cnblogs.com/coffy/p/5878915.html

求最长递增子序列的那个序列
http://kubicode.me/2015/07/19/Algorithm/Longest/

public static void main(String[] args) {
	int[] a={3,18,7,14,10,12,23,41,16,24};
	//存放当前索引位置上以它为起点可能存在的最长子序列个数
	int[] f=new int[a.length];
	int maxIndex=-1;
	int maxLen=-1;
	for(int i=a.length-1;i>=0;i--){
		f[i]=1;
		if(i==a.length-1)
			continue;
		for(int j=i+1;j<a.length;j++){
			if(a[i]<a[j] && f[i]<=f[j]){
				f[i]=f[j]+1;//计算当前以当前位置为索引起始点的最长自增字符串个数
			}
		}
		if(f[i]>maxLen){
			maxLen=f[i];//得到最长的标志
			maxIndex=i;
		}
	}
	for(int i=maxIndex;i<a.length;i++){
		if(f[i]==maxLen){
			System.out.println(a[i]);
			maxLen--;
		}
	}