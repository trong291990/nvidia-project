package men.org.components;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataGridView extends JPanel{
	private JTable table;
	private DefaultTableModel dtm;
	private ResultSet rs;
	public DataGridView(ResultSet rs)throws Exception {
		this.rs=rs;
		this.setBorder(BorderFactory.createTitledBorder("Chi tiết"));
		setLayout(new BorderLayout());
		//xây dựng header
		ResultSetMetaData rmd=rs.getMetaData();
		int cols=rmd.getColumnCount();
		
		String []header=new String[cols];
		for (int i = 0; i < cols; i++) {
			header[i]=rmd.getColumnName(i+1);
		}
		//tạo bảng
		dtm=new DefaultTableModel(header,0);
		table=new JTable(dtm);
		this.add(new JScrollPane(table));
		//đổ dữ liệu vào bảng
		String []row=null;
		while(rs.next()){
			row=new String[cols];
			for (int i = 0; i < cols; i++) {
				row[i]=rs.getString(i+1);
			}
			dtm.addRow(row);
		}
	}
}
