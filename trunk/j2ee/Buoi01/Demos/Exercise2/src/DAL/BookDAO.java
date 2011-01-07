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
public class BookDAO {
    /* business methods */
    public List<Book> selectAll() throws Exception {
        List<Book> books = new ArrayList<Book>();

        Connection con = JdbcConnector.open();
        String sql = "SELECT * FROM Book";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Book book = new Book(rs.getInt("BookCode"), rs.getString("BookName"), rs.getString("BookAuthor"), rs.getInt("BookPrice"));
            books.add(book);
        }
        JdbcConnector.close(con);

        return books;
    }

    public Book selectByCode(int code) throws Exception {
        Book book = new Book();

        Connection con = JdbcConnector.open();
        String sql = "SELECT * FROM Book WHERE BookCode=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, code);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            book.setCode(rs.getInt("BookCode"));
            book.setName(rs.getString("BookName"));
            book.setAuthor(rs.getString("BookAuthor"));
            book.setPrice(rs.getInt("BookPrice"));
        }
        JdbcConnector.close(con);

        return book;
    }

    public List<Book> selectByName(String name) throws Exception {
        List<Book> books = new ArrayList<Book>();

        Connection con = JdbcConnector.open();
        String sql = "SELECT * FROM Book WHERE BookName LIKE '%" + name + "%'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Book book = new Book(rs.getInt("BookCode"), rs.getString("BookName"), rs.getString("BookAuthor"), rs.getInt("BookPrice"));
            books.add(book);
        }
        JdbcConnector.close(con);

        return books;
    }

    public List<Book> selectByAuthor(String author) throws Exception {
        List<Book> books = new ArrayList<Book>();

        Connection con = JdbcConnector.open();
        String sql = "SELECT * FROM Book WHERE BookAuthor=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, author);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Book book = new Book(rs.getInt("BookCode"), rs.getString("BookName"), rs.getString("BookAuthor"), rs.getInt("BookPrice"));
            books.add(book);
        }
        JdbcConnector.close(con);

        return books;
    }

    public boolean insert(Book book) throws Exception {
        Connection con = JdbcConnector.open();
        String sql = "INSERT INTO Book(BookName,BookAuthor,BookPrice) VALUES(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, book.getName());
        pst.setString(2, book.getAuthor());
        pst.setInt(3, book.getPrice());
        int rows = pst.executeUpdate();
        JdbcConnector.close(con);

        if (rows > 0)   return true;
        else            return false;
    }

    public boolean update(Book book) throws Exception {
        Connection con = JdbcConnector.open();
        String sql = "UPDATE Book SET BookName=?,BookAuthor=?,BookPrice=? WHERE BookCode=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, book.getName());
        pst.setString(2, book.getAuthor());
        pst.setInt(3, book.getPrice());
        pst.setInt(4, book.getCode());
        int rows = pst.executeUpdate();
        JdbcConnector.close(con);

        if (rows > 0)   return true;
        else            return false;
    }

    public boolean delete(int code) throws Exception {
        Connection con = JdbcConnector.open();
        String sql = "DELETE FROM Book WHERE BookCode=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, code);
        int rows = pst.executeUpdate();
        JdbcConnector.close(con);

        if (rows > 0)   return true;
        else            return false;
    }
}
