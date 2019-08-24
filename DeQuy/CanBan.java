package DeQuy;

public class CanBan {
		
		//Tính tổng, dãy số bằng đệ quy
		public int tinhS1_DQ(int n){
			if(n==1)
				return 1;
			return tinhS1_DQ(n-1)+n;
		}
		public int tinhS1_KhuDQ(int n){
			int s=0;
			for(int i=1; i<=n; i++)
				s += i;
			return s;
		}
		
		public double tinhS2_DQ(int n){
			if(n==1)
				return Math.sqrt(2);
			return Math.sqrt(2 + tinhS2_DQ(n-1));
		}
		public double tinhS2_KhuDQ(int n){
			double s=0;
			for(int i=1; i<=n; i++)
				s = Math.sqrt(2+ s);
			return s;
		}
		
		public double tinhS3_DQ(int n){
			if(n==1)
				return 1.0/2;
			return tinhS3_DQ(n-1) + (double)n/(n+1);
		}
		public double tinhS3_KhuDQ(int n){
			double s=0;
			for(int i=1; i<=n; i++)
				s += (double)i/(i+1);
			return s;
		}
		
		public double tinhS4_DQ(int n){
			if(n==0)
				return 1.0;
			return tinhS4_DQ(n-1) + 1.0/(2*n+1);
		}
		public double tinhS4_KhuDQ(int n){
			double s=0;
			for(int i=0; i<=n; i++)
				s += 1.0/(2*i+1);
			return s;
		}
		
		public int tinhS5_DQ(int n){
			if(n==1)
				return 2;
			return tinhS5_DQ(n-1) + n*(n+1);
		}
		public int tinhS5_KhuDQ(int n){
			int s=0;
			for(int i=1; i<=n; i++)
				s += i*(i+1);
			return s;
		}
		
		public double tinhS6_DQ(int n){
			if(n==1)
				return 1.0/6;
			return tinhS6_DQ(n-1) + 1.0/(n*(n+1)*(n+2));
		}
		public double tinhS6_KhuDQ(int n){
			double s=0;
			for(int i=1; i<=n; i++)
				s += 1.0/(i*(i+1)*(i+2));
			return s;
		}
		
		public int tinhS7_DQ(int n){
			if(n==1)
				return 1;
			return tinhS7_DQ(n-1) + n*n;
		}
		public int tinhS7_KhuDQ(int n){
			int s=0;
			for(int i=1; i<=n; i++)
				s += i*i;
			return s;
		}
		
		public int tinhS8_DQ(int n){
			if(n==1)
				return 1;
			int tong = 0;
			for(int i=1; i<=n; i++)
				tong += i;
			return tinhS8_DQ(n-1) + tong;
		}
		public int tinhS8_KhuDQ(int n){
			int s=0;
			int t=0;
			for(int i=1; i<=n; i++){
				 t += i;
				 s += t;
			}
			return s;
		}
		
		public double tinhS9_DQ(int n) {
			if(n==1)
				return -1.5;
			double tich = 1;
			for(int i=1; i<=2*n; i++)
				tich *= i;
			return tinhS9_DQ(n-1) + Math.pow(-1.0, (double)n)*((4*n-1)/tich);
		}
		//Tested
		
		public double tinhS10_DQ(int n){
			if(n==1)
				return 2/(2+Math.sqrt(3));
			double tich = 1;
			for(int i=1; i<=n+1; i++)
				tich *= i;
			return tinhS10_DQ(n-1) + (n*tich)/((n+1)+Math.sqrt(n+2));
		}
		//Tested
		
		public double tinhS11_DQ(int n) {
			if(n==1)
				return (1+Math.sqrt(3))/(2+Math.sqrt(6));
			double tich = 1;
			for(int i=1; i<=n+2; i++)
				tich *= i;
			return tinhS11_DQ(n-1) + (n+Math.sqrt((2*n)+1))/((n+1)+Math.sqrt(tich));
		}
		//Tested
		public int tinhFibonacci(int n){
			if(n<=2)
				return 1;
			return tinhFibonacci(n-1) + tinhFibonacci(n-2);
		}
		public void xuatDayFibo(int n) {
			for(int i=1; i<=n; i++)
				System.out.print(tinhFibonacci(i)+" ");
			System.out.println();
		}
		
		public int timSoFiboMax_NhoHonN(int n) {
			int i=1;
			int max = -1;
			while(tinhFibonacci(i)<n) {
				max = tinhFibonacci(i);
				i++;	
			}
			return max;
		}
		
		public int tinhXn(int n){
			if(n == 0)
				return 1;
			return tinhXn(n-1) + tinhYn(n-1);
		}
		public int tinhYn(int n){
			if(n == 0)
				return 0;
			return 3*tinhXn(n-1) + 2*tinhYn(n-1);
		}
		
		public int tinhAn(int n) {
			if(n == 1)
				return 1;
			int s = 0;
			for(int i=0; i<n; i++)
				s += n*tinhAn(i);
			return s;
		}
		
		public int tinhSH_Yn(int n) {
			if(n == 1)
				return 1;
			else if(n == 2)
				return 2;
			else if(n == 3)
				return 3;
			return tinhSH_Yn(n-1) + 2*tinhSH_Yn(n-2) + 3*tinhSH_Yn(n-3);
		}
		public int tinhSH_YnKhuDQ(int n) {
			int yn = 0;
			int y1 = 1, y2 = 2, y3 = 3;
			if(n == 1)
				yn = 1;
			else if(n == 2)
				yn = 2; 
			else if(n == 3)
				yn = 3;
			else{
				for(int i=4; i<=n; i++) {
					yn = y3 + 2*y2 + 3*y1;
					y1 = y2;
					y2 = y3;
					y3 = yn;
				}
			}
			return yn;
		}
		
		//Các hàm đệ quy khác
		public int demSoChuSo(int n) {
			if(n<10)
				return 1;
			return demSoChuSo(n/10) + 1;
		}
		
		//--------------------------------------------------
		public int demSoChuSoChan(int n) {
			if(n==0)
	              return 0;
			else{
	              if((n%10) %2 ==0)
	                  return 1+demSoChuSoChan(n/10);
	              else
	                  return demSoChuSoChan(n/10);
			}
	                
	    }
		
		//--------------------------------------------------
		public int soHe2(int n){
		     if(n<=1)
		          return n;
		     return soHe2(n/2)*10+n%2;
		 }
		//Tested
		public String[] soHe2(int n, String[] a, int i) {
			if(n<=1) {
				a[0] = Integer.toString(n); 
				return a;
			}
			else {
				a[i-1] = Integer.toString(n%2);
				return soHe2(n/2, a, i-1);
			}
		}
		//Tested
		
		//--------------------------------------------------
		public String[] soHe16(int n, String[] a, int i) {
			String s;
			if(n<=15) {
				switch (n) {
					case 10: s = "A"; break;
					case 11: s = "B"; break;
					case 12: s = "C"; break;
					case 13: s = "D"; break;
					case 14: s = "E"; break;
					case 15: s = "F"; break;
					default: s = Integer.toString(n);
						break;
				}
				a[0] = s;
				return a;
			}
			else {
				switch (n%16) {
					case 10: s = "A"; break;
					case 11: s = "B"; break;
					case 12: s = "C"; break;
					case 13: s = "D"; break;
					case 14: s = "E"; break;
					case 15: s = "F"; break;
					default: s = Integer.toString(n%16);
						break;
				}
				a[i-1] = s;
				return soHe16(n/16, a, i-1);
			}
		}
		//Tested
		

}
