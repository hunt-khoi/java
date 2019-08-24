package ChiaDeTri;

public class Main_BigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigNum a = new BigNum();
		a.sign = 1;
		a.sopt = 4;
		a.value = new int[] {9, 9, 9, 9};
		
		BigNum b = new BigNum();
		b.sign = -1;
		b.sopt = 4;
		b.value = new int[] {9, 9, 9, 9};
		
		//kt lại 9999*9999
		
		BigNum goi = new BigNum();
		BigNum kq = new BigNum();
		
		//kq = a.nhanVoi10Mu(3);
		//kq = goi.cong2BigNum(a, b);
		kq = goi.multiTwoBigNum(a, b);
		kq.xuatBigNum();
	}

}
