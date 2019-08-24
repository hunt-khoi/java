package ChiaDeTri;
public class BigNum {
	final int MAX = 15;
	
	int sign; 					//dấu của bignum
	int[] value = new int[MAX];	//mảng chứa giá trị 1 chữ số của bignum
	int sopt; 					//số chữ số (tối đa là 15 cữu số)
	
	public BigNum catTrai(int vt) {
		BigNum left = new BigNum();
		left.sign = 1;
		int k = 0;
		if(sopt <= 2) {	//TH số cần cắt chỉ có 2 chữ số
			left.sopt = 1;
			left.value[0] = value[0];
		}
		else {
			for(int i=0; i<=vt; i++)
			{
				left.value[k] = value[i];
				k += 1;
			}
			left.sopt = k;
		}
		return left;
	}
	
	public BigNum catPhai(int vt) {
		BigNum right = new BigNum();
		right.sign = 1;
		int k = 0;
		if(sopt <= 2) {	//TH số cần cắt chỉ có 2 chữ số
			right.sopt = 1;
			right.value[0] = value[1];
		}
		else {
			for(int i=vt+1; i<sopt; i++)
			{
				right.value[k] = value[i];
				k += 1;
			}
			right.sopt = k;
		}
		return right;
	}
	
	public BigNum multiTwoBigNum(BigNum X, BigNum Y) {
		BigNum A, B, C, D = new BigNum();
		BigNum m1, m2, m3, m4 = new BigNum();
		BigNum n1, n2, n3 = new BigNum();
		BigNum p1, p2, p3 = new BigNum();
		
		BigNum K = new BigNum();
		K.sopt = 1;
		K.value[0] = 0;
		
		int vtcatx = X.sopt/2;
		int vtcaty = Y.sopt/2;
		
		BigNum kq = new BigNum();
		kq.sign = X.sign*Y.sign;
		
		if(X ==  null || Y == null || X.sopt == 0 || Y.sopt == 0)
			return null;
		else if(X == K || Y == K)
			return K;
		else{
			//BigNum X, Y cùng 1 chữ số
			if(X.sopt == 1 && Y.sopt == 1){
				int t = X.value[0]*Y.value[0];
				Integer s = new Integer(0); //???
				//Đổ tích của 2 BigNum vào mảng value của BigNum kết quả
				convertNumToArr(t, kq.value);
				if(t>9)
					kq.sopt = 2; //max là 9*9=81 chỉ có 2 chữ số
				else 
					kq.sopt = 1;
			}
			else
			{
				//BigNum X có 1 chữ số
				if(X.sopt ==1 && Y.sopt >1) {
					A = X;
					//B = null;
					//Nếu gán B = null sẽ dính exception con trỏ null
					B = K;
					C = Y.catTrai(vtcaty);
					D = Y.catPhai(vtcaty);
				}
				//BigNum Y có 1 chữ số
				else if(Y.sopt ==1 && X.sopt>1){
					A = X.catTrai(vtcatx);
					B = X.catPhai(vtcatx);
					C = Y;
					//D = null;
					D = K;
				}
				else {
					A = X.catTrai(vtcatx);
					B = X.catPhai(vtcatx);
					//X = A*10^(B.sopt) + B
					//VD: 1234 = 123*10 + 4
					
					C = Y.catTrai(vtcaty);
					D = Y.catPhai(vtcaty);
					//Y = C*10^(D.sopt) + D
				}
				//XY = A*C*10^(B.sopt+D.sopt) + A*D*10^(B.sopt) 
				//     + B*C*10^(D.sopt) + B*D
				
				m1 = multiTwoBigNum(A, C);
				m2 = multiTwoBigNum(A, D);
				m3 = multiTwoBigNum(B, C);
				m4 = multiTwoBigNum(B, D);
				
				
				int soptb = B.sopt;
				int soptd = D.sopt;
					
				if(B == K)
					soptb = 0;
				else if(D == K)
					soptd = 0;
					
				n1 = m1.nhanVoi10Mu(soptb+soptd);
				n2 = m2.nhanVoi10Mu(soptb);
				n3 = m3.nhanVoi10Mu(soptd);
					
				p1 = cong2BigNum(n1, n2);
				p2 = cong2BigNum(n3, m4);
				p3 = cong2BigNum(p1, p2);
					
				kq.sopt = p3.sopt;
				kq.value = p3.value;
				
			}

		}
		return kq;
	}
	
	public BigNum nhanVoi10Mu(int n) {
		BigNum kq = new BigNum();
		kq.sopt = sopt+n;
		kq.value = new int[kq.sopt];
		int i = 0;
		for(i=0; i<sopt; i++) {
			kq.value[i] = value[i];
		}
		for(i=sopt; i<n; i++) {
			kq.value[i] = 0;
		}
		
		/*Khai báo mảng tạm a với số pt bằng số pt của value cộng thêm n
		int a[] = new int[kq.sopt];
		
		Đổ giá trị mảng value vào mảng a
		int i = 0;
		while(i < value.length){
			a[i] = value[i];	//Lấy dấu = ĐK while sẽ vượt quá chỉ số mảng value
			i += 1;
		}
		int j = 0;
		//Thêm n pt 0 vào cuối mảng a
		while(j < n) {
			a[i] = 0;
			i += 1;
			j += 1;
		}*/
		
		return kq;
	}
	//Tested
	
	public BigNum cong2BigNum(BigNum X, BigNum Y) {
		//Cộng 2 BigNum: Cộng 2 mảng 1C value
		//theo nguyên tắc cộng từ hàng đơn vị đi lên
		BigNum kq = new BigNum();
		BigNum nganhon = new BigNum();
		BigNum daihon = new BigNum();

		int i = 0, j = 0; 	//biến chạy lùi cho mảng value của 2 bignum X, Y
		int k = 0;			//biến chỉ số mảng tạm a, chạy tăng
		int biennho = 0;
		int tong = 0;
		
		//BigNum nào có số lượng pt ít hơn thì làm chuẩn
		nganhon = (X.sopt>Y.sopt)?Y:X;
		daihon = (X.sopt>Y.sopt)?X:Y;
		
		/* Khai báo mảng a để lưu kết quả phép cộng
		Dù 2 BigNum có số chữ số khác nhau
		Nhưng khai báo BigNum tối đa là k chữ số (ở đây: k=15)
		Nên tổng 2 BigNum này tối đa chỉ có (k+1) chữ số */
		int []a = new int[MAX+1];
		
		//B1: Cộng lần lượt từ hàng đơn vị đi lên 
		//cho đến khi hết duyệt hết BigNum làm chuẩn
		int h = 0; 			//Biến chạy lùi cho mảng value của bignum lamchuan
		for(i = X.sopt-1, j = Y.sopt-1, h = nganhon.sopt-1; h >= 0; i--, j--, h--){
			//Cẩn thận ko chạy từ: X.value.length - 1
			tong = X.value[i] + Y.value[j];
			if(tong >= 10) {
				if(biennho == 1)
					a[k] = tong%10+biennho;
				else
					a[k] = tong%10;
				biennho = 1;	//khi tổng>=10 thì nhớ 1
			}
			else {
				if(biennho == 1) 
					a[k] = tong+biennho;
				else
					a[k] = tong;
				biennho = 0; 	//reset lại biến nhớ khi tổng<10
			}
			k += 1;
			tong = 0;
			//chạy lùi cho đến khi hết số pt của BigNum nganhon thì dừng
		}
		
		//Nếu số pt của X nhiều hơn của Y thì Y đã duyệt xong 
		//nên ta gán vt dừng là chỉ số của mảng X và ngược lại
		int vtdung = (X.sopt>Y.sopt)?i:j;
		int l = 0;
		for(l = vtdung; l >= 0; l--) {
			if(biennho == 1) {
				tong = daihon.value[l] + biennho;
				if(tong == 10) {
					a[k] = 0;
					biennho = 1;
				}
				else {
					a[k] = tong;
					biennho = 0;
				}
			}
			else
				a[k] = daihon.value[l];			
			k += 1;
		}
		
		//Nếu đến cuối cùng mà biến nhớ vẫn còn bằng 1 
		//thì ta thêm trước kq phép cộng chữ số 1
		if(biennho == 1)
			a[k++] = 1;
		
		kq.sopt = k;
		kq.value = daoMang(a, k);
			
		return kq;
	}
	//Tested
	
	public int[] daoMang(int a[], int n) {
		int[] b = new int[n];
		int t = 0;
		for(int i=n-1; i>=0; i--) {
			b[t] = a[i];
			t++;
		}
		return b;
	}
	//Tested
	
	public void convertNumToArr(int x, int[] value)
	{
		if(x<10)
			value[0] = x;
		else{
			value[0] = x/10;
			value[1] = x%10;
		}
	}
	//Tested
	
	public void xuatBigNum()
	{
		/*Nếu lấy i<value.length thì sẽ in ra thêm những số 0 
		vô nghĩa đằng sau cho đủ MAX phần tử của mảng value*/
		if(sign == -1)
			System.out.print("-");
		for(int i=0; i<sopt; i++)
			System.out.print(value[i]);
	}
	//Tested

}
