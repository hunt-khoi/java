package ChiaDeTri;
import java.util.Comparator;

public class Xe {
	double giathue;
	int socho;
	int soluonglay;
	
	public double tinhDonGia(){
		return giathue/socho;
	}
	
	public void xuatXe(){
		String s = "Xe "+socho+" chỗ \tGiá thuê: "+giathue+"\t\tSố lượng lấy: "+soluonglay;
		System.out.println(s);
	}
	
	public static Comparator<Xe> XeReal = new Comparator<Xe>() {
		@Override
		public int compare(Xe o1, Xe o2) {
			// TODO Auto-generated method stub
			if(o1.tinhDonGia() < o2.tinhDonGia())
				return -1;
			else{
				if(o1.tinhDonGia() == o2.tinhDonGia())
					return 0;
				return 1;
			}
		}
	};
}
