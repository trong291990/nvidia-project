import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Exercise1
{	
	public static void main(String[] args)
	{
		MyFrame mf = new MyFrame("Hello");
  		mf.setSize(300,120);
  		mf.setVisible(true);
	}
}

class MyFrame extends JFrame implements ActionListener
{	
	/* components */
	JTextField tfUsername = new JTextField(20);
	JPasswordField tfPassword = new JPasswordField(20);
	JButton btLogin = new JButton("Login");
	JButton btReset = new JButton("Reset");
	
	/* su dung driver loai 4 (jTDS), voi DatabaseName=VanLangJava */
	String driverDB = "net.sourceforge.jtds.jdbc.Driver";
	String urlDB= "jdbc:jtds:sqlserver://127.0.0.1:4405/VanLangJava";
	
	/* su dung driver loai 1 (JDBC-ODBC), voi DSN=VanLangJava */
	//String driverDB = "sun.jdbc.odbc.JdbcOdbcDriver";
	//String urlDB = "jdbc:odbc:VanLangJava";
	
	String userDB = "sa";
	String passDB = "123456";
	
	public MyFrame(String title)
	{
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initComponents();
		registerListeners();
	}
	
	private void initComponents()
	{
		/* pWest */
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(2,1));
		pWest.add(new JLabel("Username", JLabel.RIGHT));
		pWest.add(new JLabel("Password", JLabel.RIGHT));
		
		/* pEast */
		JPanel pEast = new JPanel();
		pEast.setLayout(new GridLayout(2,1));
		pEast.add(tfUsername);
		pEast.add(tfPassword);
		
		/* pSouth */
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new FlowLayout());
		pSouth.add(btLogin);
		pSouth.add(btReset);
		
		/* add Panels to Frame */
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(pWest, BorderLayout.WEST);
		contentPane.add(pEast, BorderLayout.EAST);
		contentPane.add(pSouth, BorderLayout.SOUTH);
	}
	
	private void registerListeners()
	{
		btLogin.addActionListener(this);
		btReset.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource().equals(btLogin))
				handleLogin();
			else if(ae.getSource().equals(btReset))
				handleReset();
		} catch (Exception ex) { ex.printStackTrace(); }	
	}
	
	private void handleReset()
	{
		tfUsername.setText("");
		tfPassword.setText("");
	}
	
	private void handleLogin() throws Exception
	{
		//boolean isExist = useStatement(tfUsername.getText(), tfPassword.getText());
		//boolean isExist = usePreparedStatement(tfUsername.getText(), tfPassword.getText());
		boolean isExist = useStoreProcedure(tfUsername.getText(), tfPassword.getText());
		if (isExist)
			JOptionPane.showMessageDialog(this, "Valid user");
		else
			JOptionPane.showMessageDialog(this, "Invalid user");
	}
	
	private boolean useStatement(String strUser, String strPass) throws Exception
	{
		boolean result = false;
		
		Class.forName(driverDB);
		Connection con = DriverManager.getConnection(urlDB, userDB, passDB);
		String strSQL = "SELECT * FROM Account WHERE Username='" + strUser + "' AND Password='" + strPass + "'"; // Username = "xxx' OR 1=1 --" --> bi hack
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(strSQL);
		if(rs.next())
			result = true;
		rs.close();
		st.close();
		con.close();
		
		return result;
	}
	
	private boolean usePreparedStatement(String strUser, String strPass) throws Exception
	{
		boolean result = false;
		
		Class.forName(driverDB);
		Connection con = DriverManager.getConnection(urlDB, userDB, passDB);
		String strSQL = "SELECT * FROM Account WHERE Username=? AND Password=?";
		PreparedStatement pst = con.prepareStatement(strSQL);
		pst.setString(1, strUser);
		pst.setString(2, strPass);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			result = true;
		rs.close();
		pst.close();
		con.close();
		
		return result;
	}
	
	private boolean useStoreProcedure(String strUser, String strPass) throws Exception
	{
		boolean result = false;
		
		Class.forName(driverDB);
		Connection con = DriverManager.getConnection(urlDB, userDB, passDB);
		CallableStatement cst = con.prepareCall("{call procCheckAccount(?, ?)}");
		cst.setString(1, strUser);
		cst.setString(2, strPass);
		ResultSet rs = cst.executeQuery();
		if(rs.next())
			result = true;
		rs.close();
		cst.close();
		con.close();
		
		return result;
	}
}
