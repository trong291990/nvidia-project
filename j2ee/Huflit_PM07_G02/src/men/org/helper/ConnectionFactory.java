package men.org.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ????????
 * @author VoVanHai
 *
 */
public class ConnectionFactory {
	
	private static Connection con;
	/**
	 * ?????
	 * @return
	 * @author VoVanHai
	 * @throws Exception
	 */
	public static Connection getConnectionInstance()throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String db_url="jdbc:sqlserver://localhost:1433;databaseName=AdventureWorksDW";
		con=DriverManager.getConnection(db_url,"sa","");
		return con;
	}
	/**
	 * 
	 * @throws Exception
	 */
	public static void close()throws Exception{
		if(con!=null)
			con.close();
	}
}
