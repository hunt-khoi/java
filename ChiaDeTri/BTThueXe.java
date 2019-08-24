package ChiaDeTri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BTThueXe {
	//Giải bái toán theo kỹ thuật tham lam (PA chỉ tốt nhất có thể)
		//Vì chọn sao cho người được đi xe là nhiều nhất có thể
		//và tiền thuê xe là ít nhất
		//nên ta tính đơn giá 1 chỗ bằng giá thuê chia cho số chỗ ngồi
		//sx đơn giá tăng dần và chọn xe có đơn giá thấp nhất trước
		
		ArrayList<Xe> dsxe = new ArrayList<>();
		ArrayList<Xe> dsxechon = new ArrayList<>();
		int N = 3;  //số loại xe
		int V = 0;	//số hướng dẫn viên
		int W;		//số người đi xe
		
		Scanner sc = new Scanner(System.in);
		
		public void nhapDSXe(){
			int[] loaicho = new int[]{16, 29, 50};
			double giathue = 0;
			for(int i=0; i<N; i++){
				System.out.print("Nhập giá thuê xe "+loaicho[i]+" chỗ: ");
				giathue = sc.nextDouble();
				
				Xe xe = new Xe();
				xe.giathue = giathue;
				xe.socho = loaicho[i];
				dsxe.add(xe);
			}	
		}
		
		public void chonXe(){
			//SX danh sách xe theo đơn giá tăng dần
			Collections.sort(dsxe, Xe.XeReal);
			
			//Chọn các xe vào ds chọn theo thứ tự đơn gía tăng dần
			int i = 0;
			int soluonglay;
			//Đk dừng: hết số người ngồi hoặc xét hết xe
			while(W > 0 && i < dsxe.size()){
				soluonglay = W/dsxe.get(i).socho;
				
				if(soluonglay != 0)
				{
					Xe xechon= new Xe();
					xechon.soluonglay = soluonglay;
					xechon.giathue = dsxe.get(i).giathue;
					xechon.socho = dsxe.get(i).socho;
					dsxechon.add(xechon);
				}
				W -= soluonglay * dsxe.get(i).socho;
				i+=1;
				
				soluonglay = 0;
			}
		}
		
		public void xuatDSXe() {
			for (Xe xechon : dsxe) {
				xechon.xuatXe();
			}
		}
		public int tinhSoHDV(){
			for (Xe xechon : dsxechon) {
				V += xechon.soluonglay;
			}
			return V;
		}
		
		public double tinhTienThue() {
			double tienthue = 0;
			for (Xe xechon : dsxechon) {
				tienthue += xechon.giathue*xechon.soluonglay;
			}
			return tienthue;
		}
		public void xuatXeChon() {
			for (Xe xechon : dsxechon) {
				xechon.xuatXe();
			}
		}
		
		public void thucThiThueXe(){
			System.out.println("----------------------------------------");
			do{
				System.out.print("Nhập số lượng nhân viên tham quan (0;300]: ");
				W = sc.nextInt();
			}while(W>300 || W<0);
			System.out.println("Nhập danh sách xe: ");
			nhapDSXe();
			System.out.println("Danh sách xe là: ");
			xuatDSXe();
			
			chonXe();
			System.out.println("Danh sách xe dược chọn là: ");
			xuatXeChon();
			System.out.println("Tổng tiền thuê xe là: "+tinhTienThue());
			System.out.println("Số hướng dẫn viên theo đoàn là: "+tinhSoHDV());
			System.out.println("----------------------------------------");
		}
}
