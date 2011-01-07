/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.*;
import java.util.*;

import myUtils.*;
import EL.*;

/**
 *
 * @author Administrator
 */

/* DataAccessObject: direct interactive with DB, not check validation */
public class AccountDAO {
    /* business methods */
    public List<Account> selectAll() throws Exception {
        List<Account> accounts = new ArrayList<Account>();

        Connection con = JdbcConnector.open();
        String sql = "SELECT * FROM Account";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            Account account = new Account(username, password);
            accounts.add(account);
        }
        JdbcConnector.close(con);

        return accounts;
    }

    public Account selectByUsername(String username) throws Exception {
        Account account = new Account();
        return account;
    }

    public boolean insert(Account account) throws Exception {
        Connection con = JdbcConnector.open();

        // using PreparedStatement
        /*String sql = "INSERT INTO Account(Username,Password) VALUES(?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, account.getUsername());
        pst.setString(2, account.getPassword());
        int rows = pst.executeUpdate();*/

        // using CallableStatement
        String sql = "{call sp_Account_Insert(?,?)}";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, account.getUsername());
        cst.setString(2, account.getPassword());
        int rows = cst.executeUpdate();

        JdbcConnector.close(con);
        if (rows > 0)   return true;
        else            return false;
    }

    public boolean update(Account account) throws Exception {
        return false;
    }

    public boolean delete(String username) throws Exception {
        return false;
    }
}