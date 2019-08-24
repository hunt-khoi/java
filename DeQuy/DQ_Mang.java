package DeQuy;

public class DQ_Mang {
	public int timChanMin_DQ(int a[], int n){
		if(n==1)
			return (a[0]%2==0)?a[0]:-1;
		else{
			int t = timChanMin_DQ(a, n-1);
			if(t==-1)
				return (a[n-1]%2==0)?a[n-1]:-1; //Remember: PT cuối cùng trong mảng là a[n-1]
			else
				if(a[n-1]%2 ==0)
					return a[n-1]<t?a[n-1]:t;
				return t;
		}	
	}
	
	public int tinhTongPTLe(int a[], int n){
		if(n==1)
			return (a[0]%2!=0)?a[0]:0;
		return (a[n-1]%2!=0)?tinhTongPTLe(a, n-1)+a[n-1]:tinhTongPTLe(a, n-1);
	}
	
	public int timVT_X(int a[], int n, int x){
		if(n>=1){
			if(a[n-1]==x)
				return n-1;
			return timVT_X(a, n-1, x);
		}
		return -1;	
	}
	
	public void sinhM1C(int a[], int n){
		for (int i=0; i<n; i++){
			a[i] = i+1;
		}
	}
	
	public void xuatM1C(int a[], int n){
		for (int i=0; i<n; i++)
			System.out.print(a[i]+" ");
	}
	
	public void copyMang(int a[], int b[]){
		for(int i=0; i<a.length; i++)
			b[i] = a[i];
	}
	
	//Bài toán hoán vị
	public void xuatHoanVi(int a[], int n){
		int t=0;
		if(n==1) {
//			for (int k=0; k<n; k++)
				xuatM1C(a, n);
		}
		else{
			int b[] = new int[a.length];
			copyMang(a, b);
			for(int j=n-1; j>=0; j--){
				
				int temp = a[n-1];
				a[n-1] = a[j];
				a[j] = temp;
				
				xuatHoanVi(a, n-1);
				System.out.println(a[n-1] + " ");
				
				copyMang(b, a);
			}
		}	
	}
	
	public int BinarySearch_DQ(int a[], int x, int left, int right){
		if(left>right)
			return -1;
		else{
			int mid = (left+right)/2;
			if(a[mid] == x)
				return mid;
			else if(a[mid] > x)
				return BinarySearch_DQ(a, x, left, mid-1);
			else
				return BinarySearch_DQ(a, x, mid+1, right);
		}
	}
	
	public int tinhTongCacChuso(int x){
		x = Math.abs(x);
		int tong = 0;
		int dau = 0;
		if(x<10)
			tong = x;
		while(x>=10){
			tong += x%10;
			x = x/10;
			dau = x;
		}
		if(dau<10)
			tong += dau;
		return tong;
	}
	/*public int tongPT_CoTongCSLaChan(int n){
		if(tinhTongCacChuso(a[0])%2 == 0)
			return a[0];
		else
			return (tinhTongCacChuso(a[n-1])%2 == 0)?a[n-1]:tongPT_CoTongCSLaChan(n-1);
	}*/


}
