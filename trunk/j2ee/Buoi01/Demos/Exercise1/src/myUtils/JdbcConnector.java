/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myUtils;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class JdbcConnector {
    /* support methods */
    public static Connection open() throws Exception {
        Properties cfgDB = new Properties();
        cfgDB.load(new java.io.FileInputStream("ConfigDB.properties"));
        
        Class.forName(cfgDB.getProperty("DriverDB"));
	Connection con = DriverManager.getConnection(cfgDB.getProperty("UrlDB"), cfgDB.getProperty("UserDB"), cfgDB.getProperty("PassDB"));
        return con;
    }

    public static void close(Connection con) throws Exception {
        con.close();
    }
}
