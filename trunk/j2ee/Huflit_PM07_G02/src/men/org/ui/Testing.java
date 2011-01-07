package men.org.ui;

import java.util.ArrayList;

import men.org.descript.Sinhvien;
import men.org.helper.MyActions;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		MyActions ac=new MyActions();
		/*Sinhvien s1=new Sinhvien("sv006", "Trần thị Tám", 1991);
		if(ac.ThemSV(s1))
			System.out.println("OK");
		else
			System.out.println("failed");*/
		
		/*ArrayList<Sinhvien>lst=ac.getALLSV();
		for(Sinhvien sv:lst){
			System.out.println(sv.getMssv()+"\t"+sv.getHoten());
		}*/
		ArrayList<Sinhvien>lst=ac.ThongkeSVtheoNS(1990,2000);
		for(Sinhvien sv:lst){
			System.out.println(sv.getMssv()+"\t"
					+sv.getHoten()+"\t"+sv.getNamsinh());
		}
	}

}
