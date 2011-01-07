package men.org.ui;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;

import men.org.components.DataGridView;
import men.org.helper.ConnectionFactory;

public class SinhvienFrame extends JFrame{
	public SinhvienFrame() {
		setTitle("Danh sách sv");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		try {
			FileData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void FileData()throws Exception{
		Connection con=ConnectionFactory.getConnectionInstance();
		String sql="select * from DimAccount";
		ResultSet rs=con.prepareStatement(sql).executeQuery();
		DataGridView p=new DataGridView(rs);
		this.add(p,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new SinhvienFrame().setVisible(true);
	}
}
