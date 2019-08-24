package DeQuy;

public class BT_ChiaThuong {
	public int chiaThuong(int m, int n) {
		if(m == 0 || n == 1)
			return 1;
		if(n == 0)
			return 0;
		if(m<n)
			return chiaThuong(m, m);
		return chiaThuong(m, n-1) + chiaThuong(m-n, n);
	}
}
