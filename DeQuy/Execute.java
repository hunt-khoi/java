package DeQuy;
import java.util.Scanner;

public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thucThi();
	}
	
	public static void hienThi(){
		System.out.println("  BAI TAP THUC HANH TUAN 2 ");
		System.out.println(" 1. Tinh tong S1: ");
		System.out.println(" 2. Tinh tong S2: ");
		System.out.println(" 3. Tinh tong S3: ");
		System.out.println(" 4. Dem so chu so cua so nguyen duong: ");
		System.out.println(" 5. Dem so chu so chan cua so nguyen duong: ");
		System.out.println(" 6. Xuat so dang nhi phan: ");
		System.out.println(" 7. Xuat so dang thap luc phan: ");
		
	}
	
	public static void thucThi(){
		int chonchucnang, x;
		double y;
		String[] temp = new String[100];
		String[] b = new String[100];
		CanBan cb = new CanBan();
		int n;
		do{
			hienThi();
			Scanner sc = new Scanner(System.in);
			System.out.print("Chon chuc nang: ");
			chonchucnang = sc.nextInt();
			switch(chonchucnang){
				case 1:
					do{
						System.out.print("Nhap so nguyen duong n: ");
						n = sc.nextInt();
					}while(n<=0);
					y = (double)Math.round(cb.tinhS9_DQ(n)*100)/100;
					System.out.println("Tong de quy la: "+y);
					break;
				case 2:
					do{
						System.out.print("Nhap so nguyen duong n: ");
						n = sc.nextInt();
					}while(n<=0);
					y = (double)Math.round(cb.tinhS10_DQ(n)*100)/100;
					System.out.println("Tong de quy la: "+y);
					break;
				case 3:
					do{
						System.out.print("Nhap so nguyen duong n: ");
						n = sc.nextInt();
					}while(n<=0);
					y = (double)Math.round(cb.tinhS11_DQ(n)*100)/100;
					System.out.println("Tong de quy la: "+y);
					break;
				case 4:
					do{
						System.out.print("Nhap so nguyen duong can dem: ");
						n = sc.nextInt();
					}while(n<=0);
					System.out.println("So co "+cb.demSoChuSo(n)+" chu so");
					break;
				case 5:
					do{
						System.out.print("Nhap so nguyen duong can dem: ");
						n = sc.nextInt();
					}while(n<=0);
					System.out.println("So co "+cb.demSoChuSoChan(n)+" chu so chan");
					break;
				case 6:
					do{
						System.out.print("Nhap so thap phan can chuyen: ");
						n = sc.nextInt();
					}while(n<0);
					/*temp = hdq.soHe2(n, b, 100);
					System.out.print("So dang nhi phan la: ");
					for(int i=0; i<temp.length; i++) {
						if(temp[i] != null)
							System.out.print(temp[i]);
					System.out.println();
					}*/
					x = cb.soHe2(n);
					System.out.println("So dang nhi phan la: "+x);
					break;
				case 7:
					do{
						System.out.print("Nhap so thap phan can chuyen: ");
						n = sc.nextInt();
					}while(n<0);
					temp = cb.soHe16(n, b, 100);
					System.out.print("So dang thap luc phan la: ");
					for(int i=0; i<temp.length; i++) {
						if(temp[i] != null)
							System.out.print(temp[i]);
					}
					System.out.println();
					break;

			}
		}while(chonchucnang != 0);
	}
	
}
