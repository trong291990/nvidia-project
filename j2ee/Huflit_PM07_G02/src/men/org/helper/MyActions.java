package men.org.helper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import men.org.descript.Sinhvien;

/**
 * các hành vi CRUD
 * @author VoVanHai
 *
 */
public class MyActions {
	/**
	 * Phương thuc them sv
	 * @param sv la sinh vien can them
	 * @return true neu them duoc
	 * @throws Exception
	 */
	public boolean ThemSV(Sinhvien sv)throws Exception{
		Connection con=ConnectionFactory.getConnectionInstance();
		String sql="Insert into sinhvien values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, sv.getMssv());
		pstmt.setString(2, sv.getHoten());
		pstmt.setInt(3, sv.getNamsinh());
		int x=pstmt.executeUpdate();
		ConnectionFactory.close();
		return x>0;
	}
	/**
	 * ?????
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Sinhvien> getALLSV()throws Exception{
		Connection con=ConnectionFactory.getConnectionInstance();
		String sql="select * from sinhvien";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ArrayList<Sinhvien>lst=new ArrayList<Sinhvien>();
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Sinhvien s=new Sinhvien(
					rs.getString("mssv"),
					rs.getString("hoten"),
					rs.getInt("namsinh")
			);
			lst.add(s);
		}
		return lst;
	}
	/**
	 * ????
	 * @param fromyear
	 * @param toyear
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Sinhvien> ThongkeSVtheoNS(int fromyear,int toyear)throws Exception{
		Connection con=ConnectionFactory.getConnectionInstance();
		String sql="{call thongkeNS(?,?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setInt(1, fromyear);
		cstmt.setInt(2, toyear);

		ArrayList<Sinhvien>lst=new ArrayList<Sinhvien>();
		ResultSet rs=cstmt.executeQuery();
		while(rs.next()){
			Sinhvien s=new Sinhvien(
					rs.getString("mssv"),
					rs.getString("hoten"),
					rs.getInt("namsinh")
			);
			lst.add(s);
		}
		return lst;
	}
}
