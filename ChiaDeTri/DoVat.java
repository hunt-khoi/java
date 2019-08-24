package ChiaDeTri;
import java.util.Comparator;
import java.util.Scanner;

public class DoVat {
	String tendv;
	double trongluong, giatri, soluong;

	double tinhDonGia() {
		return giatri/trongluong;
	}
	
	public void nhapDoVat() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên đồ vật: ");
		tendv = sc.next();
		do {
			System.out.print("Nhập trọng lượng của vật: ");
			trongluong = sc.nextDouble();
		}while(trongluong <= 0);
		do {
			System.out.print("Nhập giá trị của vật: ");
			giatri = sc.nextDouble();
		}while(giatri <= 0);
		do {
			System.out.print("Nhập số lượng của vật: ");
			soluong = sc.nextDouble();
		}while(soluong <= 0);
	}
	
	public void xuatDoVat() {
		String s = tendv+" Trọng lượng: "+trongluong
				+"\tGiá trị: "+giatri+"\tSố lượng: "+soluong;
		System.out.println(s);
	}
	
	public static Comparator<DoVat> DVReal = new Comparator<DoVat>() {
		@Override
		public int compare(DoVat dv1, DoVat dv2) {
			if(dv1.tinhDonGia()<dv2.tinhDonGia())
    			return -1;
			else {
				if(dv1.tinhDonGia() == dv2.tinhDonGia())
					return 0;
				else
					return 1;
			}
		}
	}; 
	
}
